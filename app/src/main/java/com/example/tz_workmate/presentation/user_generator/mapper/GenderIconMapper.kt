package com.example.tz_workmate.presentation.user_generator.mapper

import com.example.tz_workmate.R

object GenderIconMapper {
    fun map(icon: String) = when (icon) {
        "ic_male" -> R.drawable.ic_male
        "ic_female" -> R.drawable.ic_female
        "ic_random" -> R.drawable.ic_random
        else -> 0
    }
}