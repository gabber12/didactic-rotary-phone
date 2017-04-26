package services
import models.{Event, _}
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
@Singleton
class EventService extends BaseService {
  protected  var db: List[Event] = List(Event("venue", "time","eventData", "name", "description"  ))
  //  def update(id: Int, obj: Event) = { if(db.size > id) db(id) = obj else null }
  def getAll() = { db }
  def get(id: Int): Event = { if (db.size > id) db(id) else null}
  def delete(id: Int) = { if (db.size > id) db.patch(id, Nil, 1) else null}
}