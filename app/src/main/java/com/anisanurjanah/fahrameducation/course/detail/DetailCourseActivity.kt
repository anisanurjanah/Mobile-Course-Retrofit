package com.anisanurjanah.fahrameducation.course.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.anisanurjanah.fahrameducationcourse.R
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Course
import com.anisanurjanah.fahrameducationcourse.databinding.ActivityDetailCourseBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCourseActivity : AppCompatActivity() {

    private val detailCourseViewModel: DetailCourseViewModel by viewModel()

    private lateinit var binding: ActivityDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val course = intent.getParcelableExtra<Course>(EXTRA_COURSE)
        course?.let {
//            setupToolbar(it.title)
            setupCourseDetail(it)
        }
    }

//    private fun setupToolbar(title: String) {
//        with(binding) {
//            supportActionBar?.title = title
//            toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
//            toolbar.setNavigationOnClickListener {
//                onBackPressedDispatcher.onBackPressed()
//            }
//        }
//    }

    private fun setupCourseDetail(course: Course?) {
        course?.let {
            supportActionBar?.title = course.title
            binding.apply {
                Glide.with(this@DetailCourseActivity)
                    .load(course.image)
                    .into(ivCourseImage)
                content.courseTitle.text = course.title
                content.coursePath.text = course.path
                content.courseExcerpt.text = course.excerpt
                content.courseSlug.text = course.slug
                content.teacherName.text = course.teacher
                Glide.with(this@DetailCourseActivity)
                    .load(course.teacherImage)
                    .into(content.teacherImage)
                content.courseLevel.text = course.level
                content.courseView.text = course.view.toString()
                content.courseModule.text = course.module.toString()
                content.publishedAt.text = course.publishedAt

                var statusFavorite = course.isFavorite
                setStatusFavorite(course.isFavorite)
                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailCourseViewModel.setFavoriteCourse(course, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        else binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border))
    }

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }
}