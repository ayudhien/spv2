name := "DataPrep"

organization := "org.allenai.scienceparse2"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.bintrayRepo("allenai", "maven")

libraryDependencies ++= Seq(
  "org.apache.pdfbox" % "pdfbox" % "2.0.5" exclude ("commons-logging", "commons-logging"),
  "org.apache.pdfbox" % "fontbox" % "2.0.5" exclude ("commons-logging", "commons-logging"),
  "org.apache.pdfbox" % "pdfbox-tools" % "2.0.5" exclude ("commons-logging", "commons-logging"),
  "com.github.scopt" %% "scopt" % "3.3.0",
  "org.slf4j" % "jcl-over-slf4j" % "1.7.25",
  "com.amazonaws" % "aws-java-sdk" % "1.7.4" exclude ("commons-logging", "commons-logging"),
  "org.allenai.common" %% "common-core" % "1.4.10",
  "org.bouncycastle" % "bcprov-jdk16" % "1.46",
  "org.bouncycastle" % "bcmail-jdk16" % "1.46",
  "com.github.jai-imageio" % "jai-imageio-jpeg2000" % "1.3.0", // For handling jpeg2000 images
  "com.levigo.jbig2" % "levigo-jbig2-imageio" % "1.6.5", // For handling jbig2 images
  "com.trueaccord.scalapb" %% "scalapb-json4s" % "0.2.0"
)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

mainClass in assembly := Some("org.allenai.scienceparse2.PDFRenderer")