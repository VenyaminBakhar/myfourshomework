package task2;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Вениамин on 7/17/2017.
 */
public class SymbolStream {
    private static FileReader fr;
    private static FileWriter fw;
    private static BufferedReader br = null;
    private static BufferedWriter bw = null;
    private static Integer countOfWords = 0;
    private static String fileOut = "C:\\Users\\Вениамин\\Desktop\\myfourshomework\\src\\main\\resources\\inFile2.txt";
    private static String fileIn = "C:\\Users\\Вениамин\\Desktop\\myfourshomework\\src\\main\\resources\\outFile2.txt";
    private static List<String> keyWords = Arrays.asList("abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue", "default", "double", "do", "else",
            "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof",
            "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short",
            "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
            "volatile", "while");
    private static StringBuilder key = new StringBuilder();

    public static void main(String[] args) {
        try {
            fr = new FileReader(fileIn);
            fw = new FileWriter(fileOut);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            String s;
            while ((s = br.readLine()) != null) {
                key.append(s);
            }
            String str = key.toString();
            for (String keyWord : keyWords) {
                if (str.contains(keyWord)) {
                    bw.write(keyWord);
//                    bw.write("\n");
                    countOfWords++;
                }
            }
            bw.write(countOfWords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null){
                    br.close();
                }
                    bw.close();
            } catch (IOException e){
            }
        }

    }
}
