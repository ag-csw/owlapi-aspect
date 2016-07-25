package de.fuberlin.csw.aspect_owlapi;

import de.fuberlin.csw.aspect_owlapi.util.NotAnAspectAnnotationError;
import org.semanticweb.owlapi.model.OWLAnnotation;
import uk.ac.manchester.cs.owl.owlapi.OWLAnnotationImpl;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * Created by lars on 02.05.16.
 */
public class Aspect extends OWLAnnotationImpl implements OWLAnnotation {



    public Aspect(@Nonnull Advice advice,
                  @Nonnull Set<? extends OWLAnnotation> annotations){
        super(HasAspect.getInstance(), advice.get(),  annotations);
    }

    public Aspect(@Nonnull OWLAnnotation annotation){
        super(annotation.getProperty(), annotation.getValue(), annotation.getAnnotations());
        if(!annotation.getProperty().equals(HasAspect.getInstance())){
            throw new NotAnAspectAnnotationError();
        }
    }

    public Advice getAdvice(){
        return new Advice(this.getValue().asIRI().get());       //   Advice created via constructor - stopgap
    }


}
