package com.anisanurjanah.fahrameducationcourse.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anisanurjanah.fahrameducationcourse.core.databinding.ItemListCourseBinding
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Course
import com.bumptech.glide.Glide

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private var data = ArrayList<Course>()
    var onClick: ((Course) -> Unit)? = null

    inner class CourseViewHolder(private val binding: ItemListCourseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Course) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(ivCourse)
                tvCourseTitle.text = data.title
                tvCourseExcerpt.text = data.excerpt

                root.setOnClickListener {
                    onClick?.invoke(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemListCourseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return CourseViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val data = data[position]
        holder.bind(data)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Course>?) {
        if (newListData == null) return
        data.clear()
        data.addAll(newListData)
        notifyDataSetChanged()
    }
}
