package commandValidates;

import client.Client;
import client.ProductCli;
import servCommands.RemoveLower;

import java.util.Scanner;

/**
 * Класс команды, удаляющей из коллекции все элементы меньше заданного(сортировка выполняется в лексикографическом порядке по именам продуктов)
 */

public class ValRemoveLower implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        ProductCli[] product = {ProductCli.createProduct(sc, isFileReading)};
        if(product[0]!=null) {
            client.sendCommand(new RemoveLower(), product);
            client.catchResult();
        }
    }

    ///**
    // * метод, создающий элемент и удаляющий из коллекции все элементы меньше заданного
    // */
    //
    //@Override
    //public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
    //
    //    if(product!=null) {
    //        //ProductCollection.PRODUCT_COLLECTION.addProduct(product);
    //        LinkedHashSet<Product> prods = productCollection.getProducts();
    //        LinkedHashSet<Product> removedProds = new LinkedHashSet<>();
    //        for(Product prod: prods){
    //            if(prod.compareTo(product)<0)
    //                removedProds.add(prod);
    //        }
    //        productCollection.removeProducts(removedProds);
    //    }
    //}
}
