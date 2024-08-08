package com.anisanurjanah.fahrameducationcourse.core.data.source.remote

import android.util.Log
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.network.ApiResponse
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.network.ApiService
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.CourseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAllCourse(): Flow<ApiResponse<List<CourseItem>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.data
                if (dataArray.isNotEmpty()) emit(ApiResponse.Success(response.data))
                else emit(ApiResponse.Empty)
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}