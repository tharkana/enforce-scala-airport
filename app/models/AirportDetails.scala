package models

import play.api.libs.json.Json


case class AirportDetails(
    airportName: String,
    reviewCount: Int,
    rating: Double,
    recommendations: Int
)

object AirportDetails {
  implicit def airportDetailsPlayJsonWrites = Json.writes[AirportDetails]
}
