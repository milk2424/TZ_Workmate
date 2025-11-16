package com.example.data.network.dto

import com.example.domain.user_generator.model.User
import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("results")
    val results: List<UserResult>,
)

fun UserDTO.toDomain(): User {
    val user = this.results.first()
    return User(
        gender = user.gender,
        firstName = user.name.first,
        lastName = user.name.last,
        streetNumber = user.location.street.number,
        streetName = user.location.street.name,
        city = user.location.city,
        state = user.location.state,
        country = user.location.country,
        postcode = user.location.postcode,
        latitude = user.location.coordinates.latitude,
        longitude = user.location.coordinates.longitude,
        email = user.email,
        username = user.login.username,
        dateOfBirth = user.dob.date,
        age = user.dob.age,
        phone = user.phone,
        cell = user.cell,
        img = user.picture.large,
        nat = user.nat
    )
}

data class UserResult(
    @SerializedName("gender")
    val gender: String,

    @SerializedName("name")
    val name: Name,

    @SerializedName("location")
    val location: Location,

    @SerializedName("email")
    val email: String,

    @SerializedName("login")
    val login: Login,

    @SerializedName("dob")
    val dob: Dob,


    @SerializedName("phone")
    val phone: String,

    @SerializedName("cell")
    val cell: String,

    @SerializedName("picture")
    val picture: Picture,

    @SerializedName("nat")
    val nat: String
)

data class Name(

    @SerializedName("first")
    val first: String,

    @SerializedName("last")
    val last: String
)

data class Location(
    @SerializedName("street")
    val street: Street,

    @SerializedName("city")
    val city: String,

    @SerializedName("state")
    val state: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("postcode")
    val postcode: Int,

    @SerializedName("coordinates")
    val coordinates: Coordinates,
)

data class Street(
    @SerializedName("number")
    val number: Int,

    @SerializedName("name")
    val name: String
)

data class Coordinates(
    @SerializedName("latitude")
    val latitude: String,

    @SerializedName("longitude")
    val longitude: String
)

data class Login(
    @SerializedName("username")
    val username: String
)

data class Dob(
    @SerializedName("date")
    val date: String,

    @SerializedName("age")
    val age: Int
)

data class Picture(
    @SerializedName("large")
    val large: String
)
