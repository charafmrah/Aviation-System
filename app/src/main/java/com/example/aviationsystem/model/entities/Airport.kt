package com.example.aviationsystem.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Airport (
    @PrimaryKey(autoGenerate = true)
    val airportId: Int,
    @ColumnInfo(name = "airport")
    val airport: String
        )