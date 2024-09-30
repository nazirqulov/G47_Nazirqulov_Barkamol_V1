package task3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PhoneNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Papka yo'lini kiriting: ");
        String folderPath = scanner.nextLine();
        String fileName = "numbers.txt";

        File file = new File(folderPath, fileName);
        if (file.exists() && !file.isDirectory()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                Pattern pattern = Pattern.compile("\\+998\\d{2}\\d{7}");
                while ((line = br.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        System.out.println("Phone numbers:" + matcher.group());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(fileName + " fayli " + folderPath + " papkasida topilmadi.");
        }
        scanner.close();
    }
}
