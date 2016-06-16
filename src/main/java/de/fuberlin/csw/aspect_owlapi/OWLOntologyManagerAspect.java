package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * Created by lars on 12.05.16.
 */
public interface OWLOntologyManagerAspect extends OWLOntologyManager {

    public OWLDataFactoryAspect getOWLDataFactory();

}
