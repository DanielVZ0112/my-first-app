package com.example.helloandroidstudio.horoscopoapp.data.providers

import com.example.helloandroidstudio.horoscopoapp.domain.model.HoroscopeInfo
import com.example.helloandroidstudio.horoscopoapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscope(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}