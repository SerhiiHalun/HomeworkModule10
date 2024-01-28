package Task1;

import java.io.*;


public class Task1 {
    public static void main(String[] args) {
        File  numberBook = new File("A:\\Project Java\\HomeWorkJava\\HomeworkModule10\\src\\resources\\file.txt");
        IfFileNotFound(numberBook);
        try (FileWriter writer = new FileWriter(numberBook);){
            writer.write("987-123-4567\n" +
                    "123 456 7890\n" +
                    "(123) 456-7890");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(numberBook))) {
            String line;
            while ((line = reader.readLine()) != null) {
                correctNumber(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void correctNumber(String text){
        if(text.isBlank()||text.isEmpty()){
            System.out.println("Empty");
        }
        String number = text.replaceAll("\\d","x");
        if(number.equals("xxx-xxx-xxxx")){
            System.out.println(text);
        }else {
            if(number.equals("(xxx) xxx-xxxx")){
                System.out.println(text);
            }
        }

    }
    public static void IfFileNotFound(File file){
        if(!file.exists()){
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            }catch (IOException io){
                System.out.println(io.getMessage());
            }
        }
    }
}