package de.fuberlin.csw.aspect_owlapi;

import de.fuberlin.csw.aspect_owlapi.util.NotAnAspectAnnotationError;
import org.semanticweb.owlapi.model.*;
import uk.ac.manchester.cs.owl.owlapi.OWLAnnotationAssertionAxiomImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Created by lars on 02.05.16.
 */
public final class OWLAspectAssertionAxiom extends OWLAnnotationAssertionAxiomImpl  {

    JoinPoint joinPoint;
    Advice advice;

    OWLAspectAssertionAxiom(@Nonnull JoinPoint joinPoint, @Nonnull Advice advice,
                            @Nonnull Collection< ?extends OWLAnnotation> annotations){
        super(joinPoint.get().getIRI(), HasAspect.getInstance(), advice.get().getIRI(), annotations);
        this.joinPoint = joinPoint;
        this.advice = advice;
    }

    OWLAspectAssertionAxiom(OWLAnnotationAssertionAxiom axiomRepresentation){

        // TODO  ASSERT Annotation value
        super(axiomRepresentation.getSubject(), axiomRepresentation.getProperty(), axiomRepresentation.getValue(), axiomRepresentation.getAnnotations());

        if(!axiomRepresentation.getProperty().equals(HasAspect.getInstance())){
            throw new NotAnAspectAnnotationError();
        }

        OWLOntologyManagerA ontologyManagerAspect = OWLManagerA.createOWLOntologyManager();
        OWLDataFactoryA dataFactoryAspect = ontologyManagerAspect.getOWLDataFactory();

        if (axiomRepresentation.getSubject() instanceof IRI  &&   axiomRepresentation.getValue() instanceof IRI){
            joinPoint = new JoinPoint(dataFactoryAspect.getOWLClass((IRI)axiomRepresentation.getSubject()));
            advice = new Advice(dataFactoryAspect.getOWLClass((IRI)axiomRepresentation.getValue()));
        }

    }

    public JoinPoint getJoinPoint(){
        return this.joinPoint;
    }


    public Advice getAdvice(){
        return this.advice;
    }



}
