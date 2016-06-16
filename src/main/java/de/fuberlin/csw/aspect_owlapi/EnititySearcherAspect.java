package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.search.EntitySearcher;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by lars on 02.05.16.
 */
public class EnititySearcherAspect extends EntitySearcher {



    // ToDo   Join Point als Interface
    public static Collection<OWLAspectAssertionAxiom> getAspectAssertionAxioms(JoinPoint e, OWLOntology ontology){

        Collection<OWLAnnotationAssertionAxiom> AnnotationSet = getAnnotationAssertionAxioms(e.get(), ontology);
        Collection<OWLAspectAssertionAxiom> resultSet = new HashSet<OWLAspectAssertionAxiom>();


        for (OWLAnnotationAssertionAxiom axiom : AnnotationSet){
            if (axiom.getProperty().equals(HasAspect.getInstance())){
                resultSet.add(new OWLAspectAssertionAxiom(axiom));        // ToDo: Data Factory Zugriff
            }
        }

        return resultSet;

    }


    public static Collection<OWLAspectAssertionAxiom> 	getAspectAssertionAxioms(OWLEntity e, OWLOntology ontology){
        Collection<OWLAnnotationAssertionAxiom> AnnotationSet = getAnnotationAssertionAxioms(e, ontology);
        Collection<OWLAspectAssertionAxiom> resultSet = new HashSet<OWLAspectAssertionAxiom>();


        for (OWLAnnotationAssertionAxiom axiom : AnnotationSet){
            if (axiom.getProperty().equals(HasAspect.getInstance())){
                resultSet.add(new OWLAspectAssertionAxiom(axiom));        // ToDo: Data Factory Zugriff
            }
        }

        return resultSet;
    }




    public static Collection<Aspect> getAspectObjects(JoinPoint e, Iterable<OWLOntology> ontologies){
        Collection<Aspect> resultSet = new HashSet<Aspect>();

        for (OWLAnnotation result : getAnnotationObjects(e.get(), ontologies, HasAspect.getInstance())){
            resultSet.add(new Aspect(result));
        }

        return resultSet;
    }

    public static Collection<Aspect> getAspectObjects(JoinPoint e, OWLOntology ontology){
        Collection<Aspect> resultSet = new HashSet<Aspect>();

        for (OWLAnnotation result : getAnnotationObjects(e.get(), ontology, HasAspect.getInstance())){
            resultSet.add(new Aspect(result));
        }

        return resultSet;
    }


    public static Collection<Aspect> 	getAspectObjects(OWLEntity e, Iterable<OWLOntology> ontologies){
        Collection<Aspect> resultSet = new HashSet<Aspect>();

        for (OWLAnnotation result : getAnnotationObjects(e, ontologies, HasAspect.getInstance())){
            resultSet.add(new Aspect(result));
        }

        return resultSet;
    }

    public static Collection<Aspect> 	getAspectObjects(OWLEntity e, OWLOntology ontology){
        Collection<Aspect> resultSet = new HashSet<Aspect>();

        for (OWLAnnotation result : getAnnotationObjects(e, ontology, HasAspect.getInstance())){
            resultSet.add(new Aspect(result));
        }

        return resultSet;
    }




    public static Collection<Aspect> 	getAspects(JoinPoint e, OWLOntology ontology){
        Collection<Aspect> resultSet = new HashSet<Aspect>();

        for (OWLAnnotation result : getAnnotations(e.get(), ontology, HasAspect.getInstance())){
            resultSet.add(new Aspect(result));
        }

        return resultSet;
    }



    public static Collection<Aspect> 	getAspects(JoinPoint e, Iterable<OWLOntology> ontologies){
        Collection<Aspect> resultSet = new HashSet<Aspect>();

        for (OWLAnnotation result : getAnnotations(e.get(), ontologies, HasAspect.getInstance())){
            resultSet.add(new Aspect(result));
        }

        return resultSet;
    }


    public static Collection<Aspect> 	getAspects(OWLEntity e, OWLOntology ontology){
        Collection<Aspect> resultSet = new HashSet<Aspect>();

        for (OWLAnnotation result : getAnnotations(e, ontology, HasAspect.getInstance())){
            resultSet.add(new Aspect(result));
        }

        return resultSet;
    }


    public static Collection<Aspect> 	getAspects(OWLEntity e, Iterable<OWLOntology> ontologies) {
        Collection<Aspect> resultSet = new HashSet<Aspect>();

        for (OWLAnnotation result : getAnnotations(e, ontologies, HasAspect.getInstance())){
            resultSet.add(new Aspect(result));
        }

        return resultSet;
    }
}
