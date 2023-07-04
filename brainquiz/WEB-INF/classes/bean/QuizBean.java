package bean;

import bean.BrainTestBean;
import bean.BrainChoiceDTO;
import java.io.Serializable;

/*
 *  問題と選択肢をセットで持つクラスであるクイズを定義しています。
 * 
 */
public class QuizBean extends Object implements Serializable {

    // 問題文と選択肢を保持
    private BrainTestBean question;
    private BrainChoiceDTO choices;

    public void setQuizQuestionBean(BrainTestBean question) {
        this.question = question;
    }

    public void setQuizQuestion(String question_) {
        this.question.setName(question_);
    }
    public void setQuizChoicesBeanDTO(BrainChoiceDTO choices) {
        this.choices = choices;
    }

    public BrainTestBean getQuizQuestionBean() {
        return this.question;
    }

    public String getQuizQuestion() {
        return  this.question.getName();
    }

    public BrainChoiceDTO getQuizChoicesBeanDTO() {
        return this.choices;
    }

    

}
