package Task3;

import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {

        File wordFile = new File("A:\\Project Java\\HomeWorkJava\\HomeworkModule10\\src\\resources\\Task3FileDirectory\\word.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(wordFile))){
            String word;
            String text = "";
            while ((word = bufferedReader.readLine())!=null){
                text += word+" ";
            }


            printWordFrequencies(text);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printWordFrequencies(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> wordFrequencies = new HashMap<>();

        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
        
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequencies.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }
}
