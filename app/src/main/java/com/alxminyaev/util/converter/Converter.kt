package com.alxminyaev.util.converter

interface Converter<Current, ToDown> {
    fun convertToDown(current: Current): ToDown

    fun convertFromDown(toDown: ToDown): Current
}