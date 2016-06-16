package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.OWLClass;

/**
 * Created by lars on 02.05.16.
 */
public class Advice {

    private OWLClass addviceClass;

    public Advice(OWLClass addviceClass){
        this.addviceClass = addviceClass;
    }

    public OWLClass get(){
        return this.addviceClass;
    }

}
