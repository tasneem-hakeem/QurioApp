package com.example.qurio.model.remote.dto

import com.example.qurio.model.entity.Constant
import com.example.qurio.model.entity.Difficulty
import com.example.qurio.model.entity.Question
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionsResponse(
    val results: List<QuestionDTO>
)

@Serializable
data class QuestionDTO(
    val type: String,
    val difficulty: String,
    val category: String,
    val question: String,
    @SerialName("correct_answer")
    val correctAnswer: String,
    @SerialName("incorrect_answers")
    val incorrectAnswers: List<String>
)

fun QuestionDTO.toQuestion(): Question {
    return Question(
        category = this.category,
        difficulty = when (this.difficulty.lowercase()) {
            Constant.EASY -> Difficulty.EASY
            Constant.MEDIUM -> Difficulty.MEDIUM
            Constant.HARD -> Difficulty.HARD
            else -> Difficulty.EASY
        },
        question = this.question,
        correctAnswer = this.correctAnswer,
        options = this.incorrectAnswers
    )
}