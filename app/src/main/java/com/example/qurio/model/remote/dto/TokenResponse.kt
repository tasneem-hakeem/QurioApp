package com.example.qurio.model.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    val token: String
)