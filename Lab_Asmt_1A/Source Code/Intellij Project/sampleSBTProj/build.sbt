name := "sampleSBTProj"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0" classifier "models"

)
    