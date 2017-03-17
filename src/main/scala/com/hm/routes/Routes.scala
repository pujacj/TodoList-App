package com.hm.routes

import spray.http.MediaTypes.`text/html`
import spray.routing.HttpService

/**
  * Created by pooja on 17/2/17.
  */
trait Routes extends HttpService
  with TodoHandler
  with UserHandler
  with AuthenticationHandler {



  val route =

    path("addTodo")
    {
      addToDo
    }~ path("editTodo")
    {
      updateTodo
    }~ path("deleteTodo")
  {
    deleteToDo
  }~path("login")
  {
    login
  }~path("logout")
  {
   logout
  }~path("signup")
  {
      signup
    }~path("") {

      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>welcome to Todo :)</h1>
              </body>
            </html>
          }
        }
      }
    }
}
