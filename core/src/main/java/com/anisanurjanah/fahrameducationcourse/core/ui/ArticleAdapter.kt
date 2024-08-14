package com.anisanurjanah.fahrameducationcourse.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anisanurjanah.fahrameducationcourse.core.databinding.ItemListArticleBinding
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Article
import com.bumptech.glide.Glide

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private var data = ArrayList<Article>()
    var onClick: ((Article) -> Unit)? = null

    inner class ArticleViewHolder(private val binding: ItemListArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Article) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(articleImage)
                articleTitle.text = data.title
                articleAuthor.text = data.author

                root.setOnClickListener {
                    onClick?.invoke(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemListArticleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ArticleViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = data[position]
        holder.bind(data)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Article>?) {
        if (newListData == null) return
        data.clear()
        data.addAll(newListData)
        notifyDataSetChanged()
    }
}
