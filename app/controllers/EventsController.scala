package controllers
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import services.EventService;
import models.Event;
/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class EventsController @Inject() (es: EventService) extends Controller {

  def index = deadbolt.SubjectPresent()() { implicit request =>

    println(Json.toJson(es.get(0)));
    Ok(Json.toJson(es.getAll()))
  }

  def create =  Action { implicit request =>
    val reservation = es.update(Integer.parseInt(id))
    if(null != reservation) Ok(Json.toJson(reservation)) else  NotFound
  }

  def read(id: String) = deadbolt.Restrict(List(Array("event-creator")))() { implicit request =>
    var reservation = es.get(Integer.parseInt(id))
    if(null != reservation) Ok(Json.toJson(reservation)) else  NotFound
  }


  def update(id: String) = deadbolt.Restrict(List(Array("event-creator")))() { implicit request =>
    var reservation = es.update(Integer.parseInt(id))
    if(null != reservation) Ok(Json.toJson(reservation)) else  NotFound
  }

  def delete(id: String) = deadbolt.Restrict(List(Array("event-creator")))() { implicit request =>
    var reservation = es.delete(Integer.parseInt(id))
    if(null != reservation) Ok(Json.toJson(reservation)) else  NotFound
  }
}
