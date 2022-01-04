import java.io.*;
import java.lang.*;
import java.util.Date;

public class Main {
    static StringBuilder logString = new StringBuilder();
    static Date date = new Date();
    static String dateString = date.toString();

    public static void main(String[] args) {
        File tempDir = new File("D:/Games/temp");
        makeDir(tempDir, logString);
        File tempFile = new File ("D:/Games/temp/temp.txt");
        makeFile(tempFile, logString);
        File srcDir = new File("D:/Games/src");
        makeDir(srcDir,logString);
        File resDir = new File("D:/Games/res");
        makeDir(resDir,logString);
        File saveDir = new File("D:/Games/savegames");
        makeDir(saveDir,logString);
        logWrite(tempFile, logString);
        File srcMain = new File("D:/Games/src/main");
        makeDir(srcMain, logString);
        File srcTest = new File("D:/Games/src/test");
        makeDir(srcTest, logString);
        File mainJava = new File ("D:/Games/src/main/main.java");
        makeFile(mainJava, logString);
        File utilsJava = new File ("D:/Games/src/main/utils.java");
        makeFile(utilsJava, logString);
        File resDraw = new File("D:/Games/res/drawables");
        makeDir(resDraw,logString);
        File resVect = new File("D:/Games/res/vectors");
        makeDir(resVect,logString);
        File resIcon = new File("D:/Games/res/icons");
        makeDir(resIcon,logString);
        logWrite(tempFile, logString);
    }

    private static StringBuilder makeDir(File myDir, StringBuilder log) {
        if (myDir.mkdir())
            System.out.println("Каталог " + myDir.getName() + " создан");
        logString.append(dateString + " Каталог " + myDir.getName() + " создан\n");
        return logString;
    }

    private static StringBuilder makeFile(File myFile, StringBuilder log) {
        try {
            if (myFile.createNewFile())
                System.out.println("Файл " + myFile.getName() + " создан");
            logString.append(dateString + " Файл " + myFile.getName() + " создан\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return logString;
    }

    private static void logWrite (File tempFile, StringBuilder log) {
        try (FileWriter writer = new FileWriter(tempFile, false)) {
            writer.write(String.valueOf(log));
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


}
