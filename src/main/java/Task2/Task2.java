package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;


public class Task2 {
    public static void main(String[] args) {
        ArrayList<User> user = new ArrayList<>();
        File textFileUser = new File("A:\\Project Java\\HomeWorkJava\\HomeworkModule10\\src\\resources\\Task2FileDirectory\\file.txt");

        try ( BufferedReader bufferedReader = new BufferedReader( new FileReader(textFileUser))) {
            String[] userDiscription;
            String buffer;
            byte index = 0;
            while ((buffer =bufferedReader.readLine()) != null){
                if(index == 0){
                    index++;
                    continue;
                }
                userDiscription = buffer.split("\\s");
                user.add(new User(userDiscription[0],Integer.parseInt(userDiscription[1])));

            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);

        File userJson = new File("A:\\Project Java\\HomeWorkJava\\HomeworkModule10\\src\\resources\\Task2FileDirectory\\user.json");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userJson))){
            bufferedWriter.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
