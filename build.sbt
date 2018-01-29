name := "todolist-a-la-freestyle"
version := "0.0.1-SNAPSHOT"
description := "A simple Todo List using freestyle concepts"
scalaVersion := "2.12.4"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",   // source files are in UTF-8
  "-deprecation",         // warn about use of deprecated APIs
  "-unchecked",           // warn about unchecked type parameters
  "-feature",             // warn about misused language features
  "-language:higherKinds",// allow higher kinded types without `import scala.language.higherKinds`
//  "-Xlint",               // enable handy linter warnings
  //  "-Xfatal-warnings",     // turn compiler warnings into errors
  "-Ypartial-unification" // allow the compiler to unify type constructors of different arities
)

libraryDependencies ++= Seq(
  "io.frees" %% "frees-core" % "0.6.3",
  "io.frees" %% "frees-effects" % "0.6.3",

//  "org.typelevel" %% "cats-core" % "1.0.1",
//  "org.typelevel" %% "cats-free" % "1.0.1",
//  "org.typelevel" %% "cats-laws" % "1.0.1",
//  "org.typelevel" %% "cats-effect" % "0.5",
//  "io.frees" %% "iota-core"  % "0.3.4",

//  "com.github.mpilquist" %% "simulacrum" % "0.11.0",


  "org.tpolecat" %% "doobie-core" % "0.4.4",
  "org.tpolecat" %% "doobie-h2" % "0.5.0-M14", // H2 driver 1.4.196 + type mappings.
  "org.tpolecat" %% "doobie-hikari" % "0.5.0-M14", // HikariCP transactor.
  "com.twitter" %% "twitter-server" % "18.1.0",
  "com.github.finagle" %% "finch-core" % "0.16.1",
  "com.github.finagle" %% "finch-circe" % "0.16.1",
  "io.circe" %% "circe-generic" % "0.9.0",
  "io.frees" %% "frees-effects"            % "0.6.3"  ,
  "io.frees" %% "frees-async"              % "0.6.3",
  "io.frees" %% "frees-async-cats-effect"  % "0.6.3"    ,
  "io.frees" %% "frees-async-guava"        % "0.6.3"    ,
  "io.frees" %% "frees-cache"              % "0.6.3"    ,
  "io.frees" %% "frees-config"             % "0.6.3"    ,
  "io.frees" %% "frees-logging"            % "0.6.3"    ,
  "io.frees" %% "frees-cache-redis"        % "0.6.3",
  "io.frees" %% "frees-doobie"             % "0.6.3",
  "io.frees" %% "frees-fetch"              % "0.6.3",
  "io.frees" %% "frees-akka"               % "0.6.3",
  "io.frees" %% "frees-finch"              % "0.6.3",
  "io.frees" %% "frees-http-client"        % "0.6.3",
  "io.frees" %% "frees-http4s"             % "0.6.3",
  "io.frees" %% "frees-monix"              % "0.6.3",
  "io.frees" %% "frees-play"               % "0.6.3",
  "io.frees" %% "frees-slick"              % "0.6.3",
  "io.frees" %% "frees-twitter-util"       % "0.6.3",
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.5")
addCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M10" cross CrossVersion.full)

addSbtPlugin("org.lyranthe.sbt" % "partial-unification" % "1.1.0")


