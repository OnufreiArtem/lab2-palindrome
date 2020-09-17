package com.lodbrock;

import static java.lang.Character.isLetter;

public class Main {

    public static void main(String[] args) {

        String[] testLines = new String[] {
                "mamam",
                "mama.m",
                "Mamam",
                "m am amam",
                "шалаш",
                "sdfsdf",
                "Аргентина манит негра",
                "   ",
                "a",
                "\"joj\"",
                "",
                "Лепс спел"
        };

        for(String line : testLines){
            String result = isPalindrome(line) ? "is palindrome." : "isn't palindrome.";
            System.out.println(String.format("'%s' - %s", line, result));
        }

    }

    public static boolean isPalindrome(String text){
        if(text == null || text.equals("")) return false;

        int lCursor = 0, rCursor = text.length()-1; // set cursors
        boolean palindromeResult = true;
        boolean containsLetters = false;

        text = text.toLowerCase();

        while(lCursor < rCursor){
            //move right while is not letter
            while( !isLetter(text.charAt(lCursor)) ) {
                lCursor++;
                if(lCursor >= rCursor){
                    palindromeResult = containsLetters;
                    break;
                }
            }
            //move left while is not letter
            while ( !isLetter(text.charAt(rCursor)) ){
                rCursor--;
                if(lCursor >= rCursor){
                    palindromeResult = containsLetters;
                    break;
                }
            }

            containsLetters = true; // true if contains letters

            //check if characters are equal
            if(text.charAt(lCursor) != text.charAt(rCursor)){
                palindromeResult = false;
                break;
            }

            lCursor++; // move left cursor right
            rCursor--; // move right cursor left
        }

        return palindromeResult;
    }

}
