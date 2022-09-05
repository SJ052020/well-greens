package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps
import scala.util.Random

class SearchSimulation extends Simulation{

  def traceId() = Random.nextInt()

  //http config
  val httpConfig = http.baseUrl(url="http://localhost:8080/search")
    .header("traceId",s"${traceId()}" )

  //scenario
  val getCategories = scenario(scenarioName = "Search Query")
    .exec(session => {
      session
        .set("traceId",s"${traceId()}")
    })
    .exec(http(requestName = "Search Query")
      .post(url = "/graphql")
      .body(ElFileBody(filePath = "./src/test/resources/bodies/searchQuery.json")).asJson
      .check(jsonPath(path = "$.data.getCategories").notNull)
      .check(jsonPath(path = "$.data.getCategories.categories").notNull)
      .check(status is 200))

  setUp(
    getCategories.inject(
      nothingFor(5),
      rampUsers(40).during(1.minutes),
    ).protocols(httpConfig)
  ).maxDuration(1.min())
}
