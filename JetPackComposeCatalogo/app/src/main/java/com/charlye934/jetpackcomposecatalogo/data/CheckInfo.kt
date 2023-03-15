package com.charlye934.jetpackcomposecatalogo.data

data class CheckInfo(
    val title: String,
    val selected: Boolean = false,
    var onCheckedChnage: (Boolean) -> Unit
)