package com.example.tz_workmate.presentation.user_generator.mapper

import com.example.tz_workmate.R

object CountryImageMapper {
    fun mapFlagNameToResourceId(flagName: String): Int {
        return when (flagName) {
            "flag_austria" -> R.drawable.flag_austria
            "flag_brazil" -> R.drawable.flag_brazil
            "flag_canada" -> R.drawable.flag_canada
            "flag_switzerland" -> R.drawable.flag_switzerland
            "flag_germany" -> R.drawable.flag_germany
            "flag_denmark" -> R.drawable.flag_denmark
            "flag_spain" -> R.drawable.flag_spain
            "flag_finland" -> R.drawable.flag_finland
            "flag_france" -> R.drawable.flag_france
            "flag_united_kingdom" -> R.drawable.flag_united_kingdom
            "flag_india" -> R.drawable.flag_india
            "flag_iran" -> R.drawable.flag_iran
            "flag_mexico" -> R.drawable.flag_mexico
            "flag_netherlands" -> R.drawable.flag_netherlands
            "flag_norway" -> R.drawable.flag_norway
            "flag_serbia" -> R.drawable.flag_serbia
            "flag_turkey" -> R.drawable.flag_turkey
            "flag_usa" -> R.drawable.flag_usa
            else -> 0
        }
    }

    fun mapCodeToResourceId(flagName: String): Int {
        return when (flagName) {
            "AU" -> R.drawable.flag_austria
            "BR" -> R.drawable.flag_brazil
            "CA" -> R.drawable.flag_canada
            "CH" -> R.drawable.flag_switzerland
            "DE" -> R.drawable.flag_germany
            "DK" -> R.drawable.flag_denmark
            "ES" -> R.drawable.flag_spain
            "FI" -> R.drawable.flag_finland
            "FR" -> R.drawable.flag_france
            "GB" -> R.drawable.flag_united_kingdom
            "IN" -> R.drawable.flag_india
            "IR" -> R.drawable.flag_iran
            "MX" -> R.drawable.flag_mexico
            "NL" -> R.drawable.flag_netherlands
            "NO" -> R.drawable.flag_norway
            "RS" -> R.drawable.flag_serbia
            "TR" -> R.drawable.flag_turkey
            "US" -> R.drawable.flag_usa
            else -> 0
        }
    }

}