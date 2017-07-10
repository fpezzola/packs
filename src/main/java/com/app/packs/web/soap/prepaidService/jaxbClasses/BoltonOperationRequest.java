//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.07.08 a las 05:10:38 PM ART 
//


package com.app.packs.web.soap.prepaidService.jaxbClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para boltonOperationRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="boltonOperationRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="boltonCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "boltonOperationRequest", propOrder = {
    "phoneNumber",
    "boltonCode"
})
public class BoltonOperationRequest {

    protected long phoneNumber;
    @XmlElement(required = true)
    protected String boltonCode;

    /**
     * Obtiene el valor de la propiedad phoneNumber.
     * 
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Define el valor de la propiedad phoneNumber.
     * 
     */
    public void setPhoneNumber(long value) {
        this.phoneNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad boltonCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoltonCode() {
        return boltonCode;
    }

    /**
     * Define el valor de la propiedad boltonCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoltonCode(String value) {
        this.boltonCode = value;
    }

}
