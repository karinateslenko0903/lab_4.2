import java.util.Arrays;
import java.util.regex.Pattern;

public class Audit_4_2 {

    public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, -shift);
    }



    public static String filterWords(String[] words, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!regex.matcher(word).matches()) {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String[] findWordsByPattern(String sentence, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        return Arrays.stream(sentence.split("\\s+"))
                .filter(word -> regex.matcher(word).matches())
                .toArray(String[]::new);
    }

    public static String normalizeSpaces(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }


    public static String replaceNegativeNumbers(String text) {
        return text.replaceAll("-\\d+", "[]");
    }




    public static void main(String[] args) {

        String encrypted = caesarEncrypt("Hello, World!", 3);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + caesarDecrypt(encrypted, 3));


        String[] words = {"apple", "banana", "cherry", "avocado"};
        System.out.println("Filtered: " + filterWords(words, "^a.*"));


        String sentence = "apple banana cherry avocado";
        String[] matches = findWordsByPattern(sentence, "^a.*");
        System.out.println("Matched words: " + Arrays.toString(matches));


        String textWithSpaces = "   Hello,   world!   ";
        System.out.println("Normalized: " + normalizeSpaces(textWithSpaces));


        String stringWithNumbers = "String 12 with numbers -1, 2, 5, -4, 12. Replace all negative";
        System.out.println("Replaced negatives: " + replaceNegativeNumbers(stringWithNumbers));
    }

}