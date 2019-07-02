package training.patterns.decorator.nio;

import java.io.*;

class Runner {

    public static void main(String[] args) {
        try (InputStream inputStream = new UpperCaseInputStream(new FileInputStream(new File("ffile.txt")))) {
            int codePoint;
            StringBuilder content = new StringBuilder();
            while ((codePoint = inputStream.read()) != -1) {
                content.append(Character.toString(codePoint));
            }
            System.out.println("content = " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
