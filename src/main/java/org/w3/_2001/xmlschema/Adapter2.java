package org.w3._2001.xmlschema;

import java.util.Calendar;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter2
    extends XmlAdapter<String, Calendar>
{


    public Calendar unmarshal(String value) {
        return (javax.xml.bind.DatatypeConverter.parseDate(value));
    }

    public String marshal(Calendar value) {
        if (value == null) {
            return null;
        }
        return (javax.xml.bind.DatatypeConverter.printDate(value));
    }

}
