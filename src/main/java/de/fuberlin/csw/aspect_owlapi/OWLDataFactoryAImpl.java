package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.*;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryInternals;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.semanticweb.owlapi.util.OWLAPIPreconditions.verifyNotNull;

/**
 * Created by lars on 02.05.16.
 */
public class OWLDataFactoryAImpl extends OWLDataFactoryImpl implements OWLDataFactoryA {

    OWLDataFactoryAImpl(){
        super();
    }

    @Inject
    public OWLDataFactoryAImpl(OWLDataFactoryInternals dataFactoryInternals) {
        super(dataFactoryInternals);
    }


    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Advice advice){
        return new OWLAspectAssertionAxiom(getOWLAnnotationAssertionAxiom(HasAspect.getInstance(), joinPoint.get(), advice.get()))  ;
    }


    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Advice advice, java.util.Set<? extends OWLAnnotation> annotations){
        return new OWLAspectAssertionAxiom(getOWLAnnotationAssertionAxiom(HasAspect.getInstance(), joinPoint.get(), advice.get(), annotations))  ;
    }

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(@Nonnull JoinPoint joinPoint, @Nonnull Advice advice, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);

        return getAspectAssertionAxiom(joinPoint, advice, annotationList);
    }


    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Aspect aspect){
        return new OWLAspectAssertionAxiom(getOWLAnnotationAssertionAxiom(joinPoint.get(), aspect))  ;
    }


    public OWLAspectAssertionAxiom getAspectAssertionAxiom(JoinPoint joinPoint, Aspect aspect, java.util.Set<? extends OWLAnnotation> annotations){
        return new OWLAspectAssertionAxiom(getOWLAnnotationAssertionAxiom(joinPoint.get(), aspect, annotations))  ;
    }

    public OWLAspectAssertionAxiom getAspectAssertionAxiom(@Nonnull JoinPoint joinPoint, @Nonnull Aspect aspect, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);

        return getAspectAssertionAxiom(joinPoint, aspect, annotationList);
    }


    public Aspect getAspect(Advice advice){
        return new Aspect(advice, null);
    }


    public Aspect getAspect(Advice advice, java.util.Set<? extends OWLAnnotation> annotations){
        return new Aspect(advice, annotations);
    }

    public Aspect getAspect(@Nonnull Advice advice, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);

        return getAspect(advice, annotationList);
    }


    public Advice getAdvice(OWLClass adviceClass){
        return new Advice(adviceClass.getIRI());
    }


    public JoinPoint getJoinPoint(OWLAnnotationSubject subject){
        return new JoinPoint(subject);
    }



    @Nonnull
    public OWLDeclarationAxiom getOWLDeclarationAxiom(@Nonnull OWLEntity owlEntity, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);

        return getOWLDeclarationAxiom(owlEntity, annotationList);
    }

    @Nonnull
    public OWLSubClassOfAxiom getOWLSubClassOfAxiom(@Nonnull OWLClassExpression subClass, @Nonnull OWLClassExpression superClass, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLSubClassOfAxiom(subClass, superClass, annotationList);
    }

    @Nonnull
    public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(@Nonnull Set<? extends OWLClassExpression> classExpressions, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLEquivalentClassesAxiom(classExpressions, annotationList);
    }

    @Nonnull
    public OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(@Nonnull OWLClassExpression clsA, @Nonnull OWLClassExpression clsB, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLEquivalentClassesAxiom(clsA, clsB, annotationList);
    }

    @Nonnull
    public OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(@Nonnull Set<? extends OWLClassExpression> classExpressions, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLDisjointClassesAxiom(classExpressions, annotationList);
    }

    @Nonnull
    public OWLDisjointUnionAxiom getOWLDisjointUnionAxiom(@Nonnull OWLClass owlClass, @Nonnull Set<? extends OWLClassExpression> classExpressions, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLDisjointUnionAxiom(owlClass, classExpressions, annotationList);
    }

    @Nonnull
    public OWLSubObjectPropertyOfAxiom getOWLSubObjectPropertyOfAxiom(@Nonnull OWLObjectPropertyExpression subProperty, @Nonnull OWLObjectPropertyExpression superProperty, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLSubObjectPropertyOfAxiom(subProperty, superProperty, annotationList);
    }

    @Nonnull
    public OWLSubPropertyChainOfAxiom getOWLSubPropertyChainOfAxiom(@Nonnull List<? extends OWLObjectPropertyExpression> chain, @Nonnull OWLObjectPropertyExpression superProperty, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLSubPropertyChainOfAxiom(chain, superProperty, annotationList);
    }

    @Nonnull
    public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(@Nonnull Set<? extends OWLObjectPropertyExpression> properties, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLEquivalentObjectPropertiesAxiom(properties, annotationList);
    }

    @Nonnull
    public OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(@Nonnull OWLObjectPropertyExpression propertyA, @Nonnull OWLObjectPropertyExpression propertyB, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLEquivalentObjectPropertiesAxiom(propertyA, propertyB, annotationList);
    }

    @Nonnull
    public OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(@Nonnull Set<? extends OWLObjectPropertyExpression> properties, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLDisjointObjectPropertiesAxiom(properties, annotationList);
    }

    @Nonnull
    public OWLInverseObjectPropertiesAxiom getOWLInverseObjectPropertiesAxiom(@Nonnull OWLObjectPropertyExpression forwardProperty, @Nonnull OWLObjectPropertyExpression inverseProperty, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLInverseObjectPropertiesAxiom(forwardProperty, inverseProperty,annotationList);
    }

    @Nonnull
    public OWLObjectPropertyDomainAxiom getOWLObjectPropertyDomainAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull OWLClassExpression classExpression, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLObjectPropertyDomainAxiom(property, classExpression, annotationList);
    }

    @Nonnull
    public OWLObjectPropertyRangeAxiom getOWLObjectPropertyRangeAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull OWLClassExpression range, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLObjectPropertyRangeAxiom(property, range, annotationList);
    }

    @Nonnull
    public OWLFunctionalObjectPropertyAxiom getOWLFunctionalObjectPropertyAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLFunctionalObjectPropertyAxiom(property, annotationList);
    }

    @Nonnull
    public OWLInverseFunctionalObjectPropertyAxiom getOWLInverseFunctionalObjectPropertyAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLInverseFunctionalObjectPropertyAxiom(property, annotationList);
    }

    @Nonnull
    public OWLReflexiveObjectPropertyAxiom getOWLReflexiveObjectPropertyAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLReflexiveObjectPropertyAxiom(property, annotationList);
    }

    @Nonnull
    public OWLIrreflexiveObjectPropertyAxiom getOWLIrreflexiveObjectPropertyAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLIrreflexiveObjectPropertyAxiom(property, annotationList);
    }

    @Nonnull
    public OWLSymmetricObjectPropertyAxiom getOWLSymmetricObjectPropertyAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLSymmetricObjectPropertyAxiom(property, annotationList);
    }

    @Nonnull
    public OWLAsymmetricObjectPropertyAxiom getOWLAsymmetricObjectPropertyAxiom(@Nonnull OWLObjectPropertyExpression propertyExpression, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLAsymmetricObjectPropertyAxiom(propertyExpression, annotationList);
    }

    @Nonnull
    public OWLTransitiveObjectPropertyAxiom getOWLTransitiveObjectPropertyAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLTransitiveObjectPropertyAxiom(property, annotationList);
    }

    @Nonnull
    public OWLSubDataPropertyOfAxiom getOWLSubDataPropertyOfAxiom(@Nonnull OWLDataPropertyExpression subProperty, @Nonnull OWLDataPropertyExpression superProperty, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLSubDataPropertyOfAxiom(subProperty, superProperty, annotationList);
    }

    @Nonnull
    public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(@Nonnull Set<? extends OWLDataPropertyExpression> properties, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLEquivalentDataPropertiesAxiom(properties, annotationList);
    }

    @Nonnull
    public OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(@Nonnull OWLDataPropertyExpression propertyA, @Nonnull OWLDataPropertyExpression propertyB, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLEquivalentDataPropertiesAxiom(propertyA, propertyB, annotationList);
    }

    @Nonnull
    public OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(@Nonnull Set<? extends OWLDataPropertyExpression> properties, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLDisjointDataPropertiesAxiom(properties, annotationList);
    }

    @Nonnull
    public OWLDataPropertyDomainAxiom getOWLDataPropertyDomainAxiom(@Nonnull OWLDataPropertyExpression property, @Nonnull OWLClassExpression domain, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLDataPropertyDomainAxiom(property, domain, annotationList);
    }

    @Nonnull
    public OWLDataPropertyRangeAxiom getOWLDataPropertyRangeAxiom(@Nonnull OWLDataPropertyExpression property, @Nonnull OWLDataRange owlDataRange, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLDataPropertyRangeAxiom(property, owlDataRange, annotationList);
    }

    @Nonnull
    public OWLFunctionalDataPropertyAxiom getOWLFunctionalDataPropertyAxiom(@Nonnull OWLDataPropertyExpression property, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLFunctionalDataPropertyAxiom(property, annotationList);
    }

    @Nonnull
    public OWLHasKeyAxiom getOWLHasKeyAxiom(@Nonnull OWLClassExpression ce, @Nonnull Set<? extends OWLPropertyExpression> objectProperties, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLHasKeyAxiom(ce, objectProperties, annotationList);
    }

    @Nonnull
    public OWLDatatypeDefinitionAxiom getOWLDatatypeDefinitionAxiom(@Nonnull OWLDatatype datatype, @Nonnull OWLDataRange dataRange, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return null;
    }

    @Nonnull
    public OWLSameIndividualAxiom getOWLSameIndividualAxiom(@Nonnull Set<? extends OWLIndividual> individuals, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLSameIndividualAxiom(individuals, annotationList);
    }

    @Nonnull
    public OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(@Nonnull Set<? extends OWLIndividual> individuals, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLDifferentIndividualsAxiom(individuals, annotationList);
    }

    @Nonnull
    public OWLClassAssertionAxiom getOWLClassAssertionAxiom(@Nonnull OWLClassExpression classExpression, @Nonnull OWLIndividual individual, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLClassAssertionAxiom(classExpression, individual, annotationList);
    }

    @Nonnull
    public OWLObjectPropertyAssertionAxiom getOWLObjectPropertyAssertionAxiom(@Nonnull OWLObjectPropertyExpression property, @Nonnull OWLIndividual individual, @Nonnull OWLIndividual object, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLObjectPropertyAssertionAxiom(property, individual, object, annotations);
    }

    @Nonnull
    public OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(@Nonnull OWLDataPropertyExpression property, @Nonnull OWLIndividual subject, @Nonnull OWLLiteral object, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLDataPropertyAssertionAxiom(property, subject, object, annotationList);
    }

    @Nonnull
    public OWLNegativeDataPropertyAssertionAxiom getOWLNegativeDataPropertyAssertionAxiom(@Nonnull OWLDataPropertyExpression property, @Nonnull OWLIndividual subject, @Nonnull OWLLiteral object, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLNegativeDataPropertyAssertionAxiom(property, subject, object, annotationList);
    }

    @Nonnull
    public OWLAnnotation getOWLAnnotation(@Nonnull OWLAnnotationProperty property, @Nonnull OWLAnnotationValue value, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLAnnotation(property, value, annotationList);
    }

    @Nonnull
    public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(@Nonnull OWLAnnotationProperty property, @Nonnull OWLAnnotationSubject subject, @Nonnull OWLAnnotationValue value, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLAnnotationAssertionAxiom(property, subject, value, annotationList);
    }

    @Nonnull
    public OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(@Nonnull OWLAnnotationSubject subject, @Nonnull OWLAnnotation annotation, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLAnnotationAssertionAxiom(subject, annotation, annotationList);
    }

    @Nonnull
    public OWLAnnotationPropertyDomainAxiom getOWLAnnotationPropertyDomainAxiom(@Nonnull OWLAnnotationProperty prop, @Nonnull IRI domain, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLAnnotationPropertyDomainAxiom(prop, domain, annotationList);
    }

    @Nonnull
    public OWLAnnotationPropertyRangeAxiom getOWLAnnotationPropertyRangeAxiom(@Nonnull OWLAnnotationProperty prop, @Nonnull IRI range, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLAnnotationPropertyRangeAxiom(prop, range, annotationList);
    }

    @Nonnull
    public OWLSubAnnotationPropertyOfAxiom getOWLSubAnnotationPropertyOfAxiom(@Nonnull OWLAnnotationProperty sub, @Nonnull OWLAnnotationProperty sup, @Nonnull Set<? extends OWLAnnotation> annotations, @Nonnull Set<Aspect> aspects) {
        Set<OWLAnnotation> annotationList = new HashSet<OWLAnnotation>();
        annotationList.addAll(annotations);
        annotationList.addAll(aspects);
        return getOWLSubAnnotationPropertyOfAxiom(sub, sup, annotationList);
    }



}
