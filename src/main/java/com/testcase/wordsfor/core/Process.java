package main.java.com.testcase.wordsfor.core;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Андрей on 04.02.2017.
 */
public class Process {
    private boolean flag;
    private int originalStrLen;

    @Autowired
    private Dictionary dictionary;


    private void setTail(String e) {
        int len = e.length();

        if (flag)
            return;

        if (len <= 3)
            flag = dictionary.isContain(e);

        else if (len >= 4) {
            for (int i = 2; i <= len; i++) {
                if (flag || originalStrLen == i)
                    return;
                String head = e.substring(0, i);
                if (dictionary.isContain(head)) {
                    String tail = e.substring(i);
                    if (tail.length() != 0)
                        setTail(tail);
                    else
                        flag = true;
                }
            }
        }
    }

    public boolean isConc(String e) {
        flag = false;
        originalStrLen = e.length();

        if (e.length() <= 3)
            flag = false;
        else
            setTail(e);

        return flag;
    }

    public List<String> getTwoLongestWords(List<String> source) {
        String first = "";
        String second = "";
        int firstLen = 0;
        int secondLen = 0;
        int len;

        for (String item : source) {
            len = item.length();
            if (len <= secondLen)
                continue;
            if (len > secondLen && len < firstLen) {
                second = item;
                secondLen = len;
            } else if (len > firstLen) {
                second = first;
                first = item;
                secondLen = second.length();
                firstLen = first.length();
            }
        }

        return Arrays.asList(first, second);
    }
}
