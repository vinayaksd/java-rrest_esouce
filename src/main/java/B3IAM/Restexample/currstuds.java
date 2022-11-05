package B3IAM.Restexample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class currstuds extends studs {

	float stipend;
	String trainer;
	
	@Override
	public String toString() {
		return "currstuds [stipend=" + stipend + ", trainer=" + trainer + ", id=" + id + ", name=" + name + ", courses="
				+ courses + ", age=" + age + "]";
	}
	

}
