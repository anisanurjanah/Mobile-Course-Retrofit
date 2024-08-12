package com.anisanurjanah.fahrameducation.course

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anisanurjanah.fahrameducation.course.detail.DetailCourseActivity
import com.anisanurjanah.fahrameducationcourse.R
import com.anisanurjanah.fahrameducationcourse.core.data.source.Resource
import com.anisanurjanah.fahrameducationcourse.core.ui.CourseAdapter
import com.anisanurjanah.fahrameducationcourse.databinding.FragmentCourseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseFragment : Fragment() {

    private val courseViewModel: CourseViewModel by viewModel()

    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val courseAdapter = CourseAdapter()
        courseAdapter.onClick = { selectedData ->
            startActivity(Intent(activity, DetailCourseActivity::class.java)
                .putExtra(DetailCourseActivity.EXTRA_COURSE, selectedData))
            }

        courseViewModel.course.observe(viewLifecycleOwner) { course ->
            course?.let {
                when (course) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        courseAdapter.setData(course.data)
                    }
                    is Resource.Error -> {
                        showLoading(false)
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text =
                            course.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        }

        with(binding.rvCourse) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = courseAdapter
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}