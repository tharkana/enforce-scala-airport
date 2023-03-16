package controllers

import javax.inject.Inject
import java.util.UUID
import play.api.mvc.{BaseController, ControllerComponents}
import play.api.libs.json.Json
import com.opencsv.CSVReader
import scala.io.Source
import play.Environment
import java.io.BufferedReader
import java.io.InputStreamReader
import services.AirPortRepositary

class AirportReviewController @Inject() (
    val controllerComponents: ControllerComponents
) extends BaseController {

  val csvFileReader = AirPortRepositary

  def get = Action {

    var airports = csvFileReader.getAirports()

    // TODO: Format this map as an array
    val json = Json.toJson(airports.map(a => (a._1, a._2.review.knownSize)))

    Ok(json)
  }

  def getById(id: String) = Action {

    // TODO: Handle the error
    Ok(Json.toJson(csvFileReader.getAirport(id)))
  }

  def getReviews(id: String) = Action {

    // TODO: Handle the error
    Ok(Json.toJson(csvFileReader.getReviewsPerAirport(id)))
  }
}
