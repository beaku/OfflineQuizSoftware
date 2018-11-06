package offlinetestingplatform;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class quiz {
    private Vector<question> questions = new Vector<>();

    public static void main(String[] args) {
        quiz quiz = new quiz();

        quizInterface quizInterface = new quizInterface(quiz.generateSampleQuestions());
    }

    public Vector<question> generateSampleQuestions(){

        Vector<question> questions = new Vector<>();

            for(Integer i = 0; i < 20; i++){

                ArrayList options = new ArrayList<String>();

                options.addAll(0, Arrays.asList("option 1","option 2","option 3","option 4"));
                questions.add(new question("question "+Integer.toString(i+1), options,i%4+1));
            }

        return questions;
    }

}
