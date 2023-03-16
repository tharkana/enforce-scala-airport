package models
import play.api.libs.json.Json
import org.joda.time.DateTime

import play.api.libs.json.JodaWrites
import play.api.libs.json.JodaReads
import play.api.libs.json.Writes

case class Review(
    author: String,
    authorCountry: String,
    content: String,
    date: DateTime,
    overallRating: Double,
    recommended: Int
)

object Review {
  implicit val dateTimeWriter: Writes[DateTime] =
    JodaWrites.jodaDateWrites("yyyy-MM-dd")

  implicit val dateTimeJsReader = JodaReads.jodaDateReads("yyyy-MM-dd")
  implicit def reviewPlayJsonWrites = Json.writes[Review]
}
