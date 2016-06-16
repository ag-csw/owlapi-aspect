package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.OWLAnnotationSubject;

/**
 * Created by lars on 02.05.16.
 */
public class JoinPoint {

    OWLAnnotationSubject subject;

    public JoinPoint(OWLAnnotationSubject subject){
        this.subject = subject;
    }

    public OWLAnnotationSubject get(){
        return this.subject;
    }





}
