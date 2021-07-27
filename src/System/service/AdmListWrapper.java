package System.service;

import System.model.Administrator;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author wanghao
 */
@XmlRootElement(name = "Administrator")
public class AdmListWrapper {

    private List<Administrator> adm;

    @XmlElement(name = "Administrator")
    public List<Administrator> getAdm() {
        return adm;
    }

    public void setAdm(List<Administrator> adm) {
        this.adm = adm;
    }
}