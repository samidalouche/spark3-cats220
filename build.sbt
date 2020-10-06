ThisBuild / scalaVersion := "2.12.12"

lazy val root = project
  .aggregate(cats211, cats220)

lazy val cats211 = project
  .settings(
    name := "catsspark211",
    libraryDependencies ++= Seq("org.typelevel" %% "cats-core" % "2.1.1")
  )
  .enablePlugins(AssemblyPlugin)

lazy val cats220 = project
  .settings(
    name := "catsspark220",
    libraryDependencies ++= Seq("org.typelevel" %% "cats-core" % "2.2.0")
  )
  .enablePlugins(AssemblyPlugin)
