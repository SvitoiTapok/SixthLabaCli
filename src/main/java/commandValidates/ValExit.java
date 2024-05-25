package commandValidates;

import client.Client;

import java.util.Scanner;

/**
 * Класс команды, заканчивающий выполнение программы
 */

public class ValExit implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        System.out.println("Работа клиента была завершена");
        System.exit(0);
    }

    /**
     * метод, заканчивающий выполнение программы
     */
    //@Override
    //public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        //System.out.println("Программа была завершена");
        //System.exit(0);
    //}
}
