package services

import java.util
import models.Reservation

class ReservationService {
  protected var db = List(new Reservation(0, 0, ""))
  def update(id: Int, obj: Reservation) = { if(db.size > id) {
    // Transaction begin
    db(id) = obj // Pessimistic locking with versioning
    // Update Event Stock

    //Transaction end
  } else null }
  def getAll() = { db }
  def get(id: Int): Event = { if (db.size > id) db(id) else null}
  def delete(id: Int) = { if (db.size > id) {
    // Transaction begin
    db.patch(id, Nil, 1)
    // Update the Event Stock

    //Transaction end
  } else null}
}