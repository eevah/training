/**
 * Created by Ivana on 10/15/2014.
 */
import play.api.db.DB
import play.api.mvc.{Results, SimpleResult, RequestHeader}
import play.api.{Application, GlobalSettings}
import anorm._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object Global extends GlobalSettings {

  override def onStart(app: Application) {

    import play.api.Play.current

    DB.withConnection { implicit connection =>
      SQL("INSERT INTO contacts(name, emailAddress) VALUES('James Hughes', 'james@yobriefca.se')").execute()
      SQL("INSERT INTO contacts(name, emailAddress) VALUES('Emma Hughes', 'emma@yobriefca.se')").execute()
      SQL("INSERT INTO contacts(name, emailAddress) VALUES('Ollie Hughes', 'ollie@yobriefca.se')").execute()
      SQL("INSERT INTO contacts(name, emailAddress) VALUES('Nate Hughes', 'nate@yobriefca.se')").execute()
    }
  }

  override def onHandlerNotFound(request: RequestHeader) = {
    Future(Results.NotFound(views.html.notfound()))
  }
}
