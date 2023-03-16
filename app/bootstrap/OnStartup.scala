package bootstrap

import javax.inject.{Inject, Singleton}
import play.api.inject.ApplicationLifecycle
import scala.concurrent.Future
import play.Environment
import services.AirPortRepositary

@Singleton
class OnStartup @Inject() (val env: Environment) {

  val filename =  "airports-reviews.csv" // "test.csv"  // "airports-reviews.csv"
  val csvFileReader = AirPortRepositary
  def init(): Unit = {

    val stream = env.resourceAsStream(filename);

    csvFileReader.readFile(stream);
  }
  init()
}
