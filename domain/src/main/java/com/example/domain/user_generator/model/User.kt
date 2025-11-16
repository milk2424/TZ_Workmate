package com.example.domain.user_generator.model

import java.io.Serializable

data class User(
    val gender: String,
    val firstName: String,
    val lastName: String,
    val streetNumber: Int,
    val streetName: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Int,
    val latitude: String,
    val longitude: String,
    val email: String,
    val username: String,
    val dateOfBirth: String,
    val age: Int,
    val phone: String,
    val cell: String,
    val img: String,
    val nat: String
) : Serializable


