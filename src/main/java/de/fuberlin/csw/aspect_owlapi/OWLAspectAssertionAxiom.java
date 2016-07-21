package de.fuberlin.csw.aspect_owlapi;

import de.fuberlin.csw.aspect_owlapi.util.NotAnAspectAnnotationError;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLDataFactory;
import uk.ac.manchester.cs.owl.owlapi.OWLAnnotationAssertionAxiomImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Created by lars on 02.05.16.
 */
public class OWLAspectAssertionAxiom extends OWLAnnotationAssertionAxiomImpl  {

    OWLAnnotationAssertionAxiom axiomRepresentation;


    OWLAspectAssertionAxiom(@Nonnull JoinPoint joinPoint, @Nonnull Advice advice,
                            @Nonnull Collection< ?extends OWLAnnotation> annotations){
        super(joinPoint.get(), HasAspect.getInstance(), advice.get(), annotations);
    }

    OWLAspectAssertionAxiom(OWLAnnotationAssertionAxiom axiomRepresentation){

        // TODO  ASSERT Annotation value
        super(axiomRepresentation.getSubject(), axiomRepresentation.getProperty(), axiomRepresentation.getValue(), axiomRepresentation.getAnnotations());

        if(!axiomRepresentation.getProperty().equals(HasAspect.getInstance())){
            throw new NotAnAspectAnnotationError();
        }
    }

    public JoinPoint getJoinPoint(){
        return new JoinPoint(this.getSubject());
    }


    public Advice getAdvice(){
        return new Advice(axiomRepresentation.getValue().asIRI().get());
    }



}
