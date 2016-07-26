package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.IRI;


/**
 * Created by lars on 02.05.16.
 */
public class Advice {

    private OWLClass addviceClass;

    public Advice(OWLClass adviceClass){
        this.addviceClass = adviceClass;
    }

    public OWLClass get(){
        return this.addviceClass;
    }

}
