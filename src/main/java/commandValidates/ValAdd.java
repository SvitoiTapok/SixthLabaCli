package commandValidates;

import client.Client;
import client.ProductCli;
import servCommands.Add;

import java.util.Scanner;

/**
 * Класс, команды добавляющий новый элемент в коллекцию
 */
public class ValAdd implements ValCommand {
    /**
     * метод, создающий объект с помощью метода класса Product и записывающий его в коллекцию
     */
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        ProductCli[] productCliList = new ProductCli[1];
        productCliList[0] = ProductCli.createProduct(sc, isFileReading);
        if (productCliList[0] != null) {
            client.sendCommand(new Add(), productCliList);
            client.catchResult();
        }
    }
}
