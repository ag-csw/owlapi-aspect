package de.fuberlin.csw.aspect_owlapi;

import org.semanticweb.owlapi.model.*;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Set;

/**
 * Created by lars on 12.05.16.
 */
public interface OWLDataFactoryA extends OWLDataFactory, SWRLDataFactory, OWLEntityProvider,
        OWLEntityByTypeProvider, OWLAnonymousIndividualProvider,
        OWLAnonymousIndividualByIdProvider {


    /**
     * Gets an aspect assertion axiom
     *
     * @param joinPoint
     *        join Point of the aspect
     * @param advice
     *        A set of annotations. Cannot be null or contain nulls.
     * @return The aspect assertion axiom
     */
     OWLAspectAssertionAxiom getAspectAssertionAxiom(@Nonnull JoinPoint joinPoint,
                                                           @Nonnull Advice advice);


    /**
     * Gets an aspect assertion axiom
     *
     * @param joinPoint
     *        join Point of the aspect.
     * @param advice
     *        advice of the aspect
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @return The aspect assertion axiom
     */
     OWLAspectAssertionAxiom getAspectAssertionAxiom(@Nonnull JoinPoint joinPoint,
                                                           @Nonnull Advice advice,
                                                           @Nonnull java.util.Set<? extends OWLAnnotation> annotations);


    /**
     * Gets an aspect assertion axiom
     *
     * @param joinPoint
     *        join Point of the aspect.
     * @param advice
     *        advice of the aspect
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param  aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return The aspect assertion axiom
     */
     OWLAspectAssertionAxiom getAspectAssertionAxiom(@Nonnull JoinPoint joinPoint,
                                                           @Nonnull Advice advice,
                                                           @Nonnull java.util.Set<? extends OWLAnnotation> annotations,
                                                           @Nonnull Set<Aspect> aspects);


    /**
     * Gets an aspect assertion axiom
     *
     * @param joinPoint
     *        join Point of the aspect.
     * @param aspect
     *        aspect with some advice
     * @return The aspect assertion axiom
     */
     OWLAspectAssertionAxiom getAspectAssertionAxiom(@Nonnull JoinPoint joinPoint,
                                                           @Nonnull Aspect aspect);


    /**
     * Gets an aspect assertion axiom
     *
     * @param joinPoint
     *        join Point of the aspect.
     * @param aspect
     *        A set of annotations. Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @return The aspect assertion axiom
     */
     OWLAspectAssertionAxiom getAspectAssertionAxiom(@Nonnull JoinPoint joinPoint,
                                                           @Nonnull Aspect aspect,
                                                           @Nonnull java.util.Set<? extends OWLAnnotation> annotations);


    /**
     * Gets an aspect assertion axiom
     *
     * @param joinPoint
     *        join Point of the aspect.
     * @param aspect
     *        A set of annotations. Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param  aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return The aspect assertion axiom
     */
     OWLAspectAssertionAxiom getAspectAssertionAxiom(@Nonnull JoinPoint joinPoint,
                                                           @Nonnull Aspect aspect,
                                                           @Nonnull java.util.Set<? extends OWLAnnotation> annotations,
                                                           @Nonnull Set<Aspect> aspects);


    /**
     * Gets an Aspect
     *
     * @param advice
     *        advice of the aspect.
     * @return the aspect
     */
     Aspect getAspect(@Nonnull Advice advice);



    /**
     * Gets an Aspect
     *
     * @param advice
     *        join Point of the aspect.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @return The declaration axiom for the specified entity which is annotated
     *         with the specified annotations
     */
     Aspect getAspect(@Nonnull Advice advice,
                            @Nonnull java.util.Set<? extends OWLAnnotation> annotations);




    /**
     * Gets an Aspect
     *
     * @param advice
     *        join Point of the aspect.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return The declaration axiom for the specified entity which is annotated
     *         with the specified annotations
     */
     Aspect getAspect(@Nonnull Advice advice,
                            @Nonnull java.util.Set<? extends OWLAnnotation> annotations,
                            @Nonnull Set<Aspect> aspects);






    /**
     * Gets a declaration with zero or more annotations for an entity
     *
     * @param owlEntity
     *        The declared entity.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return The declaration axiom for the specified entity which is annotated
     *         with the specified annotations
     */
    @Nonnull
    OWLDeclarationAxiom getOWLDeclarationAxiom(@Nonnull OWLEntity owlEntity,
                                               @Nonnull Set<? extends OWLAnnotation> annotations,
                                               @Nonnull Set<Aspect> aspects);



    /**
     * @param subClass
     *        sub class
     * @param superClass
     *        super class
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a subclass axiom with specified annotations
     */
    @Nonnull
    OWLSubClassOfAxiom getOWLSubClassOfAxiom(
            @Nonnull OWLClassExpression subClass,
            @Nonnull OWLClassExpression superClass,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param classExpressions
     *        equivalent classes. Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an equivalent classes axiom with specified operands and
     *         annotations
     */
    @Nonnull
    OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
            @Nonnull Set<? extends OWLClassExpression> classExpressions,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param clsA
     *        one class for equivalence
     * @param clsB
     *        one class for equivalence
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an equivalent classes axiom with specified operands and
     *         annotations (special case with only two operands)
     */
    @Nonnull
    OWLEquivalentClassesAxiom getOWLEquivalentClassesAxiom(
            @Nonnull OWLClassExpression clsA, @Nonnull OWLClassExpression clsB,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);




    /**
     * @param classExpressions
     *        Disjoint classes. Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a disjoint class axiom with annotations
     */
    @Nonnull
    OWLDisjointClassesAxiom getOWLDisjointClassesAxiom(
            @Nonnull Set<? extends OWLClassExpression> classExpressions,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);




    /**
     * @param owlClass
     *        left hand side of the axiom. Cannot be null.
     * @param classExpressions
     *        right hand side of the axiom. Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a disjoint union axiom with annotations
     */
    @Nonnull
    OWLDisjointUnionAxiom getOWLDisjointUnionAxiom(@Nonnull OWLClass owlClass,
                                                   @Nonnull Set<? extends OWLClassExpression> classExpressions,
                                                   @Nonnull Set<? extends OWLAnnotation> annotations,
                                                   @Nonnull Set<Aspect> aspects);




    /**
     * @param subProperty
     *        sub Property
     * @param superProperty
     *        super Property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a subproperty axiom with annotations
     */
    @Nonnull
    OWLSubObjectPropertyOfAxiom getOWLSubObjectPropertyOfAxiom(
            @Nonnull OWLObjectPropertyExpression subProperty,
            @Nonnull OWLObjectPropertyExpression superProperty,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);




    /**
     * @param chain
     *        Chain of properties. Cannot be null or contain nulls.
     * @param superProperty
     *        super property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a subproperty chain axiom
     */
    @Nonnull
    OWLSubPropertyChainOfAxiom getOWLSubPropertyChainOfAxiom(
            @Nonnull List<? extends OWLObjectPropertyExpression> chain,
            @Nonnull OWLObjectPropertyExpression superProperty,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param properties
     *        Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an equivalent properties axiom with specified properties and
     *         annotations
     */
    @Nonnull
    OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
            @Nonnull Set<? extends OWLObjectPropertyExpression> properties,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);





    /**
     * @param propertyA
     *        property A
     * @param propertyB
     *        property B
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an equivalent properties axiom with specified properties and
     *         annotations
     */
    @Nonnull
    OWLEquivalentObjectPropertiesAxiom getOWLEquivalentObjectPropertiesAxiom(
            @Nonnull OWLObjectPropertyExpression propertyA,
            @Nonnull OWLObjectPropertyExpression propertyB,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param properties
     *        Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a disjoint object properties axiom with specified properties and
     *         annotations
     */
    @Nonnull
    OWLDisjointObjectPropertiesAxiom getOWLDisjointObjectPropertiesAxiom(
            @Nonnull Set<? extends OWLObjectPropertyExpression> properties,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);




    /**
     * @param forwardProperty
     *        forward Property
     * @param inverseProperty
     *        inverse Property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an inverse object property axiom with annotations
     */
    @Nonnull
    OWLInverseObjectPropertiesAxiom getOWLInverseObjectPropertiesAxiom(
            @Nonnull OWLObjectPropertyExpression forwardProperty,
            @Nonnull OWLObjectPropertyExpression inverseProperty,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);





    /**
     * @param property
     *        property
     * @param classExpression
     *        class Expression
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an object property domain axiom with annotations
     */
    @Nonnull
    OWLObjectPropertyDomainAxiom getOWLObjectPropertyDomainAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull OWLClassExpression classExpression,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param property
     *        property
     * @param range
     *        range
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an object property range axiom with annotations
     */
    @Nonnull
    OWLObjectPropertyRangeAxiom getOWLObjectPropertyRangeAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull OWLClassExpression range,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);




    /**
     * @param property
     *        property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a functional object property axiom with annotations
     */
    @Nonnull
    OWLFunctionalObjectPropertyAxiom getOWLFunctionalObjectPropertyAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);






    /**
     * @param property
     *        property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an inverse functional object property axiom with annotations
     */
    @Nonnull
    OWLInverseFunctionalObjectPropertyAxiom
    getOWLInverseFunctionalObjectPropertyAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);





    /**
     * @param property
     *        property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a reflexive object property axiom with annotations
     */
    @Nonnull
    OWLReflexiveObjectPropertyAxiom getOWLReflexiveObjectPropertyAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param property
     *        property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an irreflexive object property axiom with annotations
     */
    @Nonnull
    OWLIrreflexiveObjectPropertyAxiom getOWLIrreflexiveObjectPropertyAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);





    /**
     * @param property
     *        property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a symmetric property axiom with annotations
     */
    @Nonnull
    OWLSymmetricObjectPropertyAxiom getOWLSymmetricObjectPropertyAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);





    /**
     * @param propertyExpression
     *        property Expression
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an asymmetric object property axiom on the specified argument
     *         with annotations
     */
    @Nonnull
    OWLAsymmetricObjectPropertyAxiom getOWLAsymmetricObjectPropertyAxiom(
            @Nonnull OWLObjectPropertyExpression propertyExpression,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);





    /**
     * @param property
     *        property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a transitive object property axiom on the specified argument with
     *         annotations
     */
    @Nonnull
    OWLTransitiveObjectPropertyAxiom getOWLTransitiveObjectPropertyAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);





    /**
     * @param subProperty
     *        sub Property
     * @param superProperty
     *        super Property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a subproperty axiom with annotations
     */
    @Nonnull
    OWLSubDataPropertyOfAxiom getOWLSubDataPropertyOfAxiom(
            @Nonnull OWLDataPropertyExpression subProperty,
            @Nonnull OWLDataPropertyExpression superProperty,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param properties
     *        properties
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an equivalent data properties axiom with annotations
     */
    @Nonnull
    OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
            @Nonnull Set<? extends OWLDataPropertyExpression> properties,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param propertyA
     *        property A
     * @param propertyB
     *        property B
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an equivalent data properties axiom with annotations
     */
    @Nonnull
    OWLEquivalentDataPropertiesAxiom getOWLEquivalentDataPropertiesAxiom(
            @Nonnull OWLDataPropertyExpression propertyA,
            @Nonnull OWLDataPropertyExpression propertyB,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param properties
     *        Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a disjoint data properties axiom with specified properties and
     *         annotations
     */
    @Nonnull
    OWLDisjointDataPropertiesAxiom getOWLDisjointDataPropertiesAxiom(
            @Nonnull Set<? extends OWLDataPropertyExpression> properties,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param property
     *        property
     * @param domain
     *        domain
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a data property domain axiom with annotations
     */
    @Nonnull
    OWLDataPropertyDomainAxiom getOWLDataPropertyDomainAxiom(
            @Nonnull OWLDataPropertyExpression property,
            @Nonnull OWLClassExpression domain,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param property
     *        property
     * @param owlDataRange
     *        data range
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a data property range axiom with annotations
     */
    @Nonnull
    OWLDataPropertyRangeAxiom getOWLDataPropertyRangeAxiom(
            @Nonnull OWLDataPropertyExpression property,
            @Nonnull OWLDataRange owlDataRange,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param property
     *        property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a functional data property axiom with annotations
     */
    @Nonnull
    OWLFunctionalDataPropertyAxiom getOWLFunctionalDataPropertyAxiom(
            @Nonnull OWLDataPropertyExpression property,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param ce
     *        class expression
     * @param objectProperties
     *        Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a hasKey axiom on given arguments and annotations
     */
    @Nonnull
    OWLHasKeyAxiom getOWLHasKeyAxiom(@Nonnull OWLClassExpression ce,
                                     @Nonnull Set<? extends OWLPropertyExpression> objectProperties,
                                     @Nonnull Set<? extends OWLAnnotation> annotations,
                                     @Nonnull Set<Aspect> aspects);





    /**
     * @param datatype
     *        data type
     * @param dataRange
     *        data Range
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a datatype definition axiom with annotations
     */
    @Nonnull
    OWLDatatypeDefinitionAxiom getOWLDatatypeDefinitionAxiom(
            @Nonnull OWLDatatype datatype, @Nonnull OWLDataRange dataRange,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);




    /**
     * @param individuals
     *        Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a same individuals axiom with specified individuals and
     *         annotations
     */
    @Nonnull
    OWLSameIndividualAxiom getOWLSameIndividualAxiom(
            @Nonnull Set<? extends OWLIndividual> individuals,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);


    /**
     * @param individuals
     *        Cannot be null or contain nulls.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a different individuals axiom with specified individuals and
     *         annotations
     */
    @Nonnull
    OWLDifferentIndividualsAxiom getOWLDifferentIndividualsAxiom(
            @Nonnull Set<? extends OWLIndividual> individuals,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);




    /**
     * @param classExpression
     *        class Expression
     * @param individual
     *        individual
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a class assertion axiom with annotations
     */
    @Nonnull
    OWLClassAssertionAxiom getOWLClassAssertionAxiom(
            @Nonnull OWLClassExpression classExpression,
            @Nonnull OWLIndividual individual,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param property
     *        property
     * @param individual
     *        individual
     * @param object
     *        object
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an object property assertion with annotations
     */
    @Nonnull
    OWLObjectPropertyAssertionAxiom getOWLObjectPropertyAssertionAxiom(
            @Nonnull OWLObjectPropertyExpression property,
            @Nonnull OWLIndividual individual, @Nonnull OWLIndividual object,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param property
     *        property
     * @param subject
     *        subject
     * @param object
     *        object
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a data property assertion with annotations
     */
    @Nonnull
    OWLDataPropertyAssertionAxiom getOWLDataPropertyAssertionAxiom(
            @Nonnull OWLDataPropertyExpression property,
            @Nonnull OWLIndividual subject, @Nonnull OWLLiteral object,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param property
     *        property
     * @param subject
     *        subject
     * @param object
     *        object
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a negative property assertion axiom on given arguments with
     *         annotations
     */
    @Nonnull
    OWLNegativeDataPropertyAssertionAxiom
    getOWLNegativeDataPropertyAssertionAxiom(
            @Nonnull OWLDataPropertyExpression property,
            @Nonnull OWLIndividual subject, @Nonnull OWLLiteral object,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * Gets an annotation
     *
     * @param property
     *        the annotation property.
     * @param value
     *        The annotation value.
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls. nulls.
     * @return The annotation on the specified property with the specified value
     */
    @Nonnull
    OWLAnnotation getOWLAnnotation(@Nonnull OWLAnnotationProperty property,
                                   @Nonnull OWLAnnotationValue value,
                                   @Nonnull Set<? extends OWLAnnotation> annotations,
                                   @Nonnull Set<Aspect> aspects);




    /**
     * @param property
     *        property
     * @param subject
     *        subject
     * @param value
     *        value
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an annotation assertion axiom - with annotations
     */
    @Nonnull
    OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
            @Nonnull OWLAnnotationProperty property,
            @Nonnull OWLAnnotationSubject subject,
            @Nonnull OWLAnnotationValue value,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);


    /**
     * @param subject
     *        subject
     * @param annotation
     *        annotation
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an annotation assertion axiom - with annotations
     */
    @Nonnull
    OWLAnnotationAssertionAxiom getOWLAnnotationAssertionAxiom(
            @Nonnull OWLAnnotationSubject subject,
            @Nonnull OWLAnnotation annotation,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param prop
     *        prop
     * @param domain
     *        domain
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an annotation property domain assertion with annotations
     */
    @Nonnull
    OWLAnnotationPropertyDomainAxiom getOWLAnnotationPropertyDomainAxiom(
            @Nonnull OWLAnnotationProperty prop, @Nonnull IRI domain,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param prop
     *        prop
     * @param range
     *        range
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return an annotation property range assertion with annotations
     */
    @Nonnull
    OWLAnnotationPropertyRangeAxiom getOWLAnnotationPropertyRangeAxiom(
            @Nonnull OWLAnnotationProperty prop, @Nonnull IRI range,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);



    /**
     * @param sub
     *        sub property
     * @param sup
     *        super property
     * @param annotations
     *        A set of annotations. Cannot be null or contain nulls.
     * @param aspects
     *        A set of aspects. Cannot be null or contain nulls.
     * @return a sub annotation property axiom with specified properties and
     *         annotations
     */
    @Nonnull
    OWLSubAnnotationPropertyOfAxiom getOWLSubAnnotationPropertyOfAxiom(
            @Nonnull OWLAnnotationProperty sub,
            @Nonnull OWLAnnotationProperty sup,
            @Nonnull Set<? extends OWLAnnotation> annotations,
            @Nonnull Set<Aspect> aspects);









}
