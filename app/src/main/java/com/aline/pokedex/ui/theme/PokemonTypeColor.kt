package com.aline.pokedex.ui.theme

import androidx.compose.ui.graphics.Color

fun getTypeColor(type: String): Color {
    return when (type.lowercase()) {
        "fire" -> Color(0xFFFF7043)
        "water" -> Color(0xFF42A5F5)
        "grass" -> Color(0xFF66BB6A)
        "electric" -> Color(0xFFFFEB3B)
        "psychic" -> Color(0xFFEC407A)
        "ice" -> Color(0xFF26C6DA)
        "dragon" -> Color(0xFF7E57C2)
        "dark" -> Color(0xFF37474F)
        "fairy" -> Color(0xFFF06292)
        "bug" -> Color(0xFFAED581)
        "rock" -> Color(0xFFBCAAA4)
        "ground" -> Color(0xFF8D6E63)
        "fighting" -> Color(0xFFE57373)
        "poison" -> Color(0xFFBA68C8)
        "ghost" -> Color(0xFF9575CD)
        "normal" -> Color(0xFFBDBDBD)
        else -> Color(0xFF90A4AE)
    }
}