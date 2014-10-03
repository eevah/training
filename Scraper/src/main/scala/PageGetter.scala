/**
 * Created by Ivana on 10/2/2014.
 */

import scalaj.http.Http

import com.chatmeter.proxyselector.Proxy
import com.chatmeter.proxyselector.ConfigurationModule
import com.chatmeter.proxyselector.ProxyService
import com.google.inject.Guice
import com.google.inject.Injector


object PageGetter extends App{


    val page = Http("http://www.google.com").asString

//  val injector: Injector = Guice.createInjector(new ConfigurationModule());
//  val service: ProxyService = injector.getInstance(classOf[ProxyService])
//  val proxy: Proxy = service.getProxy("http://www.google.com")
//
//
//  println("IP Address: " + proxy.hostname)
//  println("Port number: " + proxy.port)
//  println("User name: " + proxy.username)
//  println("Password: " + proxy.password)

  println(page)
}
