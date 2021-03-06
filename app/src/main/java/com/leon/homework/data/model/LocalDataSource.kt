package com.leon.homework.data.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource {
    companion object {
        const val APPLICATION_ID = "vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD"
        val IANATimeZoneIDs = listOf(
            "Pacific/Midway",
            "Pacific/Honolulu",
            "America/Anchorage",
            "America/Los_Angeles",
            "America/Tijuana",
            "America/Phoenix",
            "America/Chihuahua",
            "America/Denver",
            "America/Costa_Rica",
            "America/Chicago",
            "America/Mexico_City",
            "America/Regina",
            "America/Bogota",
            "America/New_York",
            "America/Caracas",
            "America/Barbados",
            "America/Halifax",
            "America/Manaus",
            "America/Santiago",
            "America/St_Johns",
            "America/Recife",
            "America/Sao_Paulo",
            "America/Argentina/Buenos_Aires",
            "America/Godthab",
            "America/Montevideo",
            "Atlantic/South_Georgia",
            "Atlantic/Azores",
            "Atlantic/Cape_Verde",
            "Etc/UTC",
            "Africa/Casablanca",
            "Europe/London",
            "Europe/Amsterdam",
            "Europe/Belgrade",
            "Europe/Brussels",
            "Europe/Madrid",
            "Europe/Sarajevo",
            "Africa/Windhoek",
            "Africa/Brazzaville",
            "Asia/Amman",
            "Europe/Athens",
            "Europe/Istanbul",
            "Asia/Beirut",
            "Africa/Cairo",
            "Europe/Helsinki",
            "Asia/Jerusalem",
            "Europe/Minsk",
            "Africa/Harare",
            "Asia/Baghdad",
            "Europe/Moscow",
            "Asia/Kuwait",
            "Africa/Nairobi",
            "Asia/Tehran",
            "Asia/Baku",
            "Asia/Tbilisi",
            "Asia/Yerevan",
            "Asia/Dubai",
            "Asia/Kabul",
            "Asia/Karachi",
            "Asia/Oral",
            "Asia/Yekaterinburg",
            "Asia/Kolkata",
            "Asia/Colombo",
            "Asia/Kathmandu",
            "Asia/Almaty",
            "Asia/Yangon",
            "Asia/Krasnoyarsk",
            "Asia/Bangkok",
            "Asia/Jakarta",
            "Asia/Shanghai",
            "Asia/Hong_Kong",
            "Asia/Irkutsk",
            "Asia/Kuala_Lumpur",
            "Australia/Perth",
            "Asia/Taipei",
            "Asia/Seoul",
            "Asia/Tokyo",
            "Asia/Yakutsk",
            "Australia/Adelaide",
            "Australia/Darwin",
            "Australia/Brisbane",
            "Australia/Hobart",
            "Australia/Sydney",
            "Asia/Vladivostok",
            "Pacific/Guam",
            "Asia/Magadan",
            "Pacific/Noumea",
            "Pacific/Majuro",
            "Pacific/Auckland",
            "Pacific/Fiji",
            "Pacific/Tongatapu"
        )

        val TimeZonesOffset = listOf(
            "GMT+12",
            "GMT+11",
            "GMT+10",
            "GMT+9",
            "GMT+8",
            "GMT+7",
            "GMT+6",
            "GMT+5",
            "GMT+4",
            "GMT+3",
            "GMT+2",
            "GMT+1",
            "GMT+0",
            "GMT-1",
            "GMT-2",
            "GMT-3",
            "GMT-4",
            "GMT-5",
            "GMT-6",
            "GMT-7",
            "GMT-8",
            "GMT-9",
            "GMT-10",
            "GMT-11",
            "GMT-12"
        )
    }

    suspend fun getApplicationID(): String {
        return withContext(Dispatchers.IO) {
            APPLICATION_ID
        }
    }

    suspend fun getTimeZoneIDs(): List<String> {
        return withContext(Dispatchers.IO) {
            IANATimeZoneIDs
        }
    }
}