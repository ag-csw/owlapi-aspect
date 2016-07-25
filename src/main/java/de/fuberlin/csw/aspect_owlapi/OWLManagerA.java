package de.fuberlin.csw.aspect_owlapi;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.semanticweb.owlapi.OWLAPIParsersModule;
import org.semanticweb.owlapi.OWLAPIServiceLoaderModule;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.util.mansyntax.ManchesterOWLSyntaxParser;
import uk.ac.manchester.cs.owl.owlapi.concurrent.Concurrency;

import javax.annotation.Nonnull;

import static org.semanticweb.owlapi.util.OWLAPIPreconditions.verifyNotNull;

/**
 * Created by lars on 09.05.16.
 */
public class OWLManagerA extends OWLManager {

    private static final long serialVersionUID = 40000L;


    @Override
    public OWLOntologyManagerA get() {
        return createOWLOntologyManager();
    }

    /**
     * Creates an OWL ontology manager that is configured with standard parsers,
     * storeres etc.
     *
     * @return The new manager.
     */
    @Nonnull
    public static OWLOntologyManagerA createOWLOntologyManager() {
        return instatiateOWLOntologyManager(Concurrency.NON_CONCURRENT);
    }

    /**
     * Creates an OWL ontology manager that is configured with the standard parsers and storers and provides
     * locking for concurrent access.
     * @return The new manager.
     */
    @Nonnull
    public static OWLOntologyManagerA createConcurrentOWLOntologyManager() {
        return instatiateOWLOntologyManager(Concurrency.CONCURRENT);
    }


    /**
     * Gets a global data factory that can be used to create OWL API objects.
     *
     * @return An OWLDataFactory that can be used for creating OWL API objects.
     */
    @Nonnull
    public static OWLDataFactoryA getOWLDataFactoryAspect() {
        return verifyNotNull(createInjector(Concurrency.NON_CONCURRENT).getInstance(OWLDataFactoryA.class));
    }

    /**
     * @return an initialized manchester syntax parser for parsing strings
     */
    public static ManchesterOWLSyntaxParser createManchesterParser() {
        return createInjector(Concurrency.NON_CONCURRENT).getInstance(ManchesterOWLSyntaxParser.class);
    }

    private static Injector createInjector(Concurrency concurrency) {
        return Guice.createInjector(
                new OWLAPIImplModuleA(concurrency),
                new OWLAPIParsersModule(),
                new OWLAPIServiceLoaderModule());
    }


    private static OWLOntologyManagerA instatiateOWLOntologyManager(Concurrency concurrency) {
        Injector injector = createInjector(concurrency);
        OWLOntologyManagerA instance = injector.getInstance(OWLOntologyManagerA.class);
        injector.injectMembers(instance);
        return verifyNotNull(instance);
    }

}
