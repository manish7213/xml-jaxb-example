package mypackage;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "universityName",
        "location",
        "fees"
})
@XmlRootElement(name = "university")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class University {

    @XmlElement
    protected String universityName;
    @XmlElement
    protected String location;
    @XmlElement
    protected BigDecimal fees;
}
