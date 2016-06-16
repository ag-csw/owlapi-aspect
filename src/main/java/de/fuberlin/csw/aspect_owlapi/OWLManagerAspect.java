package de.fuberlin.csw.aspect_owlapi;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.semanticweb.owlapi.OWLAPIParsersModule;
import org.semanticweb.owlapi.OWLAPIServiceLoaderModule;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyManagerFactory;
import org.semanticweb.owlapi.util.mansyntax.ManchesterOWLSyntaxParser;
import uk.ac.manchester.cs.owl.owlapi.OWLAPIImplModule;
import uk.ac.manchester.cs.owl.owlapi.concurrent.Concurrency;

import javax.annotation.Nonnull;

import static org.semanticweb.owlapi.util.OWLAPIPreconditions.verifyNotNull;

/**
 * Created by lars on 09.05.16.
 */
public class OWLManagerAspect extends OWLManager {

    private static final long serialVersionUID = 40000L;


    @Override
    public OWLOntologyManagerAspect get() {
        return createOWLOntologyManager();
    }

    /**
     * Creates an OWL ontology manager that is configured with standard parsers,
     * storeres etc.
     *
     * @return The new manager.
     */
    @Nonnull
    public static OWLOntologyManagerAspect createOWLOntologyManager() {
        return instatiateOWLOntologyManager(Concurrency.NON_CONCURRENT);
    }

    /**
     * Creates an OWL ontology manager that is configured with the standard parsers and storers and provides
     * locking for concurrent access.
     * @return The new manager.
     */
    @Nonnull
    public static OWLOntologyManagerAspect createConcurrentOWLOntologyManager() {
        return instatiateOWLOntologyManager(Concurrency.CONCURRENT);
    }


    /**
     * Gets a global data factory that can be used to create OWL API objects.
     *
     * @return An OWLDataFactory that can be used for creating OWL API objects.
     */
    @Nonnull
    public static OWLDataFactoryAspect getOWLDataFactoryAspect() {
        return verifyNotNull(createInjector(Concurrency.NON_CONCURRENT).getInstance(OWLDataFactoryAspect.class));
    }

    /**
     * @return an initialized manchester syntax parser for parsing strings
     */
    public static ManchesterOWLSyntaxParser createManchesterParser() {
        return createInjector(Concurrency.NON_CONCURRENT).getInstance(ManchesterOWLSyntaxParser.class);
    }

    private static Injector createInjector(Concurrency concurrency) {
        return Guice.createInjector(
                new OWLAPIImplModuleAspect(concurrency),
                new OWLAPIParsersModule(),
                new OWLAPIServiceLoaderModule());
    }


    private static OWLOntologyManagerAspect instatiateOWLOntologyManager(Concurrency concurrency) {
        Injector injector = createInjector(concurrency);
        OWLOntologyManagerAspect instance = injector.getInstance(OWLOntologyManagerAspect.class);
        injector.injectMembers(instance);
        return verifyNotNull(instance);
    }

}
