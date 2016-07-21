name := "Simple Jetty Server"

version := "1.0.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-server" % "9.3.9.v20160517"
)

resolvers += Resolver.mavenLocal
