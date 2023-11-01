package com.sickdev.noteappkmm.domain.note

import com.sickdev.noteappkmm.presentation.BabyBlueHex
import com.sickdev.noteappkmm.presentation.LightGreenHex
import com.sickdev.noteappkmm.presentation.RedOrangeHex
import com.sickdev.noteappkmm.presentation.RedPinkHex
import com.sickdev.noteappkmm.presentation.VioletHex
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, VioletHex)

        fun generateRandomColor() = colors.random()
    }
}
