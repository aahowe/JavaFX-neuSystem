package System.service;

import System.model.Template;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author wanghao
 */
@XmlRootElement(name = "Template")
public class TemplateWrapper {

    private List<Template> template;

    @XmlElement(name = "Template")
    public List<Template> getTemplate() {
        return template;
    }

    public void setTemplate(List<Template> template) {
        this.template = template;
    }
}