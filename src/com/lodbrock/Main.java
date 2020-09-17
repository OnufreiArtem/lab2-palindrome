package com.lodbrock;

import java.time.Duration;
import java.time.Instant;

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
        /*
        Instant start, finish;

        start = Instant.now();
        isPalindrome("Аргентина манит негра"); // 12000000
        finish = Instant.now();

        System.out.println("isPalindrome : " + Duration.between(start, finish).getNano());

        start = Instant.now();
        isPalindrome2("Аргентина манит негра"); //4000000
        finish = Instant.now();

        System.out.println("isPalindrome2 : " + Duration.between(start, finish).getNano());
        */
        for(String line : testLines){
            String result = isPalindrome2(line) ? "is palindrome." : "isn't palindrome.";
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

    public static boolean isPalindrome2(String text){

        String cleanText = "";
        for(int i = 0; i < text.length(); i++ ){
            if(Character.isLetter(text.charAt(i))){
                cleanText += Character.toLowerCase(text.charAt(i));
            }
        }

        if(cleanText.equals("")) return false;

        for(int i = 0; i < cleanText.length(); i++) {
            if (cleanText.charAt(i) != cleanText.charAt(cleanText.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


}
