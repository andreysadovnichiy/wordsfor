package main.java.com.testcase.wordsfor.core;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Андрей on 04.02.2017.
 */
public final class Dictionary {
    private final Set<String> dictionary;

    public Dictionary(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isContain(String str){
        return dictionary.contains(str);
    }

    public Iterator<String> getIterator() {
        return dictionary.iterator();
    }}
