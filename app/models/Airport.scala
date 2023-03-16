package models

import play.api.libs.json.Json
import scala.collection.mutable.ListBuffer

case class Airport(
    name: String,
    review: ListBuffer[Review]
)

object Airport {
  implicit def airportPlayJsonWrites = Json.writes[Airport]
}
