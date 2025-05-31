package com.example.worldhistorymap.data

data class Battle(
    val name: String,
    val location: Location,
    val era: String
)

data class Location(
    val lat: Double,
    val lng: Double
)
