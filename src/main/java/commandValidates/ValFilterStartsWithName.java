package commandValidates;

import client.Client;
import servCommands.FilterStartsWithName;

import java.util.Scanner;

/**
 * Класс команды, выводящей все элементы коллекции, значение поля name которых начинается с заданной строки
 */

public class ValFilterStartsWithName implements ValCommand {
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
        client.sendCommand(new FilterStartsWithName(), p);
        client.catchResult();
    }

    /**
     * метод, вывоящий в консоль все элементы коллекции, значение поля name которых начинается с заданной строки
     *
     * @param sc
     * @param productCollection
     * @param p                 строка, с которой должно начинаться имя продукта(len(p)=1 иначе в консоль будет выведена ошибка)
     * @param isFileReading
     */

    //public void executeWithParameters(Scanner sc, ProductCollection productCollection, String[] p, boolean isFileReading) {
    //
    //
    //    Set<Product> products = productCollection.getProducts().stream().filter(x -> x.getName().startsWith(StrBegin)).collect(Collectors.toSet());
    //    for(Product product: products){
    //        System.out.println(product);
    //    }
    //}
}
