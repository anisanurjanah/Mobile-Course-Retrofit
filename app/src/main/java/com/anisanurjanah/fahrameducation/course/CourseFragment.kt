package com.anisanurjanah.fahrameducation.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anisanurjanah.fahrameducationcourse.databinding.FragmentCourseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseFragment : Fragment() {

    private val courseViewModel: CourseViewModel by viewModel()

    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}