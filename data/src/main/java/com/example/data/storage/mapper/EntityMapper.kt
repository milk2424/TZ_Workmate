package com.example.data.storage.mapper

import com.example.data.storage.entity.UserEntity
import com.example.domain.user_generator.model.User

object EntityMapper {

    fun map(user: User) = UserEntity(
        id = user.id,
        gender = user.gender,
        firstName = user.firstName,
        lastName = user.lastName,
        streetNumber = user.streetNumber,
        streetName = user.streetName,
        city = user.city,
        state = user.state,
        country = user.country,
        postcode = user.postcode,
        latitude = user.latitude,
        longitude = user.longitude,
        email = user.email,
        username = user.username,
        dateOfBirth = user.dateOfBirth,
        age = user.age,
        phone = user.phone,
        cell = user.cell,
        img = user.img,
        nat = user.nat,
    )

    fun map(user: UserEntity) = User(
        id = user.id,
        gender = user.gender,
        firstName = user.firstName,
        lastName = user.lastName,
        streetNumber = user.streetNumber,
        streetName = user.streetName,
        city = user.city,
        state = user.state,
        country = user.country,
        postcode = user.postcode,
        latitude = user.latitude,
        longitude = user.longitude,
        email = user.email,
        username = user.username,
        dateOfBirth = user.dateOfBirth,
        age = user.age,
        phone = user.phone,
        cell = user.cell,
        img = user.img,
        nat = user.nat,
    )

}