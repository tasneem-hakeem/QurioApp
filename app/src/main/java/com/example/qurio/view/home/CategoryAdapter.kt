package com.example.qurio.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qurio.R
import com.example.qurio.databinding.ItemCategoryBinding
import com.example.qurio.model.entity.Category

class CategoryAdapter(
    var categories: List<Category>,
    private val onCategoryClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position], onCategoryClick)
    }

    override fun getItemCount() = categories.size

    class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category, onCategoryClick: (Category) -> Unit) {
            binding.categoryName.text = category.name
            binding.categoryImage.setImageResource(getImagesForCategory(category.id))
            itemView.setOnClickListener { onCategoryClick(category) }
        }

        private fun getImagesForCategory(categoryId: Int): Int {
            return when (categoryId) {
                9 -> R.drawable.knowledge
                10, 11, 14 -> R.drawable.tv
                12, 13 -> R.drawable.music
                in 15..16 -> R.drawable.music
                in 17..20 -> R.drawable.science
                21 -> R.drawable.sport
                22 -> R.drawable.geography
                23, 24 -> R.drawable.history
                25 -> R.drawable.art
                26 -> R.drawable.people
                27 -> R.drawable.geography
                else -> R.drawable.science
            }
        }
    }
}