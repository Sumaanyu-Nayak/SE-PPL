/*
 * Create a new Java class file (e.g., StringOperations.java). 📝
Implement the following string operations in your program:
Find the Length of a String 📏
Use the length() method to determine the length of a string. 🔍
Compare Two Strings ⚖️
Use the equals() method to compare two strings for equality. 🤝
Extract a Character from a String 🔤
Use the charAt(index) method to extract a character from a specific index of a string. 📍
Concatenate Two Strings ➕
Use the concat() method or the + operator to join two strings together. 🔗
Replace Part of a String 🔄
Use the replace(oldChar, newChar) or replace(oldString, newString) method to replace a part of a string with another substring. ✏️

 */

import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        // Declare and initialize two strings
        String str1;
        String str2;

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("String Operations in Java");
        System.out.println("\n");
        System.out.print("Enter the first string:");
        str1 = scanner.nextLine();
        System.out.print("Enter the second string:");
        str2 = scanner.nextLine();

        // Close the scanner
        scanner.close();
        // Find the Length of a String
        int length = str1.length();
        System.out.println("\n\tLength of str1: " + length);

        // Find the Length of a String
        boolean isEqual = str1.equals(str2);
        System.out.println("\n\tAre str1 and str2 equal? " + isEqual);

        // Extract a Character from a String
        char character = str1.charAt(length-2);
        System.out.println("\n\tCharacter at index 7 in str1: " + character);

        // Concatenate Two Strings
        String concatenatedString = str1.concat(" ").concat(str2);
        System.out.println("\n\tConcatenated String: " + concatenatedString);

        // Replace Part of a String
        String replacedString = str1.replace("World", "Java");
        System.out.println("\n\tReplaced String: " + replacedString);
    }
    
}
