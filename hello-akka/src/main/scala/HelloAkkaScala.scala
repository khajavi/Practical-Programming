import akka.actor.{Actor, ActorSystem, Props}

/**
  * Example from http://alvinalexander.com/scala/simple-scala-akka-actor-examples-hello-world-actors
  */
class HelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _ => println("huh?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  helloActor ! "hello"
  helloActor ! "salam"
}