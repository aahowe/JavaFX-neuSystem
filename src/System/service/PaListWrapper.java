package System.service;

import System.model.Patient;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author wanghao
 */
@XmlRootElement(name = "Patient")
public class PaListWrapper {

    private List<Patient> patient;

    @XmlElement(name = "Patient")
    public List<Patient> getPa() {
        return patient;
    }

    public void setPa(List<Patient> patient) {
        this.patient = patient;
    }
}