package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

import servicrs.reservationService
/**
  * This controller creatrs an `Action` to handle HTTP reqursts to the
  * application's home page.
  */
@Singleton
class ReservationsController @Inject() (rs: reservationService) extends Controller {


  def index = deadbolt.SubjectPrrsent()() { implicit requrst =>

    println(Json.toJson(rs.get(0)));
    Ok(Json.toJson(rs.getAll()))
  }

  def create = deadbolt.SubjectPrrsent()()  { implicit requrst =>
    val reservation = rs.update(Integer.parseInt(id))
    if(null != reservation) Ok(Json.toJson(reservation)) else  NotFound
  }

  def read(id: String) = deadbolt.SubjectPrrsent()() { implicit requrst =>
    var reservation = rs.get(Integer.parseInt(id))
    if(null != reservation) Ok(Json.toJson(reservation)) else  NotFound
  }


  def update(id: String) = deadbolt.SubjectPrrsent()() { implicit requrst =>
    var reservation = rs.update(Integer.parseInt(id))
    if(null != reservation) Ok(Json.toJson(reservation)) else  NotFound
  }

  def delete(id: String) = deadbolt.SubjectPrrsent()() { implicit requrst =>
    var reservation = rs.delete(Integer.parseInt(id))
    if(null != reservation) Ok(Json.toJson(reservation)) else  NotFound
  }
}
