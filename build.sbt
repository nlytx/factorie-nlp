/* Main versions */

val scalaLangVersion = "2.12.3"
val organisationName = "io.nlytx"

val factorieName = "factorie-nlp"
val factorieVersion = "1.0.4"
val publish_factorie_to_BinTray = true

val modelsName = "factorie-nlp-models"
val modelsVersion = "1.0.3"
val publish_models_to_BinTray = false


/* Dependencies Versions */

val scalaLangV = "2.12.3"
val scalaParserV = "1.0.6"
val jblasV = "1.2.4"
val apacheComsCompressV = "1.15"
val apacheComsLangV = "3.6"
val akkaStreamV = "2.5.6"
val json4sV = "3.5.3"
val slf4jV = "1.7.25"
val logbackV = "1.2.3"
val scalatestV = "3.0.4"


/* Module settings */

lazy val commonSettings = Seq(
  scalaVersion := "2.12.3",
  organization := "io.nlytx"
)

lazy val factorie_nlp = (project in file(".")).
  settings(
    name := factorieName,
    version := factorieVersion,
    commonSettings,
    libraryDependencies ++= factorieDeps ++ loggingDeps ++ testDeps,
    resolvers += Resolver.bintrayRepo("nlytx","nlytx-nlp"),
    publishFactorie
  )

lazy val factorie_nlp_models = project.settings(
  name := modelsName,
  version := modelsVersion,
  commonSettings,
  publishModels
)

lazy val factorieDeps = Seq(
  "io.nlytx" %% "factorie-nlp-models" % "1.0.3",
  "org.scala-lang.modules" %% "scala-parser-combinators" % scalaParserV,
  "org.scala-lang" % "scala-compiler" % scalaLangV,
  "org.scala-lang" % "scala-reflect" % scalaLangV,
  "org.jblas" % "jblas" % jblasV,
  "org.apache.commons" % "commons-compress" % apacheComsCompressV,
  "org.apache.commons" % "commons-lang3" % apacheComsLangV,
  "org.json4s" %% "json4s-jackson" % json4sV,
)

lazy val loggingDeps = Seq(
  "org.slf4j" % "slf4j-api" % slf4jV,
  "ch.qos.logback" % "logback-classic" % logbackV
)

lazy val testDeps = Seq(
  "org.scalactic" %% "scalactic" % scalatestV,
  "org.scalatest" %% "scalatest" % scalatestV % Test
)


/* Publishing  */

lazy val binTrayRealm = "Bintray API Realm"
lazy val binTrayUrl = s"https://api.bintray.com/content/nlytx/nlytx-nlp/"
lazy val binTrayCred = Credentials(Path.userHome / ".bintray" / ".credentials")
lazy val pubLicence = ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))
lazy val factorieBinTray = Some(binTrayRealm at binTrayUrl + s"$factorieName/$factorieVersion/")
lazy val modelsBinTray = Some("Bintray API Realm" at binTrayUrl + s"$modelsName/$modelsVersion/")

lazy val publishFactorie = {
  if (publish_factorie_to_BinTray) Seq(
    publishMavenStyle := true,
    licenses += pubLicence,
    publishTo := factorieBinTray,
    credentials += binTrayCred
  )
  else Seq(
    publishArtifact := false
  )
}

lazy val publishModels = {
  if (publish_models_to_BinTray) Seq(
    publishMavenStyle := true,
    licenses += pubLicence,
    publishTo := modelsBinTray,
    credentials += binTrayCred
  )
  else Seq(
    publishArtifact := false
  )
}

