package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.*;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryInternals;

import javax.inject.Inject;

import static org.semanticweb.owlapi.util.OWLAPIPreconditions.verifyNotNull;

/**
 * Created by lars on 02.05.16.
 */
public class OWLDataFactoryAspectImpl extends OWLDataFactoryImpl implements OWLDataFactoryAspect {

    OWLDataFactoryAspectImpl(){
        super();
    }

    @Inject
    public OWLDataFactoryAspectImpl(OWLDataFactoryInternals dataFactoryInternals) {
        super(dataFactoryInternals);
    }

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Advice advice){
        return new OWLAspectAssertionAxiom(getOWLAnnotationAssertionAxiom(HasAspect.getInstance(), joinPoint.get(), advice.get()))  ;
    }

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Advice advice, java.util.Set<? extends OWLAnnotation> annotations){
        return new OWLAspectAssertionAxiom(getOWLAnnotationAssertionAxiom(HasAspect.getInstance(), joinPoint.get(), advice.get(), annotations))  ;
    }

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Aspect aspect){
        return new OWLAspectAssertionAxiom(getOWLAnnotationAssertionAxiom(joinPoint.get(), aspect))  ;
    }

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Aspect aspect, java.util.Set<? extends OWLAnnotation> annotations){
        return new OWLAspectAssertionAxiom(getOWLAnnotationAssertionAxiom(joinPoint.get(), aspect, annotations))  ;
    }

    public Aspect getAspect(Advice advice){
        return new Aspect(advice, null);
    }

    public Aspect getAspect(Advice advice, java.util.Set<? extends OWLAnnotation> annotations){
        return new Aspect(advice, annotations);
    }

    public Advice getAdvice(OWLClass adviceClass){
        return new Advice(adviceClass.getIRI());
    }

    public JoinPoint getJoinPoint(OWLAnnotationSubject subject){
        return new JoinPoint(subject);
    }


}
