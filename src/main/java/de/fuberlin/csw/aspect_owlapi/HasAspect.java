package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.IRI;
import uk.ac.manchester.cs.owl.owlapi.OWLAnnotationPropertyImpl;

import javax.annotation.Nonnull;

/**
 * Created by lars on 02.05.16.
 */
public class HasAspect extends OWLAnnotationPropertyImpl {
    private static HasAspect ourInstance = new HasAspect();

    public static HasAspect getInstance() {
        return ourInstance;
    }

    private HasAspect() {
        super(IRI.create("http://www.corporate-semantic-web.de/ontologies/aspect_owl#hasAspect"));
    }
}
