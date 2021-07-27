package System.service;

import System.model.Analysis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author wanghao
 */
@XmlRootElement(name = "Analysis")
public class AnalysisWrapper {

    private List<Analysis> analysis;

    @XmlElement(name = "Analysis")
    public List<Analysis> getAnalysis() {
        return analysis;
    }

    public void setAnalysis(List<Analysis> analysis) {
        this.analysis = analysis;
    }
}