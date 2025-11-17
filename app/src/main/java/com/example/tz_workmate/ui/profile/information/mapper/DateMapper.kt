package com.example.tz_workmate.ui.profile.information.mapper

import java.text.SimpleDateFormat
import java.util.Locale

object DateMapper {
    fun map(inputDate: String): String {
        val inputFormat = SimpleDateFormat(INPUT_FORMAT, Locale.getDefault())
        val outputFormat = SimpleDateFormat(OUTPUT_FORMAT, Locale.getDefault())
        val outputDate = inputFormat.parse(inputDate)
        return outputFormat.format(outputDate)
    }

    private const val INPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    private const val OUTPUT_FORMAT = "yyyy-MM-dd"

}