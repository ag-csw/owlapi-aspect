package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.IRI;


/**
 * Created by lars on 02.05.16.
 */
public class Advice {

    private IRI addviceClassIRI;

    protected Advice(IRI adviceClassIRI){
        this.addviceClassIRI = adviceClassIRI;
    }

    public IRI get(){
        return this.addviceClassIRI;
    }

}
