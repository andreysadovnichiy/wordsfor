package main.java.com.testcase.wordsfor.core;

import main.java.com.testcase.wordsfor.input.DataSource;

import java.util.Set;

/**
 * Created by Андрей on 04.02.2017.
 */
public class DictionaryFactory {
    public static Dictionary getInstance(DataSource dataSource) {
        Set<String> data = (Set<String>) dataSource.readData();
        return new Dictionary(data);
    }
}
