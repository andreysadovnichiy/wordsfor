package main.java.com.testcase.wordsfor;

import main.java.com.testcase.wordsfor.core.Dictionary;
import main.java.com.testcase.wordsfor.core.Process;
import main.java.com.testcase.wordsfor.output.DataTarget;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.Collator;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Андрей on 03.02.2017.
 */
public class MainRunner {
    public static void main(String[] args) {
        List<String> concatenatedWords = new LinkedList<>();

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Dictionary dictionary = (Dictionary) context.getBean("dictionary");
        Process process = context.getBean(Process.class);
        DataTarget save = (DataTarget) context.getBean("dataTarget");

        System.out.println("Processing...");

        Iterator<String> iterator = dictionary.getIterator();
        while (iterator.hasNext()) {
            String e = iterator.next();
            if (process.isConc(e))
                concatenatedWords.add(e);
        }

        System.out.println("First two the longest concatinated words are:");
        for (String item : process.getTwoLongestWords(concatenatedWords))
            System.out.println(item + "  - length " + item.length());

        System.out.println("Checkout another words in result.out on root");
        Collections.sort(concatenatedWords, Collator.getInstance());
        save.writeData(concatenatedWords);
    }
}
