
package mypackage;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "title",
        "author",
        "year",
        "price",
        "myField",
        "university"
})
@XmlRootElement(name = "book")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @XmlElement(required = true)
    protected Title title;
    @XmlElement(required = true)
    protected String author;
    @XmlElement(required = true)
    protected BigInteger year;
    @XmlElement(required = true)
    protected BigDecimal price;
    @XmlAttribute(name = "category", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String category;
    @XmlElement(required = false)
    protected BigDecimal myField;
    @XmlElement(required = false)
    protected List<University> university;


}
