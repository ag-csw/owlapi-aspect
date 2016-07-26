# Aspect support for OWLAPI4

Java library for OWLAPI 4 providing an ontology manager, a data factory and an entity searcher to support aspect oriented ontology development

## Usage

### Get ontology manager

OWLOntologyManagerA ontologyManagerAspect = OWLManagerA.createOWLOntologyManager();

### Get data factory

OWLDataFactoryA dataFactoryA = ontologyManagerA.getOWLDataFactory();

### create a Join Point

JoinPoint someJoinPoint = new JoinPoint(someOWLEntity);

### create an Advice

Advice someAdvice = new Advice(someOWLClass);

### create an AspectAssertionAxiom

OWLAxiom axiom = dataFactoryA.getAspectAssertionAxiom(someJoinPoint, someAdvice);

### create an Aspect

Aspect someAspect = dataFactoryA.getAspect(someAdvice):

### create arbitrary axioms with aspects

OWLAxiom = dataFactoryA.get-some-Axiom(axiomParameters..., someAnnotations, someAspects);

### EntitySearcher

EntitySearcherA.getAspectAssertionAxioms(someJoinPoint, someOntology);

EntitySearcherA.getAspectAssertionAxiom(someOWLEntity, someOntology);

EntitySearcherA.getAspects(someJoinPoint, someOntology);

EntitySearcherA.getAspects(someOWLEntity, someOntology);
