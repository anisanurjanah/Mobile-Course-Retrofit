package com.anisanurjanah.fahrameducationcourse.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anisanurjanah.fahrameducationcourse.R
import com.anisanurjanah.fahrameducationcourse.core.ui.CourseAdapter
import com.anisanurjanah.fahrameducationcourse.course.detail.DetailCourseActivity
import com.anisanurjanah.fahrameducationcourse.favorite.databinding.ActivityFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.favorite)

        val courseAdapter = CourseAdapter()
        courseAdapter.onClick = { selectedData ->
            startActivity(
                Intent(this, DetailCourseActivity::class.java)
                .putExtra(DetailCourseActivity.EXTRA_COURSE, selectedData))
        }

        favoriteViewModel.favoriteCourse.observe(this) { data ->
            courseAdapter.setData(data)
            binding.viewEmpty.visibility = if (data.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvCourse) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = courseAdapter
        }
    }
}