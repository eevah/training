package models

import com.sun.corba.se.spi.ior.ObjectId
import com.mongodb.casbah.Imports._
import org.bson.types.ObjectId
import models.MongoDBSetup

/**
 * Created by Ivana on 10/16/2014.
 */

case class User(name: String, emailAddress: String)

object User {

  var mongoClient = MongoClient("localhost", 27017)
  var db = mongoClient("playmongo")
  var coll = db("user")

  def addUser {

    val a = MongoDBObject("name" -> "Snow")
    coll.insert(a)
  }


  def deleteUser() {
    val query = MongoDBObject("name" -> "Snow")
    coll.remove( query )
  }


  def getUser() {
    val user = MongoDBObject("name" -> "Snow")
    val result = coll.findOne( user )


    for {
      r <- result
      (key,value) <- r
    }
//    yield println(key + " " + value.toString)
    return value.toString
//    return com.mongodb.util.JSON.serialize(result.get)
//    println(com.mongodb.util.JSON.serialize(result.get))
//    for {
//      r <- result
//      (key,value) <- r
//    }
//    yield println(key + " " + value.toString)

  }

}


