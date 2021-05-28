package com.mousbai.cryptotracker.presentation.list

data class Crypto(
    val name: String,
    val id:String,
    val price:Double = 0.00,
    val image: String

)