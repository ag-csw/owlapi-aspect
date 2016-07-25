package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.PriorityCollectionSorting;
import uk.ac.manchester.cs.owl.owlapi.OWLOntologyManagerImpl;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.concurrent.locks.ReadWriteLock;


/**
 * Created by lars on 09.05.16.
 */
public class OWLOntologyManagerAImpl extends OWLOntologyManagerImpl implements OWLOntologyManagerA {


    @Inject
    public OWLOntologyManagerAImpl(@Nonnull OWLDataFactoryA dataFactory, ReadWriteLock readWriteLock) {
        this(dataFactory, readWriteLock, PriorityCollectionSorting.ON_SET_INJECTION_ONLY);
    }

    public OWLOntologyManagerAImpl(@Nonnull OWLDataFactoryA dataFactory, ReadWriteLock readWriteLock,
                                   PriorityCollectionSorting sorting) {
        super(dataFactory, readWriteLock, sorting);
    }

    @Override
    public OWLDataFactoryA getOWLDataFactory(){
        if (super.getOWLDataFactory() instanceof OWLDataFactoryA){
            return (OWLDataFactoryA)super.getOWLDataFactory();
        }
        return null;
    }


}
