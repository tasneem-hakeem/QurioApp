package com.example.qurio.model

import com.example.qurio.model.entity.Category
import com.example.qurio.model.entity.Question
import com.example.qurio.model.remote.QurioRepository
import com.example.qurio.model.remote.TriviaApiService
import com.example.qurio.model.remote.dto.toCategory
import com.example.qurio.model.remote.dto.toQuestion
import javax.inject.Inject

class QurioRepositoryImpl @Inject constructor(
    val triviaApiService: TriviaApiService
) : QurioRepository {

    override suspend fun getToken(): String {
        return triviaApiService.getToken().token
    }

    override suspend fun getCategories(): List<Category> {
        val categoriesResponse = triviaApiService.getCategories()
        return categoriesResponse.triviaCategories.map { categoryDTO -> categoryDTO.toCategory() }
    }

    override suspend fun getQuestions(
        amount: Int,
        category: Int?,
        difficulty: String?
    ): List<Question> {
        val token = getToken()
        val questionsResponse = triviaApiService.getQuestions(amount, category, difficulty, token)
        return questionsResponse.results.map { questionDTO -> questionDTO.toQuestion() }
    }
}