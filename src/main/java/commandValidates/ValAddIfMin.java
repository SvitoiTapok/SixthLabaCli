package commandValidates;

import client.Client;
import client.*;
import servCommands.AddIfMin;

import java.util.Scanner;

/**
 * Класс, команды добавляющий новый элемент в коллекцию, если его значение меньше минимального в коллекции
 */
public class ValAddIfMin implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        ProductCli[] productCliList = new ProductCli[1];
        productCliList[0] = ProductCli.createProduct(sc, isFileReading);
        if(productCliList[0]!=null){
            client.sendCommand(new AddIfMin(), productCliList);
            client.catchResult();
        }else{
            System.out.println("Продукт не был добавлен");
        }
    }



}
