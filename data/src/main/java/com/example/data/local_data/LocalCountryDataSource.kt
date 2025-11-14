package com.example.data.local_data

import com.example.domain.local_data.model.Country

class LocalCountryDataSource {
    fun getCountries() = listOf(
        Country(code = "AU", name = "Australia", thumbnail = "flag_austria"),
        Country(code = "BR", name = "Brazil", thumbnail = "flag_brazil"),
        Country(code = "CA", name = "Canada", thumbnail = "flag_canada"),
        Country(code = "CH", name = "Switzerland", thumbnail = "flag_switzerland"),
        Country(code = "DE", name = "Germany", thumbnail = "flag_germany"),
        Country(code = "DK", name = "Denmark", thumbnail = "flag_denmark"),
        Country(code = "ES", name = "Spain", thumbnail = "flag_spain"),
        Country(code = "FI", name = "Finland", thumbnail = "flag_finland"),
        Country(code = "FR", name = "France", thumbnail = "flag_france"),
        Country(code = "GB", name = "United Kingdom", thumbnail = "flag_united_kingdom"),
        Country(code = "IN", name = "India", thumbnail = "flag_india"),
        Country(code = "IR", name = "Iran", thumbnail = "flag_iran"),
        Country(code = "MX", name = "Mexico", thumbnail = "flag_mexico"),
        Country(code = "NL", name = "Netherlands", thumbnail = "flag_netherlands"),
        Country(code = "NO", name = "Norway", thumbnail = "flag_norway"),
        Country(code = "RS", name = "Serbia", thumbnail = "flag_serbia"),
        Country(code = "TR", name = "Turkey", thumbnail = "flag_turkey"),
        Country(code = "US", name = "United States", thumbnail = "flag_usa")
    )
}