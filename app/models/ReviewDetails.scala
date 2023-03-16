package models
import play.api.libs.json.Json

case class ReviewDetails(
  authorCountry: String,
  content: String,
  overallRating: Double,
  recommendationDate: String,
)

object ReviewDetails {
  implicit def reviewDetailsPlayJsonWrites = Json.writes[ReviewDetails]
}