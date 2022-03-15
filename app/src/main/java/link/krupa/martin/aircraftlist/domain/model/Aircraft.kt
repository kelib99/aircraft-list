package link.krupa.martin.aircraftlist.domain.model


data class Aircraft(
    val icao24: String,
    val callsign: String?,
    val originCountry: String,
    val longitude: Float?,
    val latitude: Float?,
    val baroAltitude: Float?,
    val onGround: Boolean,
    val velocity: Float?,
    val trueTrack: Float?,
)