package com.courses.businesscard

import android.content.Intent
import androidx.compose.ui.graphics.painter.Painter

data class DeveloperDTO(
    val picture: Painter,
    val name: String,
    val title: String,
    val content: List<Content>
)

data class Content(
    val icon: Painter,
    val text: String,
    val intent: Intent
)
