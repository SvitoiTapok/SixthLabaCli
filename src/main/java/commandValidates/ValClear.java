package commandValidates;

import client.Client;
import servCommands.Clear;

import java.util.Scanner;

/**
 * Класс, команды очищающей коллекцию
 */

public class ValClear implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        client.sendCommand(new Clear(), null);
        client.catchResult();
    }

    /**
     * метод, очищающий коллекцию
     */

    //@Override
    //public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
    //    productCollection.clearCollection();
    //    System.out.println("Коллекция очищена");
    //}
}
