[![Build Status](https://travis-ci.org/nlytx/factorie-nlp.svg?branch=master)](https://travis-ci.org/nlytx/factorie-nlp) ![scalaVersion](https://img.shields.io/badge/scala-2.12.3-red.svg) ![Liencse](https://img.shields.io/badge/License-Apache%202.0-lightgrey.svg)

[ ![Download](https://api.bintray.com/packages/nlytx/nlytx-nlp/factorie-nlp-models/images/download.svg) ](https://bintray.com/nlytx/nlytx-nlp/factorie-nlp-models/_latestVersion) *factorie-nlp-models*

[ ![Download](https://api.bintray.com/packages/nlytx/nlytx-nlp/factorie-nlp/images/download.svg) ](https://bintray.com/nlytx/nlytx-nlp/factorie-nlp/_latestVersion) *factorie-nlp*


This is a significantly modified version of [Factorie](https://github.com/factorie/factorie) providing only NLP services. For more detail on the differences [see below](#diffs)

### Quick Start

Add the following to your build.sbt file:

```sbtshell
libraryDependencies ++= Seq(
        "io.nlytx" %% "factorie-nlp" % "1.0.4",
        "io.nlytx" %% "factorie-nlp-models" % "1.0.3")

resolvers += Resolver.bintrayRepo("nlytx", "nlytx-nlp")
```

Annotate a document:

```scala

```

### Documentation

Detailed docs pending

### Differences with Factorie<a name="diffs"></a>

It is opinionated and therefore does not include all of the NLP options contained in the original Factorie code base. In particular, the code for training new models and testing of models has been removed with the objective that this API be focused on delivering NLP services based on existing models. Therefore, it's anticipated that model training and testing might be provided via a separate API, or with the original Factorie code.

It is also not binary compatible with the original Factorie package as classes have been refactored to make it easier to distinguish the document model from the code that annotates text based on that model.

The package has also been stripped all of the command line code, code for accessing MongoDB, and the docs and examples associated with the general (non NLP) use of Factorie.

The original Factorie was a maven project with a custom sbt builder. This has been replaced it with a standard ```build.sbt```
and the libraries have been updated to allow it to run on Scala 2.12+.




