package top.wuansg.note.leetcode;

//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗?
//
// 示例：
//
//
//输入：words = ["I","am","a","student","from","a","university","in","a","city"],
//word1 = "a", word2 = "student"
//输出：1
//
// 提示：
//
//
// words.length <= 100000

import top.wuansg.note.util.Assertions;

import java.util.Objects;

public class Meeting1711 {

    public static void main(String[] args) {
        Meeting1711 meeting1711 = new Meeting1711();
        Assertions.assertEquals(1, meeting1711.findClosest(new String[]{"I","am","a","student","from","a","university","in","a","city"}, "a", "student"));
    }

    public int findClosest(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int index1 = 0, index2 = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(word1, words[i])) {
                index1 = i;
                min = Math.min(min, Math.abs(index1 - index2));
                continue;
            }
            if (Objects.equals(word2, words[i])) {
                index2 = i;
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
}
