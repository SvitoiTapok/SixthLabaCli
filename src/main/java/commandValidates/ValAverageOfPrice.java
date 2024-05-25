package commandValidates;

import client.Client;
import servCommands.AverageOfPrice;

import java.util.Scanner;

/**
 * Класс, команды возвращающей среднее значение цены у всех элементов коллекции
 */

public class ValAverageOfPrice implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        client.sendCommand(new AverageOfPrice(), null);
        client.catchResult();
    }

    /**
     * метод, выводящий в консоль среднее значение цены у всех элементов коллекции
     */

    //@Override
    //public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
    //    if(productCollection.getLen()==0)
    //        System.out.println("В коллекции нет ни одного продукта, пожалуйста, добавьте их");
    //    else {
    //        System.out.print("Cреднее значение цены по всем продуктам: ");
    //        System.out.println(Math.round(productCollection.getProducts().stream()
    //                .map(Product::getPrice).reduce(Float::sum).get() /
    //                productCollection.getLen() * 100000) / 100000);
    //    }
    //}
}
