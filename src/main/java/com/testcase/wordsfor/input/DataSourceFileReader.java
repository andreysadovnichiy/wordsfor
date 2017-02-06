package main.java.com.testcase.wordsfor.input;

import main.java.com.testcase.wordsfor.core.DictionaryFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Андрей on 04.02.2017.
 */
public class DataSourceFileReader implements DataSource {
    @Override
    public Iterable<String> readData() {
        Set<String> dic = new HashSet<>();

        FileInputStream fis = null;
        try {
            ClassLoader classLoader = DictionaryFactory.class.getClassLoader();
            File file = new File(classLoader.getResource("words.txt").getFile());

            fis = new FileInputStream(file);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {

                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line.length() >= 2)
                        dic.add(line);
                }

                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dic;
    }
}
