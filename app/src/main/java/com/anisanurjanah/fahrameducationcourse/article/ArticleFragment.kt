package com.anisanurjanah.fahrameducationcourse.article

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anisanurjanah.fahrameducationcourse.R
import com.anisanurjanah.fahrameducationcourse.article.detail.DetailArticleActivity
import com.anisanurjanah.fahrameducationcourse.core.data.source.Resource
import com.anisanurjanah.fahrameducationcourse.core.ui.ArticleAdapter
import com.anisanurjanah.fahrameducationcourse.databinding.FragmentArticleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleFragment : Fragment() {

    private val articleViewModel: ArticleViewModel by viewModel()

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleAdapter = ArticleAdapter()
        articleAdapter.onClick = { selectedData ->
            startActivity(
                Intent(activity, DetailArticleActivity::class.java)
                .putExtra(DetailArticleActivity.EXTRA_ARTICLE, selectedData))
        }

        articleViewModel.article.observe(viewLifecycleOwner) { article ->
            article?.let {
                when (article) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        articleAdapter.setData(article.data)
                    }
                    is Resource.Error -> {
                        showLoading(false)
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text =
                            article.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        }

        with(binding.rvArticle) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = articleAdapter
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