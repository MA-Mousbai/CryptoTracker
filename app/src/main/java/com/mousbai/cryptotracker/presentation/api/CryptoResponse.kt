package com.mousbai.cryptotracker.presentation.api

import com.mousbai.cryptotracker.presentation.list.Crypto

data class CryptoResponse(
    val data: List<Crypto>
)