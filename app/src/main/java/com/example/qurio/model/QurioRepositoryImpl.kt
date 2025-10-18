package com.example.qurio.model

import android.util.Log
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
        try{
            val categoriesResponse = triviaApiService.getCategories()
            Log.d("QurioRepositoryImpl", "getCategories: $categoriesResponse")
            return categoriesResponse.triviaCategories.map { categoryDTO -> categoryDTO.toCategory() }
        } catch (e: Exception) {
            Log.e("QurioRepositoryImpl", "Error fetching categories", e)
            return categories
        }
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

    companion object {
        val categories: List<Category> = listOf(
            Category(9, "General Knowledge"),
            Category(10, "Entertainment: Books"),
            Category(11, "Entertainment: Film"),
            Category(12, "Entertainment: Music"),
            Category(13, "Entertainment: Musicals & Theatres"),
            Category(14, "Entertainment: Television"),
            Category(15, "Entertainment: Video Games"),
            Category(16, "Entertainment: Board Games"),
            Category(17, "Science & Nature"),
            Category(18, "Science: Computers"),
            Category(19, "Science: Mathematics"),
            Category(20, "Mythology"),
            Category(21, "Sports"),
            Category(22, "Geography"),
            Category(23, "History"),
            Category(24, "Politics"),
            Category(25, "Art"),
            Category(26, "Celebrities"),
            Category(27, "Animals"),
            Category(28, "Vehicles"),
            Category(29, "Entertainment: Comics"),
            Category(30, "Science: Gadgets"),
            Category(31, "Entertainment: Japanese Anime & Manga"),
            Category(32, "Entertainment: Cartoon & Animations")
        )
    }
}