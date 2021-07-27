package System.service;

import System.model.Bed;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author wanghao
 */
@XmlRootElement(name = "Bed")
public class BedListWrapper {

    private List<Bed> bed;

    @XmlElement(name = "Bed")
    public List<Bed> getBed() {
        return bed;
    }

    public void setBed(List<Bed> bed) {
        this.bed = bed;
    }
}