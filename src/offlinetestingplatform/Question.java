package offlinetestingplatform;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Question {

    private String content;
    private Dictionary options;
    private int correctAnswer;
    private int selectedAnswer;
    private boolean isAttempted;
    private boolean isCorrect;
    private int marks;

    public Question(String _content, ArrayList<String> _options, int _correct){

        content = _content;
        options = new Hashtable();

        int i=1;

        for (String option: _options) {
            options.put(Integer.toString(i), option);
            i++;
        }

        correctAnswer = _correct;

        isAttempted = false;
        marks = 4;
        selectedAnswer = -1;
    }
    
    public String getContent() {
        return content;
    }

    public int getSelectedAnswer() {
        return selectedAnswer;
    }

    public Dictionary getOptions() {
        return options;
    }

    public boolean isAttempted() {
        return isAttempted;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public boolean checkAnswer(int _selected){
        
        selectedAnswer = _selected;
        isAttempted = true;
        isCorrect = (correctAnswer == selectedAnswer);

        return isCorrect;
    
    }

}