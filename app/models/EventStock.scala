package models

class EventStock(eventId: Integer, capacity: Integer, numBooked: Integer) {
  def status(): String = { "" /* Returns FULL, AVAILABLE */ }
}