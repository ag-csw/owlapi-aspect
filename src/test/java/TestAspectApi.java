import de.fuberlin.csw.aspect_owlapi.*;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.SimpleIRIMapper;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Set;

/**
 * Created by lars on 12.05.16.
 */
public class TestAspectApi {

    static String testfolder = "src" + File.separator + "test" + File.separator;


    @Nonnull
    public static final IRI ASPECT_EXAMPLE_ONTO_IRI = IRI.create("http://csw.inf.fu-berlin.de/aood/aspect_example");

    @Nonnull
    public static final File ASPECT_EXAMPLE_ONTO_FILE = new File(testfolder + "aspect_example.owl");

    @Nonnull
    public static final IRI ADVISED_ASPECT_ONTO_IRI = IRI.create("http://www.corporate-semantic-web.de/ontologies/aspect_owl");

    @Nonnull
    public static final File ADVISED_ASPECT_ONTO_FILE = new File(testfolder + "aspectOWL.owl");

    @Nonnull
    public static final IRI CONTEXT_SLICES_IRI = IRI.create("http://testfolderexample.org/ContextSlices");

    @Nonnull
    public static final File CONTEXT_SLICES_FILE = new File(testfolder + "contextSlices.owl");

    @Nonnull
    public static final IRI ASPECT_EXAMPLE_ONTO_IRI_WOVEN = IRI.create("http://csw.inf.fu-berlin.de/aood/context_slices_example_woven");

    @Nonnull
    public static final File ASPECT_EXAMPLE_ONTO_FILE_WOVEN = new File(testfolder + "context_slices_example_woven.owl");


    @Test
    public void testWaeaving(){


        OWLOntologyManagerAspect ontologyManagerAspect = OWLManagerAspect.createOWLOntologyManager();


        OWLDataFactoryAspect dataFactoryAspect = ontologyManagerAspect.getOWLDataFactory();



        ontologyManagerAspect.getIRIMappers().add(new SimpleIRIMapper(ASPECT_EXAMPLE_ONTO_IRI, IRI.create(ASPECT_EXAMPLE_ONTO_FILE)));
        ontologyManagerAspect.getIRIMappers().add(new SimpleIRIMapper(ADVISED_ASPECT_ONTO_IRI, IRI.create(ADVISED_ASPECT_ONTO_FILE)));


        System.out.println(ontologyManagerAspect.getIRIMappers().size());



        try {
            System.out.println("TRY : ");

            //System.out.println(ontologyManager.loadOntology(ADVISED_ASPECT_ONTO_IRI));




            OWLOntology ontology = ontologyManagerAspect.loadOntology(ASPECT_EXAMPLE_ONTO_IRI);

            System.out.println("NUMBER ONTOLOGIES ::: " + ontologyManagerAspect.getOntologies().size());

            for (OWLAspectAssertionAxiom aspect : EnititySearcherAspect.getAspectAssertionAxioms
                                                    (new JoinPoint(IRI.create("http://csw.inf.fu-berlin.de/aood/example#Country")), ontology)){

                System.out.println("########################## :::  " +  aspect.getJoinPoint().get());

            };

        } catch (Exception e){   // TODO
            e.printStackTrace();
        }





    }



}

