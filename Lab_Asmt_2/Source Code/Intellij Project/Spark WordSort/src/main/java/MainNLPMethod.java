
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Lava on 20-Jun-17.
 */

public class MainNLPMethod {

    public String lemmaMethod() throws IOException
    {
        Properties props1 = new Properties();
        props1.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props1);

        String inputPath1 ;
        String outputPath1 ;

        // The name of the file to open
        inputPath1 = "Z:\\Summer 2017\\Workspace\\Spark WordCount\\src\\main\\resources\\input1.txt" ;
        outputPath1 = "Z:\\Summer 2017\\Workspace\\Spark WordCount\\output1.txt";

        // The below code is for Lab 2.
        File inputFile1 = new File(inputPath1);
        Scanner input1 = new Scanner(new FileReader(inputFile1));
        String inputString1;
        String outputString1;
        StringBuilder inputSB1 = new StringBuilder();
        while(input1.hasNext()) {
            inputSB1.append(input1.next());
            inputSB1.append('\t');
        }
        input1.close();
        inputString1 = inputSB1.toString();

        Annotation document1 = new Annotation(inputString1);
        pipeline.annotate(document1);
        String outputString2;
        StringBuilder sbOut = new StringBuilder();

        List<CoreMap> sentences = document1.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {

                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                sbOut.append(lemma);
                sbOut.append(" ");

            }

        }
        outputString2 = sbOut.toString();

        try {
            FileWriter fileWriter1 = new FileWriter(outputPath1);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
            bufferedWriter1.write(outputString2);

            bufferedWriter1.close();
        }
        catch(IOException ex) {
            System.out.println("Error");

        }

        return outputString2;
    }
    public static void main(String args[]) {
      //Dummy method.
    }
}
