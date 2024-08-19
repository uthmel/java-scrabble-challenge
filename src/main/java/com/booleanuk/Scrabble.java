package com.booleanuk;

import java.util.HashMap;
import java.util.Map;

public class Scrabble {
    private final String word;
    private static final Map<Character,Integer> letterMap = new HashMap<>();
    static {
        letterMap.put('A', 1);
        letterMap.put('E', 1);
        letterMap.put('I', 1);
        letterMap.put('O', 1);
        letterMap.put('U', 1);
        letterMap.put('L', 1);
        letterMap.put('N', 1);
        letterMap.put('R', 1);
        letterMap.put('S', 1);
        letterMap.put('T', 1);
        letterMap.put('D', 2);
        letterMap.put('G', 2);
        letterMap.put('B', 3);
        letterMap.put('C', 3);
        letterMap.put('M', 3);
        letterMap.put('P', 3);
        letterMap.put('F', 4);
        letterMap.put('H', 4);
        letterMap.put('V', 4);
        letterMap.put('W', 4);
        letterMap.put('Y', 4);
        letterMap.put('K', 5);
        letterMap.put('J', 8);
        letterMap.put('X', 8);
        letterMap.put('Q', 10);
        letterMap.put('Z', 10);
    }



    public Scrabble(String word) {
        if (word == null) {
            this.word="";
        } else {
            this.word = word.trim().toUpperCase();
        }
        }


    public int score() {
        int FullScore = 0;
        int wordMultiplier = 1;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (letter == '{' && i + 2 < word.length() && word.charAt(i + 2) == '}') {
                FullScore += letterMap.getOrDefault(word.charAt(i + 1), 0) * 2;
                i += 2;
            }

            else if (letter == '[' && i + 2 < word.length() && word.charAt(i + 2) == ']') {
                FullScore += letterMap.getOrDefault(word.charAt(i + 1), 0) * 3;
                i += 2;
            }


            else if (letter == '{' && word.charAt(word.length() - 1) == '}') {
                wordMultiplier = 2;

            }

            else if (letter == '[' && word.charAt(word.length() - 1) == ']') {
                wordMultiplier = 3;

            }

            else if (letter != '}' && letter != ']') {
                FullScore += letterMap.getOrDefault(letter, 0);
            }
        }

        return FullScore * wordMultiplier;
    }

}
