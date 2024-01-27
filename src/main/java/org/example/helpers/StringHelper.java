package org.example.helpers;

public class StringHelper {

    public static String getCamelCaseString(String keyWords) {
        String[] words = keyWords.split("[\\W_]+");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                word = word.isEmpty() ? word : word.toLowerCase();
            } else {
                word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            }
            builder.append(word);
        }
        return builder.toString();
    }

    public static String getScreamingSnakeCaseString(String keyWords) {
        String[] words = keyWords.split("[\\W_]+");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (builder.length() != 0) {
                builder.append("_");
            }
            builder.append(word.toUpperCase());
        }
        return builder.toString();
    }
}
