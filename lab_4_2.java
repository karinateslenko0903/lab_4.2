import java.util.HashMap;
import java.util.Map;

public class lab_4_2 {
    public static void main(String[] args) {
        String input = "Привіт, як справи?";
        Map<Character, Integer> frequencyMap = countCharacterFrequency(input);


        System.out.println("Частота входження символів:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }

    public static Map<Character, Integer> countCharacterFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        return frequencyMap;
    }
}
