package models
import play.api.libs.json._

// TODO: time -> DateTime, eventData -> JsonObject
case class Event(venue: String, time: String,eventData: String, name: String, description: String) {
  def setEventStock(eventStock: EventStock): Unit = {
    // Sets event Stock
  }
}

object Event {
  implicit object EventFormat extends Writes[Event] {
    def writes(user: Event) = JsObject(Seq(
      "venue" -> JsString(user.venue),
      "time" -> JsString(user.time),
      "eventData" -> JsString(user.eventData),
      "name" -> Json.toJson(user.name),
      "description" -> Json.toJson(user.description)

    ))
  }
}