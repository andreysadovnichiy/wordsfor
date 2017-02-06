package main.java.com.testcase.wordsfor.output;

import java.io.*;
import java.util.List;

/**
 * Created by Андрей on 04.02.2017.
 */
public class DataSourceFileWriter implements DataTarget {

    public void writeData(List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.out"))) {
            for (String item : data) {
                bw.write(item);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
