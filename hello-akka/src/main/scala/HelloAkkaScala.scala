import akka.actor.{Actor, ActorSystem, Props}

/**
  * Example from http://alvinalexander.com/scala/simple-scala-akka-actor-examples-hello-world-actors
  */
class HelloActor(name: String) extends Actor {
  def receive = {
    case "hello" => println(s"${name}: hello back at you")
    case _ => println(s"${name}: huh?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")

  val ali = system.actorOf(Props(new HelloActor("Ali")), name = "AliActor")
  ali ! "hello"
  ali ! "salam"

  val sadegh = system.actorOf(Props(new HelloActor("sadegh")))
  sadegh ! "hi"
  sadegh ! "hello"

}