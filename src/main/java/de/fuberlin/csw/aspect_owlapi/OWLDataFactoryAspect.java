package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.*;

/**
 * Created by lars on 12.05.16.
 */
public interface OWLDataFactoryAspect extends OWLDataFactory, SWRLDataFactory, OWLEntityProvider,
        OWLEntityByTypeProvider, OWLAnonymousIndividualProvider,
        OWLAnonymousIndividualByIdProvider {

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Advice advice);

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Advice advice, java.util.Set<? extends OWLAnnotation> annotations);

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Aspect aspect);

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Aspect aspect, java.util.Set<? extends OWLAnnotation> annotations);

    public Aspect getAspect(Advice advice);

    public Aspect getAspect(Advice advice, java.util.Set<? extends OWLAnnotation> annotations);


}
