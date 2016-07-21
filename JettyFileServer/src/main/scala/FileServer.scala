import org.eclipse.jetty.server.handler.{DefaultHandler, HandlerList, ResourceHandler}
import org.eclipse.jetty.server.{Handler, Server, _}

object FileServer extends App {
  val server: Server = new Server(8080)
  // Create the ResourceHandler. It is the object that will actually handle the request for a given file. It is
  // a Jetty Handler object so it is suitable for chaining with other handlers as you will see in other examples.
  val resource_handler: ResourceHandler = new ResourceHandler
  // Configure the ResourceHandler. Setting the resource base indicates where the files should be served out of.
  // In this example it is the current directory but it can be configured to anything that the jvm has access to.
  resource_handler.setDirectoriesListed(true)
  resource_handler.setWelcomeFiles(Array[String]("index.html"))
  resource_handler.setResourceBase("src/main/resources/")
  // Add the ResourceHandler to the server.
  val handlers: HandlerList = new HandlerList
  handlers.setHandlers(Array[Handler](resource_handler, new DefaultHandler))
  server.setHandler(handlers)

  // Start things up! By using the server.join() the server thread will join with the current thread.
  // See "http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html#join()" for more details.
  server.start
  server.join
}
