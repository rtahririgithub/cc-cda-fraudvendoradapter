//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.04 at 12:07:05 PM PST 
//


package com.fico.afm.model.application.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecondaryIdentificationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SecondaryIdentificationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PASSPORT"/&gt;
 *     &lt;enumeration value="TAX_ID"/&gt;
 *     &lt;enumeration value="DRIVERS_LICENSE"/&gt;
 *     &lt;enumeration value="NATIONAL_ID"/&gt;
 *     &lt;enumeration value="STATE_ID"/&gt;
 *     &lt;enumeration value="CORPORATION_ID"/&gt;
 *     &lt;enumeration value="MILITARY_ID"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="OTHER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SecondaryIdentificationType")
@XmlEnum
public enum SecondaryIdentificationType {

    PASSPORT,
    TAX_ID,
    DRIVERS_LICENSE,
    NATIONAL_ID,
    STATE_ID,
    CORPORATION_ID,
    MILITARY_ID,
    NONE,
    OTHER;

    public String value() {
        return name();
    }

    public static SecondaryIdentificationType fromValue(String v) {
        return valueOf(v);
    }

}
