package com.anisanurjanah.fahrameducationcourse.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.anisanurjanah.fahrameducationcourse.R
import com.anisanurjanah.fahrameducationcourse.databinding.FragmentHomeBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupImage()
        setupAction()
    }

    private fun setupImage() {
        val image = "https://fahram.dev/img/logo.webp"
        Glide.with(requireContext())
            .load(image)
            .placeholder(R.drawable.ic_image)
            .into(binding.imageLogo)
    }

    private fun setupAction() {
        binding.taskButton.setOnClickListener {
            Toast.makeText(requireContext(),
                getString(R.string.coming_soon), Toast.LENGTH_SHORT).show()
        }

        binding.articlesButton.setOnClickListener {
            Toast.makeText(requireContext(),
                getString(R.string.coming_soon), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}