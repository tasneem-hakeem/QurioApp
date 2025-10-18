package com.example.qurio.model.remote.dto

import com.example.qurio.model.entity.Category
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponse(
    @SerialName("trivia_categories")
    val triviaCategories: List<CategoryDTO>,
)

@Serializable
data class CategoryDTO(
    val id: Int,
    val name: String
)

fun CategoryDTO.toCategory(): Category {
    return Category(
        id = this.id,
        name = this.name
    )
}