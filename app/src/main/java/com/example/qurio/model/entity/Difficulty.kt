package com.example.qurio.model.entity

enum class Difficulty(val value: String) {
    EASY(Constant.EASY),
    MEDIUM(Constant.MEDIUM),
    HARD(Constant.HARD);
}

object Constant {
    const val EASY = "easy"
    const val MEDIUM = "medium"
    const val HARD = "hard"
}