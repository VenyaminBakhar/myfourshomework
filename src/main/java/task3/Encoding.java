package task3;

/**
 * Created by Вениамин on 7/17/2017.
 */
import sun.text.normalizer.UTF16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encoding {
    public static void main(String[] args) {
        FileInputStream inFile = null;
        FileOutputStream outFile = null;
        String fileIn = "C:\\Users\\Вениамин\\Desktop\\myfourshomework\\src\\main\\resources\\utf8.txt";
        String fileOut = "C:\\Users\\Вениамин\\Desktop\\myfourshomework\\src\\main\\resources\\utf16.txt";
        try {
            inFile = new FileInputStream(fileIn);
            int bytesAvailable = inFile.available();
            byte[] bytesReaded = new byte[bytesAvailable];
            String byteToString = new String(bytesReaded);
            outFile = new FileOutputStream(fileOut);
            outFile.write(byteToString.getBytes("UTF16"));
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл: " + fileIn);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        } finally {
            try {
                if (inFile != null) {
                    inFile.close();
                }
                outFile.close();
            } catch (IOException e) {
            }
        }

    }
}
