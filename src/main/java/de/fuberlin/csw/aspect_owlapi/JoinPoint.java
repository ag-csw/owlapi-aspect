package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.IRI;



/**
 * Created by lars on 02.05.16.
 */
public class JoinPoint {

    OWLEntity joinPointRepresentation;

    public JoinPoint(OWLEntity subject){
        this.joinPointRepresentation = subject;
    }

    public OWLEntity get(){
        return this.joinPointRepresentation;
    }





}
