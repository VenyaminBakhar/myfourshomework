package task1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Вениамин on 7/17/2017.
 */
public class ByteStream {
    static FileInputStream fileIn = null;
    static FileOutputStream fileOut = null;
    static String fileInPath = "C:\\Users\\Вениамин\\Desktop\\myfourshomework\\src\\main\\resources\\inFile.txt";
    static String fileOutPath = "C:\\Users\\Вениамин\\Desktop\\myfourshomework\\src\\main\\resources\\outFile.txt";
    static List<String> reservedWords = Arrays.asList("abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue", "default", "double", "do", "else",
            "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof",
            "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short",
            "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
            "volatile", "while");
    static Integer countOfWords = 0;
    public static void main(String[] args) {
        try {
            fileIn = new FileInputStream(fileInPath);
            fileOut = new FileOutputStream(fileOutPath);
            byte[] buffer = new byte[fileIn.available()];
            fileIn.read(buffer,0,fileIn.available());
            String byteToString = new String(buffer);
            for (String keyWord : reservedWords){
                if (byteToString.contains(keyWord)){
                    fileOut.write(keyWord.getBytes());
                    fileOut.write("\n".getBytes());
                    countOfWords++;
                }
            }
            fileOut.write(countOfWords.toString().getBytes());

        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException ex){
            System.out.println(ex);
        }
        finally {
            try {
                if (fileIn != null) {
                    fileIn.close();
                }
                if (fileOut != null){
                    fileOut.close();
                }
            }
            catch (IOException e){
            }
        }

    }
}
