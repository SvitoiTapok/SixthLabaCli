package commandValidates;

import client.Client;
import client.*;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Класс команды, позволяющей вызывать команды из переданного файла
 */
public class ValExecuteScript implements ValCommand {
    /**
     * Поле, показывающее вложенность вызовов скриптов(если его не ограничить, возможно появление бесконечной рекурсии)
     */
    private int nesting = 0;
    private Scanner[] previousScanners = new Scanner[10];


    public ValExecuteScript() {
        previousScanners[0] = new Scanner(System.in);
    }


    private String readScript(Path path) {
        try (FileReader fileReader = new FileReader(path.toFile())) {
            int st;
            String script = "";
            while ((st = fileReader.read()) != -1)
                script += (char) st;
            System.out.println("скрипт " + path + " начал выполнение");
            return script;
        } catch (IOException e) {
            System.out.println("некорректный путь к файлу");
            return null;
        } catch (SecurityException e) {
            System.out.println("пользователь не обладает достаточными правами");
            return null;
        }
    }
    //метод, сохраняющий оставшуюся часть текущего сканера
    private void saveScanner(Scanner sc){
        String savedScannerData = "";
        while (sc.hasNextLine()) {
            savedScannerData += sc.nextLine() + "\n";
            //System.out.println(savedScannerData);
        }
        previousScanners[nesting] = new Scanner(savedScannerData);
        //System.out.println(savedScannerData);
    }

    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if(p!=null) {
            if (p.length != 1) {
                System.out.println("Неправильное количество аргументов");
                return;
            }
        }else {
            System.out.println("Неправильное количество аргументов");
            return;
        }
        //теперь это аргумент - путь в Data)

        if (nesting >= 10) {
            System.out.println("Достигнута максимальная вложенность скриптов, пожалуйста, избегайте вызова скрипта в скрипте");
            //nesting++;

        } else {
            Path path = Paths.get("Data", p[0]);
            String script = readScript(path);
            if (script != null) {
                //сохранение сканера для возврата к нему после выполнение другого скрипта
                if (nesting > 0) {
                    saveScanner(sc);
                }
                nesting++;
                isFileReading = true;
                CommandReader.readCommands(new Scanner(script), isFileReading, client);
                System.out.println("скрипт выполнен");
                nesting--;
                if(nesting==0){
                    CommandReader.readCommands(previousScanners[nesting], false, client);
                }else {
                    CommandReader.readCommands(previousScanners[nesting], true, client);
                }
                                //+ текущая вложенность"+ (CommandReader.nesting-1));
            }else {
                nesting--;
            }

            //System.out.println(CommandReader.MainScanner.nextLine());
            //CommandReader.MainScanner = previousScanners[nesting];
            //if (nesting == 0) {
            //    isFileReading = false;
            //}

        }
    }

}


//execute_script FIFTH_LAB_PATH
//execute_script FIFTH_LAB_PATH2

