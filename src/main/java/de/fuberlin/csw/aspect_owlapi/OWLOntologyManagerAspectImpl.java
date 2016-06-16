package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.PriorityCollectionSorting;
import uk.ac.manchester.cs.owl.owlapi.OWLOntologyManagerImpl;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.concurrent.locks.ReadWriteLock;

import static org.semanticweb.owlapi.util.OWLAPIPreconditions.checkNotNull;

/**
 * Created by lars on 09.05.16.
 */
public class OWLOntologyManagerAspectImpl extends OWLOntologyManagerImpl implements OWLOntologyManagerAspect {


    @Inject
    public OWLOntologyManagerAspectImpl(@Nonnull OWLDataFactoryAspect dataFactory, ReadWriteLock readWriteLock) {
        this(dataFactory, readWriteLock, PriorityCollectionSorting.ON_SET_INJECTION_ONLY);
    }

    public OWLOntologyManagerAspectImpl(@Nonnull OWLDataFactoryAspect dataFactory, ReadWriteLock readWriteLock,
                                        PriorityCollectionSorting sorting) {
        super(dataFactory, readWriteLock, sorting);
    }

    @Override
    public OWLDataFactoryAspect getOWLDataFactory(){
        if (super.getOWLDataFactory() instanceof OWLDataFactoryAspect){
            return (OWLDataFactoryAspect)super.getOWLDataFactory();
        }
        return null;
    }


}
