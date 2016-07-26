package de.fuberlin.csw.aspect_owlapi;

import de.fuberlin.csw.aspect_owlapi.util.NotAnAspectAnnotationError;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.IRI;
import uk.ac.manchester.cs.owl.owlapi.OWLAnnotationImpl;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * Created by lars on 02.05.16.
 */
public final class Aspect extends OWLAnnotationImpl implements OWLAnnotation {

    Advice advice;

    public Aspect(@Nonnull Advice advice,
                  @Nonnull Set<? extends OWLAnnotation> annotations){
        super(HasAspect.getInstance(), advice.get().getIRI(),  annotations);

        this.advice = advice;
    }

    public Aspect(@Nonnull OWLAnnotation annotation){
        super(annotation.getProperty(), annotation.getValue(), annotation.getAnnotations());
        if(!annotation.getProperty().equals(HasAspect.getInstance())){
            throw new NotAnAspectAnnotationError();
        }

        if (annotation.getValue() instanceof IRI){
            OWLOntologyManagerA ontologyManagerAspect = OWLManagerA.createOWLOntologyManager();
            OWLDataFactoryA dataFactoryAspect = ontologyManagerAspect.getOWLDataFactory();

            this.advice = new Advice(dataFactoryAspect.getOWLClass((IRI) annotation.getValue()));
        }


    }

    public Advice getAdvice(){

        return this.advice;       //   Advice created via constructor - stopgap
    }


}
