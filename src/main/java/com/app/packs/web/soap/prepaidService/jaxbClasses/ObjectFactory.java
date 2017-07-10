//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.07.08 a las 05:10:38 PM ART 
//


package com.app.packs.web.soap.prepaidService.jaxbClasses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ar.com.redmondsoftware.testprepaidservice.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteBoltonResponse_QNAME = new QName("http://service.testprepaidservice.redmondsoftware.com.ar/", "deleteBoltonResponse");
    private final static QName _GetPlanForUserResponse_QNAME = new QName("http://service.testprepaidservice.redmondsoftware.com.ar/", "getPlanForUserResponse");
    private final static QName _PurchaseBoltonResponse_QNAME = new QName("http://service.testprepaidservice.redmondsoftware.com.ar/", "purchaseBoltonResponse");
    private final static QName _DeleteBoltonRequest_QNAME = new QName("http://service.testprepaidservice.redmondsoftware.com.ar/", "deleteBoltonRequest");
    private final static QName _GetPlanForUserRequest_QNAME = new QName("http://service.testprepaidservice.redmondsoftware.com.ar/", "getPlanForUserRequest");
    private final static QName _PurchaseBoltonRequest_QNAME = new QName("http://service.testprepaidservice.redmondsoftware.com.ar/", "purchaseBoltonRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ar.com.redmondsoftware.testprepaidservice.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteBoltonResponse }
     * 
     */
    public DeleteBoltonResponse createDeleteBoltonResponse() {
        return new DeleteBoltonResponse();
    }

    /**
     * Create an instance of {@link GetPlanForUserResponse }
     * 
     */
    public GetPlanForUserResponse createGetPlanForUserResponse() {
        return new GetPlanForUserResponse();
    }

    /**
     * Create an instance of {@link PurchaseBoltonResponse }
     * 
     */
    public PurchaseBoltonResponse createPurchaseBoltonResponse() {
        return new PurchaseBoltonResponse();
    }

    /**
     * Create an instance of {@link BoltonOperationRequest }
     * 
     */
    public BoltonOperationRequest createBoltonOperationRequest() {
        return new BoltonOperationRequest();
    }

    /**
     * Create an instance of {@link UserOperationRequest }
     * 
     */
    public UserOperationRequest createUserOperationRequest() {
        return new UserOperationRequest();
    }

    /**
     * Create an instance of {@link OperationResult }
     * 
     */
    public OperationResult createOperationResult() {
        return new OperationResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBoltonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.testprepaidservice.redmondsoftware.com.ar/", name = "deleteBoltonResponse")
    public JAXBElement<DeleteBoltonResponse> createDeleteBoltonResponse(DeleteBoltonResponse value) {
        return new JAXBElement<DeleteBoltonResponse>(_DeleteBoltonResponse_QNAME, DeleteBoltonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlanForUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.testprepaidservice.redmondsoftware.com.ar/", name = "getPlanForUserResponse")
    public JAXBElement<GetPlanForUserResponse> createGetPlanForUserResponse(GetPlanForUserResponse value) {
        return new JAXBElement<GetPlanForUserResponse>(_GetPlanForUserResponse_QNAME, GetPlanForUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseBoltonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.testprepaidservice.redmondsoftware.com.ar/", name = "purchaseBoltonResponse")
    public JAXBElement<PurchaseBoltonResponse> createPurchaseBoltonResponse(PurchaseBoltonResponse value) {
        return new JAXBElement<PurchaseBoltonResponse>(_PurchaseBoltonResponse_QNAME, PurchaseBoltonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoltonOperationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.testprepaidservice.redmondsoftware.com.ar/", name = "deleteBoltonRequest")
    public JAXBElement<BoltonOperationRequest> createDeleteBoltonRequest(BoltonOperationRequest value) {
        return new JAXBElement<BoltonOperationRequest>(_DeleteBoltonRequest_QNAME, BoltonOperationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserOperationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.testprepaidservice.redmondsoftware.com.ar/", name = "getPlanForUserRequest")
    public JAXBElement<UserOperationRequest> createGetPlanForUserRequest(UserOperationRequest value) {
        return new JAXBElement<UserOperationRequest>(_GetPlanForUserRequest_QNAME, UserOperationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoltonOperationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.testprepaidservice.redmondsoftware.com.ar/", name = "purchaseBoltonRequest")
    public JAXBElement<BoltonOperationRequest> createPurchaseBoltonRequest(BoltonOperationRequest value) {
        return new JAXBElement<BoltonOperationRequest>(_PurchaseBoltonRequest_QNAME, BoltonOperationRequest.class, null, value);
    }

}
