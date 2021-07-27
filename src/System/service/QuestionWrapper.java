package System.service;

import System.model.Question;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author wanghao
 */
@XmlRootElement(name = "Question")
public class QuestionWrapper {

    private List<Question> question;

    @XmlElement(name = "Question")
    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }
}
