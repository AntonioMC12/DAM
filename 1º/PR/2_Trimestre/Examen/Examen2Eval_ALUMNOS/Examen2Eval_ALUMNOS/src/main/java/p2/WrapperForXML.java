package p2;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="lista")
@XmlAccessorType (XmlAccessType.FIELD)
public class WrapperForXML {
	@XmlElement(name="persona")
	private Persona[] c;
	public WrapperForXML() {}
	public WrapperForXML(Collection<Persona> c) {
		this.c=c.toArray(new Persona[c.size()]);
	}
	
}
