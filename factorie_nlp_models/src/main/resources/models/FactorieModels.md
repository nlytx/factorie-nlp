### factorie pre-build models

These models have been extracted from the ```cc.factorie all-models``` jar file. The following models are included:

- ```parse/OntonotesTransitionBasedParser.factorie```
- ```pos/OntonotesForwardPosTagger.factorie```
- ```ner/ConlChainNer.factorie```

Also included are lexicons for:

- ```iesl```
- ```uscensus```
- ```wikipedia```
- ```wordnet```

The models can be included in your project through a pre-built jar file. See the docs for further information.

To use these models directly, the compressed versions (as stored on GitHub) must be uncompressed into their corresponding directories:
- ```lexicon```
- ```ner```
- ```parse```
- ```pos```
- ```wordnet```

This structure is necessary for factorie-nlp to find the appropriate models.