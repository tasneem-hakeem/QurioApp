package com.example.qurio.model.entity

data class Question(
    val category: String,
    val difficulty: Difficulty,
    val question: String,
    val correctAnswer: String,
    val options: List<String>
)
