package commandValidates;

import client.Client;
import servCommands.Show;

import java.util.Scanner;

/**
 * Класс команды, выводящий элементы коллекции в консоль
 * */

public class ValShow implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        client.sendCommand(new Show(), null);
        client.catchResult();
    }

    /**
     * метод, Выводящий все элементы коллекции в консоль(вызывает to string у ProductCollection)
     */
    //@Override
    //public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading){
    //    if(productCollection.getProducts().isEmpty()){
    //        System.out.println("На данный момент в коллекции нет элементов");
    //        return;
    //    }
    //    for(Product product: productCollection.getProducts()){
    //        System.out.println(product);
    //    }
    //    System.out.println();
    //}
}
