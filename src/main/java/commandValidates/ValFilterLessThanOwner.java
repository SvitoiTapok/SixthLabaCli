package commandValidates;

import client.Client;
import client.ProductCli;
import servCommands.FilterLessThanOwner;
import innerClasses.Person;

import java.util.Scanner;

/**
 * Класс команды, выводящей все элементы коллекции, значение поля owner которых меньше заданного(сравнение производится сравнением имени владельца лексикографическим порядком)
 */

public class ValFilterLessThanOwner implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        Person[] owner = new Person[1];
        owner[0] = Person.createPerson(sc, isFileReading);
        if(owner[0]!=null) {
            client.sendCommand(new FilterLessThanOwner(), owner);
            client.catchResult();
        }
    }

    /**
     * метод, создающий объект Person и выводящий в консоль все элементы коллекции, значение поля owner которых меньше созданного
     */

    //@Override
    //public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
    //    Person owner = Person.createPerson(sc, isFileReading);
    //    if(owner!=null) {
    //        LinkedHashSet<Product> products = productCollection.getProducts();
    //        System.out.println("Все продукты, имена владельцев которых меньше в лексикографическом порядке:");
    //        for (Product product : products) {
    //            if (product.getOwner().compareTo(owner) < 0)
    //                System.out.println(product);
//
    //        }
    //        //System.out.println(products);
    //    }
    //}

}
