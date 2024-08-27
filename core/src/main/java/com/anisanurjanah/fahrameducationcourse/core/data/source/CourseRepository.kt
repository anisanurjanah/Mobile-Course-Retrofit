package com.anisanurjanah.fahrameducationcourse.core.data.source

import com.anisanurjanah.fahrameducationcourse.core.data.source.local.LocalDataSource
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.RemoteDataSource
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.network.ApiResponse
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.article.ArticleItem
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.course.CourseItem
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Article
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Course
import com.anisanurjanah.fahrameducationcourse.core.domain.repository.ICourseRepository
import com.anisanurjanah.fahrameducationcourse.core.utils.AppExecutors
import com.anisanurjanah.fahrameducationcourse.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class CourseRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ICourseRepository {

    override fun getAllCourse(): Flow<Resource<List<Course>>> =
        object : NetworkBoundResource<List<Course>, List<CourseItem>>() {
            override fun loadFromDB(): Flow<List<Course>> {
                return localDataSource.getAllCourse().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Course>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<CourseItem>>> =
                remoteDataSource.getAllCourse()

            override suspend fun saveCallResult(data: List<CourseItem>) {
                val courseList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertCourse(courseList)
            }
        }.asFlow()

    override fun getFavoriteCourse(): Flow<List<Course>> {
        return localDataSource.getFavoriteCourse().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteCourse(course: Course, state: Boolean) {
        val courseEntity = DataMapper.mapDomainToEntity(course)
        appExecutors.diskIO().execute { localDataSource.setFavoriteCourse(courseEntity, state) }
    }

    override fun getAllArticle(): Flow<Resource<List<Article>>> =
        object : NetworkBoundResource<List<Article>, List<ArticleItem>>() {
            override fun loadFromDB(): Flow<List<Article>> {
                return flowOf(emptyList())
            }

            override fun shouldFetch(data: List<Article>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<ArticleItem>>> =
                remoteDataSource.getAllArticle()

            override suspend fun saveCallResult(data: List<ArticleItem>) {}
        }.asFlow()
}