package commandValidates;

import client.*;
import servCommands.RemoveGreater;

import java.util.Scanner;

/**
 * Класс команды, удаляющей из коллекции все элементы большие заданного(сортировка выполняется в лексикографическом порядке по именам продуктов)
 */

public class ValRemoveGreater implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        ProductCli[] product = {ProductCli.createProduct(sc, isFileReading)};
        if(product[0]!=null) {
            client.sendCommand(new RemoveGreater(), product);
            client.catchResult();
        }
    }
}
