package com.example.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String,

    @ColumnInfo(name = "street_number")
    val streetNumber: Int,

    @ColumnInfo(name = "street_name")
    val streetName: String,

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "state")
    val state: String,

    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "postcode")
    val postcode: String,

    @ColumnInfo(name = "latitude")
    val latitude: String,

    @ColumnInfo(name = "longitude")
    val longitude: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "date_of_birth")
    val dateOfBirth: String,

    @ColumnInfo(name = "age")
    val age: Long,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "cell")
    val cell: String,

    @ColumnInfo(name = "img")
    val img: String,

    @ColumnInfo(name = "nat")
    val nat: String
)
