package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.model.parameters.ChangeApplied;
import uk.ac.manchester.cs.owl.owlapi.OWLOntologyManagerImpl;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.List;


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





    /**
     * A convenience method that adds a single axiom to an ontology. The
     * appropriate AddAxiom change object is automatically generated.
     *
     * @param ont
     *        The ontology to add the axiom to.
     * @param axiom
     *        The axiom to be added
     * @return ChangeApplied.SUCCESSFULLY if the axiom is added,
     *         ChangeApplied.UNSUCCESSFULLY otherwise.
     * @throws OWLOntologyChangeException
     *         if there was a problem adding the axiom
     */
    @Nonnull
    public ChangeApplied addAxiom(@Nonnull OWLOntology ont, @Nonnull OWLAxiom axiom){

        // Automatically add Class Declaration if IRI in advice not part of the ontology
        if (axiom instanceof OWLAspectAssertionAxiom){

            OWLDataFactory dataFactory = ont.getOWLOntologyManager().getOWLDataFactory();

            IRI classIRI = ((OWLAspectAssertionAxiom) axiom).getAdvice().get().getIRI();

            OWLEntity entity = dataFactory.getOWLEntity(EntityType.CLASS, classIRI);

            OWLAxiom declare = dataFactory.getOWLDeclarationAxiom(entity);

            // return if class decleration already part of ontology
            if (ont.containsAxiom(declare)){
                return super.addAxiom(ont, axiom);
            }

            Set<OWLAxiom> axiomList = new HashSet<>();
            axiomList.add(axiom);
            axiomList.add(declare);

            return addAxioms(ont, axiomList);
        }

        return super.addAxiom(ont, axiom);

    }



    /**
     * A convenience method that adds a set of axioms to an ontology. The
     * appropriate AddAxiom change objects are automatically generated.
     *
     * @param ont
     *        The ontology to which the axioms should be added. Not {@code null}
     *        .
     * @param axioms
     *        The axioms to be added. Not {@code null}.
     * @return ChangeApplied.SUCCESSFULLY if the axiom is added,
     *         ChangeApplied.UNSUCCESSFULLY otherwise.
     */
    @Nonnull
    public ChangeApplied addAxioms(@Nonnull OWLOntology ont,
                            @Nonnull Set<? extends OWLAxiom> axioms){


        Set<OWLAxiom> axiomSet = new HashSet<>();
        axiomSet.addAll(axioms);

        for (OWLAxiom axiom : axioms){
            if (axiom instanceof OWLAspectAssertionAxiom){

                OWLDataFactory dataFactory = ont.getOWLOntologyManager().getOWLDataFactory();

                IRI classIRI = ((OWLAspectAssertionAxiom) axiom).getAdvice().get().getIRI();

                OWLEntity entity = dataFactory.getOWLEntity(EntityType.CLASS, classIRI);

                OWLAxiom declare = dataFactory.getOWLDeclarationAxiom(entity);

                // return if class decleration already part of ontology
                if (ont.containsAxiom(declare)){
                    continue;
                }

                axiomSet.add(declare);

            }
        }

        return super.addAxioms(ont, axiomSet);

    }


    /**
     * A convenience method that applies just one change to an ontology that is
     * managed by this manager.
     *
     * @param change
     *        The change to be applied
     * @return ChangeApplied.SUCCESSFULLY if the change is applied with success,
     *         ChangeApplied.UNSUCCESSFULLY otherwise.
     * @throws OWLOntologyChangeException
     *         If the change could not be applied. See subclasses of ontology
     *         change exception for more specific details.
     * @throws OWLOntologyRenameException
     *         If one or more of the changes is an instance of
     *         {@link org.semanticweb.owlapi.model.SetOntologyID} where the new
     *         {@link org.semanticweb.owlapi.model.OWLOntologyID} already
     *         belongs to an ontology managed by this manager.
     */
    @Nonnull
    public ChangeApplied applyChange(@Nonnull OWLOntologyChange change){

        if (change.isAddAxiom()){
            OWLAxiom axiom = change.getAxiom();

            if (axiom instanceof OWLAspectAssertionAxiom){
                addAxiom(change.getOntology(), axiom);
            }

            return super.applyChange(change);

        }

        return super.applyChange(change);

    }


}
