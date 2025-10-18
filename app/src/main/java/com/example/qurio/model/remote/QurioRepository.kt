package com.example.qurio.model.remote

import com.example.qurio.model.entity.Category
import com.example.qurio.model.entity.Question

interface QurioRepository {
    suspend fun getToken(): String
    suspend fun getCategories(): List<Category>
    suspend fun getQuestions(amount: Int, category: Int?, difficulty: String?): List<Question>
}