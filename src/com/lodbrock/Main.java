package com.lodbrock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Character.isLetter;

public class Main {

    public static void main(String[] args) throws InterruptedException {

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
                "Лепс спел",
                "mooml"
        };

        for(String line : testLines){
            String result = isPalindrome4(line) ? "is palindrome." : "isn't palindrome.";
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

        String cleanText = getLettersFromText(text);

        if(cleanText.equals("")) return false;

        for(int i = 0; i < cleanText.length(); i++) {
            if (cleanText.charAt(i) != cleanText.charAt(cleanText.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(String text){
        String cleanText = getLettersFromText(text);
        if(cleanText.equals("")) return false;
        String reverseCleanText = new StringBuilder(cleanText).reverse().toString();
        return cleanText.equals(reverseCleanText);
    }

    public static boolean isPalindrome4(String text){
        List<Character> letters = new ArrayList<>();
        for(char letter : getLettersFromText(text).toCharArray()){
            letters.add(letter);
        }

        List<Character> reversedCopy = new ArrayList<>(letters);
        Collections.reverse(reversedCopy);
        for(int i = 0; i < letters.size(); i++){
            if(!letters.get(i).equals(reversedCopy.get(i))) return false;
        }
        return true;
    }

    public static String getLettersFromText(String badText){
        StringBuilder cleanText = new StringBuilder();
        for(int i = 0; i < badText.length(); i++ ){
            if(Character.isLetter(badText.charAt(i))){
                cleanText.append(Character.toLowerCase(badText.charAt(i)));
            }
        }
        return cleanText.toString();

    }

}
