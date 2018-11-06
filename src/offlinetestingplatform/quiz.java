package offlinetestingplatform;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class quiz {
    private Vector<question> questions = new Vector<>();

    public static void main(String[] args) {
        quiz quiz = new quiz();
        quiz.fillQuestionsFromCSV();
        quizInterface quizInterface = new quizInterface(quiz.getQuestions());
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
    public void fillQuestionsFromCSV(){

        //UPDATE FILE PATH TO RUN PROJECT
        String questionFilePath = ".\\src\\data\\questionStore.csv";

        File questionFile = new File(questionFilePath);

        try {
            BufferedReader questionReader = new BufferedReader(new FileReader(questionFile));

            Object[] questionImportList = questionReader.lines().toArray();

            questionReader.close();

            for(Object question: questionImportList){
                String questionString = question.toString().trim();
                String[] questionArray = questionString.split(",");

                ArrayList<String> options = new ArrayList<>();

                options.addAll(Arrays.asList(Arrays.copyOfRange(questionArray,1,5)));

                questions.add(new question(questionArray[0], options, Integer.parseInt(questionArray[5].trim())));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(quizInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(quizInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vector<question> getQuestions() {
        return questions;
    }
}
