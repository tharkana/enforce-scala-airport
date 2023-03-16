package services

import play.Environment
import scala.io.Source
import javax.inject._
import java.util.ArrayList
import java.io.InputStream
import models.Airport
import models.AirportDetails
import scala.collection.immutable.HashMap
import models.Review
import scala.collection.mutable.ListBuffer
import com.opencsv.CSVReaderBuilder
import org.joda.time.DateTime
import models.ReviewDetails

object AirPortRepositary {
  private var fileData: java.util.List[Array[String]] = new ArrayList();
  private var airports: HashMap[String, Airport] = new HashMap()
  private var fileInString: String = "";
  def readFile(fileStream: InputStream): Unit = {

    var csvReader = new CSVReaderBuilder(
      Source.fromInputStream(fileStream).bufferedReader()
    )
      .withSkipLines(1)
      .build()

    csvReader.readAll.forEach { line =>
      val rating = if (line(10).isEmpty()) 0 else line(10).toDouble
      val date = new DateTime(line(5))
      val review =
        new Review(line(3), line(4), line(6), date, rating, line(19).toInt)
      if (airports.contains(line(0))) {
        airports(line(0)).review += review

      } else {
        val airport = new Airport(line(0), ListBuffer(review))
        airports = airports + (line(0) -> airport)
      }
      fileInString += line.mkString(",");
    }

  }

  def getFileData() = fileData;

  def getAsString() = fileInString

  def getAirports() = airports

  def getAirport(id: String) = {

    var airport: Airport =
      airports.getOrElse(id, sys.error(s"unexpected key: $id"))

    var rating: Double = 0;
    var recommendations: Int = 0;

    airport.review.foreach { review: Review =>
      recommendations = recommendations + review.recommended
      rating = rating + review.overallRating
    }

    AirportDetails(
      airport.name,
      airport.review.knownSize,
      rating,
      recommendations
    )

  }

  def getReviewsPerAirport(id: String) = {
    var airport: Airport =
      airports.getOrElse(id, sys.error(s"unexpected key: $id"))

    airport.review
      .sortBy(review => review.date)
      .map(review => {
        new ReviewDetails(
          review.authorCountry,
          review.content,
          review.overallRating,
          review.date.toString("yyyy-MM-dd")
        )
      })
  }
}
