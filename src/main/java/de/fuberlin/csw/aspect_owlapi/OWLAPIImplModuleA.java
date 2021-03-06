package de.fuberlin.csw.aspect_owlapi;

/**
 * Created by lars on 12.05.16.
 */
import javax.annotation.Nonnull;

import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.Singleton;

import org.semanticweb.owlapi.annotations.OwlapiModule;
import org.semanticweb.owlapi.model.*;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import uk.ac.manchester.cs.owl.owlapi.*;
import uk.ac.manchester.cs.owl.owlapi.concurrent.*;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@OwlapiModule
public class OWLAPIImplModuleA extends AbstractModule {

    private final Concurrency concurrency;

    public OWLAPIImplModuleA(Concurrency concurrency) {
        this.concurrency = concurrency;
    }

    @Override
    protected void configure() {

        if (concurrency == Concurrency.CONCURRENT) {
            bind(ReadWriteLock.class)
                    .to(ReentrantReadWriteLock.class)
                    .asEagerSingleton();
        }
        else {
            bind(ReadWriteLock.class)
                    .to(NoOpReadWriteLock.class)
                    .asEagerSingleton();
        }


        bind(OWLOntologyManagerAImpl.class).in(Singleton.class);

        bind(OWLDataFactoryAImpl.class).in(Singleton.class);


        bind(boolean.class)
                .annotatedWith(CompressionEnabled.class)
                .toInstance(false);

        bind(OWLDataFactoryA.class)
                .to(OWLDataFactoryAImpl.class)
                .asEagerSingleton();

        bind(OWLDataFactory.class)
                .to(OWLDataFactoryAImpl.class)
                .asEagerSingleton();

        bind(OWLDataFactoryInternals.class)
                .to(OWLDataFactoryInternalsImpl.class);

        bind(OWLOntologyManager.class)
                .to(OWLOntologyManagerAImpl.class)
                .asEagerSingleton();

        bind(OWLOntologyManager.class)
                .annotatedWith(NonConcurrentDelegate.class)
                .to(OWLOntologyManagerAImpl.class)
                .asEagerSingleton();

        bind(OWLOntologyManagerA.class)
                .to(OWLOntologyManagerAImpl.class)
                .asEagerSingleton();

        bind(OWLOntologyManagerA.class)
                .annotatedWith(NonConcurrentDelegate.class)
                .to(OWLOntologyManagerAImpl.class)
                .asEagerSingleton();

        bind(OWLOntologyBuilder.class)
                .to(ConcurrentOWLOntologyBuilder.class);

        bind(OWLOntologyBuilder.class)
                .annotatedWith(NonConcurrentDelegate.class)
                .to(NonConcurrentOWLOntologyBuilder.class);

        install(new FactoryModuleBuilder()
                .implement(OWLOntology.class, OWLOntologyImpl.class)
                .build(OWLOntologyImplementationFactory.class));

        multibind(OWLOntologyFactory.class, OWLOntologyFactoryImpl.class);





    }

    @SafeVarargs
    private final <T> Multibinder<T> multibind(Class<T> type,
                                               @Nonnull Class<? extends T>... implementations) {
        Multibinder<T> binder = Multibinder.newSetBinder(binder(), type);
        for (Class<? extends T> i : implementations) {
            binder.addBinding().to(i);
        }
        return binder;
    }
}