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
    public void processMethod() throws IOException {

    Properties props2 = new Properties();
        props2.setProperty("annotators","tokenize, ssplit, pos, lemma, ner, parse, dcoref");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props2);

    String inputPath2;
    inputPath2 ="Z:\\Summer 2017\\Workspace\\Spark WordCount\\src\\main\\resources\\input1.txt";

    String outputPath2;
    outputPath2 ="Z:\\Summer 2017\\Workspace\\Spark WordCount\\src\\main\\resources\\ouput.txt";

    // The below code is for Lab 2
    File inputFile2 = new File(inputPath2);
    Scanner input2 = new Scanner(new FileReader(inputFile2));
    String inputString2;
    StringBuilder inputSB2 = new StringBuilder();
    while(input2.hasNext())
    {
        inputSB2.append(input2.next());
        inputSB2.append('\t');
    }
    input2.close();
    inputString2 =inputSB2.toString();

    StringBuilder sb2 = new StringBuilder();
    String outString2;

    // create an empty Annotation just with the given text.
    Annotation document2 = new Annotation(inputString2);
    pipeline.annotate(document2);

    List<CoreMap> sentences2 = document2.get(CoreAnnotations.SentencesAnnotation.class);
    for(CoreMap sentence :sentences2)
    {
        for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
            String word2 = token.get(CoreAnnotations.TextAnnotation.class);
            String ne2 = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

            if (ne2.equalsIgnoreCase("O")) {
                // no NEP relationship.
            } else {
                sb2.append(ne2);
                sb2.append(" ");
                sb2.append(word2);
                sb2.append(" ");
                sb2.append('\n');
            }
        }
    }
    try
    {
        outString2 = sb2.toString();
        FileWriter fileWriter2 = new FileWriter(outputPath2);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
        bufferedWriter2.write(outString2);

        // Close the file
        bufferedWriter2.close();
    }
    catch(IOException ex)
    {
        System.out.println("Error");

    }
    }

    public String qaMethod(String question) throws IOException {

        Properties props3 = new Properties();
        props3.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props3);

        Annotation document3 = new Annotation(question);
        pipeline.annotate(document3);

        // these are all the sentences in the given question
        List<CoreMap> sentences3 = document3.get(CoreAnnotations.SentencesAnnotation.class);

        StringBuilder sb4 = new StringBuilder();
        String outString4;

        for (CoreMap sentence : sentences3) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {

                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);

                String outputPath3;
                outputPath3 ="Z:\\Summer 2017\\Workspace\\Spark WordCount\\src\\main\\resources\\ouput.txt";

                File inputFile3 = new File(outputPath3);
                Scanner input3 = new Scanner(new FileReader(inputFile3));
                String inputString3;

                while (input3.hasNext()) {
                    inputString3 = input3.next();

                    if (lemma.equalsIgnoreCase("PERSON") && inputString3.equalsIgnoreCase("PERSON")) {
                        String finalValue4;
                        finalValue4 = input3.next();
                        sb4.append(finalValue4);
                        sb4.append('\n');
                    }
                    if (lemma.equalsIgnoreCase("NUMBER") && inputString3.equalsIgnoreCase("NUMBER")) {
                        String finalValue4;
                        finalValue4 = input3.next();
                        sb4.append(finalValue4);
                        sb4.append('\n');
                    }
                    if (lemma.equalsIgnoreCase("LOCATION") && inputString3.equalsIgnoreCase("LOCATION")) {
                        String finalValue4;
                        finalValue4 = input3.next();
                        sb4.append(finalValue4);
                        sb4.append('\n');
                    }
                    if (lemma.equalsIgnoreCase("ORGANISATION") && inputString3.equalsIgnoreCase("ORGANISATION")) {
                        String finalValue4;
                        finalValue4 = input3.next();
                        sb4.append(finalValue4);
                        sb4.append('\n');
                    }

                }
                input3.close();
            }
        }
        outString4 = sb4.toString();
        return outString4;
    }
    public static void main(String args[]) {
       //Dummy method
    }
}
