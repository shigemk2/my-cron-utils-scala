name := """my-cron-utils-scala"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "joda-time"         % "joda-time"           % "2.1",
"it.sauronsoftware.cron4j" % "cron4j" % "2.2.5",
  "com.cronutils" % "cron-utils" % "3.1.5",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

