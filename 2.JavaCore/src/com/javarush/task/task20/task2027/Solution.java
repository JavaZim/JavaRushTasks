package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'm', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'r'}
        };

        int[][] crossword1 = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        List<Word> words = detectAllWords(crossword1, "home", "same", "emoh", "emas", "fderlk", "klredf", "fulmp", "poeejj", "jjeeop",
                "pmluf", "kovhj", "jhvok", "lprr", "rrpl", "lprr", "o", "", null, "test", "eo", "oe", "re");



        for (Word word :words) {
            System.out.println(word);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();

        for (int a = 0; a < words.length; a++) {
            if (words[a] != null && words[a].length() != 0) {
                int len = words[a].length()-1;
                int start = words[a].charAt(0);
                int end = words[a].charAt(len);
                char [] chars = words[a].toCharArray();
                String checkWord = "";
                int x;
                int y;

                for (int k = 0; k < crossword.length; k++) {
                    for (int l = 0; l < crossword[k].length; l++) {
                        if(start == crossword[k][l]){
                            y = k;
                            x = l;

                            if(x - len >= 0 && y - len >= 0){

                                if(words[a].length() == 1 && crossword[y][x] == end){
                                    list.add(createWord(words[a], l, k, x, y));
                                    checkWord = "";
                                    continue;
                                }

                                if(crossword[y-len][x-len] == end){
                                    for (int i = 0; i < chars.length; i++) {
                                        if(chars[i] == crossword[y][x]){
                                            checkWord += (char)crossword[y][x];
                                            if(words[a].equals(checkWord)){
                                                list.add(createWord(checkWord, l, k, x, y));
                                                checkWord = "";
                                                y = k;
                                                x = l;
                                            } else {
                                                --x;
                                                --y;
                                                continue;
                                            }
                                        } else break;
                                    }
                                    checkWord = "";
                                    y = k;
                                    x = l;
                                }
                            }
                            if(y - len >= 0 ){
                                if(crossword[y-len][l] == end){
                                    for (int i = 0; i < chars.length; i++) {
                                        if (chars[i] == crossword[y][x]) {
                                            checkWord += (char) crossword[y][x];
                                            if (words[a].equals(checkWord)) {
                                                list.add(createWord(checkWord, l, k, x, y));

                                            } else {
                                                --y;
                                                continue;
                                            }
                                        } else break;
                                    }
                                }
                                checkWord = "";
                                y = k;
                                x = l;
                            }
                            if(x + len <= crossword[k].length-1 && y - len >=0){
                                if(crossword[y-len][x+len] == end){
                                    for (int i = 0; i < chars.length; i++) {
                                        if(chars[i] == crossword[y][x]){
                                            checkWord += (char)crossword[y][x];
                                            if(words[a].equals(checkWord)){
                                                list.add(createWord(checkWord, l, k, x, y));
                                            } else {
                                                ++x;
                                                --y;
                                                continue;
                                            }
                                        } else break;
                                    }
                                }
                                checkWord = "";
                                y = k;
                                x = l;
                            }
                            if(x + len <= crossword[k].length-1){
                                if(crossword[k][x+len] == end){
                                    for (int i = 0; i < chars.length; i++) {
                                        if(chars[i] == crossword[y][x]){
                                            checkWord += (char)crossword[y][x];
                                            if(words[a].equals(checkWord)){
                                                list.add(createWord(checkWord, l, k, x, y));
                                            } else {
                                                ++x;
                                                continue;
                                            }
                                        } else break;
                                    }
                                }
                                checkWord = "";
                                y = k;
                                x = l;
                            }
                            if(x + len <= crossword[k].length-1 && y + len <= crossword.length-1){
                                if(crossword[y + len][x + len] == end){
                                    for (int i = 0; i < chars.length; i++) {
                                        if(chars[i] == crossword[y][x]){
                                            checkWord += (char)crossword[y][x];
                                            if(words[a].equals(checkWord)){
                                                list.add(createWord(checkWord, l, k, x, y));
                                            } else {
                                                ++x;
                                                ++y;
                                                continue;
                                            }
                                        } else break;
                                    }
                                }
                                checkWord = "";
                                y = k;
                                x = l;
                            }
                            if(y + len <= crossword.length-1){
                                if(crossword[y+len][l] == end){
                                    for (int i = 0; i < chars.length; i++) {
                                        if(chars[i] == crossword[y][x]){
                                            checkWord += (char)crossword[y][x];
                                            if(words[a].equals(checkWord)){
                                                list.add(createWord(checkWord, l, k, x, y));
                                            } else {
                                                ++y;
                                                continue;
                                            }
                                        } else break;
                                    }
                                }
                                checkWord = "";
                                y = k;
                                x = l;
                            }
                            if(x - len >= 0 && y + len <= crossword.length-1){
                                if(crossword[y + len][x - len] == end){
                                    for (int i = 0; i < chars.length; i++) {
                                        if(chars[i] == crossword[y][x]) {
                                            checkWord += (char) crossword[y][x];
                                            if (words[a].equals(checkWord)) {
                                                list.add(createWord(checkWord, l, k, x, y));
                                            } else {
                                                --x;
                                                ++y;
                                                continue;
                                            }
                                        }
                                    }
                                }
                                checkWord = "";
                                y = k;
                                x = l;
                            }
                            if(x - len >= 0){
                                if(crossword[k][x-len] == end){
                                    for (int i = 0; i < chars.length; i++) {
                                        if(chars[i] == crossword[y][x]) {
                                            checkWord += (char) crossword[y][x];
                                            if (words[a].equals(checkWord)) {
                                                list.add(createWord(checkWord, l, k, x, y));
                                            } else {
                                                --x;
                                                continue;
                                            }
                                        }
                                    }
                                }
                                checkWord = "";
                                y = k;
                                x = l;
                            }

                        }
                    }
                }
            }
        }

        return list;
    }


    private static Word createWord(String text, int x1, int y1, int x2, int y2){
        Word word = new Word(text);
        word.setStartPoint(x1,y1);
        word.setEndPoint(x2,y2);
        return word;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
