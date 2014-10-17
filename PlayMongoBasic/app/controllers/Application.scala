package controllers

import play.api._
import play.api.mvc._
import models.User
import play.api.libs.json.Json
object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def addUser = Action { implicit request =>
    User.addUser

    val result = User.getUser()
//    val resultStr = result.asInstanceOf[String]

    Ok("User added")

  }

  def deleteUser = Action { implicit request =>
    User.deleteUser

    Ok("User deleted")
  }

}