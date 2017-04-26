#### Assumptions
* DB modeled as In memory lists
* Authorization with deadbolt(defacto now a days) hasnt been integrated just used
* Data types have been simpllified like DateTime -> String for easier part

#### Structure
* Controllers - Deal with auth and validation and pass request to corresponding service.
* Services - Have actual buisness logic and act as repositories too.
* Models - POJOs representing our application state/persistence
	* Event - Details about event
	* EventStock - Stock information about event
	* Reservation - Represents reservation done by user; Cancellation is modelled as soft deleting the Reservation and updating stock



