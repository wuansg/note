package top.wuansg.note.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> duplicateWords = new HashSet<>();
        String[] words = s1.split(" ");
        Set<String> existWords = new HashSet<>();
        for (String word : words) {
            if (existWords.contains(word)) {
                duplicateWords.add(word);
            } else {
                existWords.add(word);
            }
        }
        words = s2.split(" ");
        for (String word : words) {
            if (existWords.contains(word)) {
                duplicateWords.add(word);
            } else {
                existWords.add(word);
            }
        }
        existWords.removeAll(duplicateWords);
        return existWords.toArray(new String[0]);
    }
}
