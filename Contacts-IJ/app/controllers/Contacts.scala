package controllers

//import play.api.mvc.Controller
//import play.api.mvc.Action
import play.api.mvc._
import models.Contact

object Contacts extends Controller {


  def index = Action {
    Ok(views.html.index(Contact.all, Contact.form))
  }


//  def index = Action {
////	  val names = List("James", "Emma", "John", "Kate")
//////	  val names = List()
////	  Ok(views.html.index("Hello again... <small>I am small...</small>", names))
//
//	  val contacts = Contact.all
////	  Ok(views.html.index(contacts, Contact.form))
//    Ok(views.html.index("some text"))
//  }
	
	def another = Action { implicit request =>
	  val initialValue = request2session.get("counter").map(_.toInt).getOrElse(0)
	  Ok(views.html.another()).withSession(
			  "counter" -> (initialValue + 1).toString
	  )
	}
	
	def create = Action { implicit request =>

    Contact.form.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Contact.all, errors)),
      contact => {
          Contact.create(contact)
          Redirect(routes.Contacts.index())
      }
    )

  }
	
	def edit(id: Long) = Action {
    Contact.get(id).map { contact =>
      Ok(views.html.edit(id, Contact.form.fill(contact)))
    } getOrElse {
      Redirect(routes.Contacts.index())
    }

  }

  def update(id: Long) = Action { implicit request =>
    Contact.form.bindFromRequest.fold(
      errors => BadRequest(views.html.edit(id, errors)),
      contact => {
          Contact.update(id, contact)
          Redirect(routes.Contacts.index())
      }
    )
  }
	
	def delete(id: Long) = Action {
    Contact.delete(id)
    Redirect(routes.Contacts.index())
  }
}