package commandValidates;

import client.Client;
import client.ProductCli;
import servCommands.Update;

import java.util.Scanner;

/**
 * Класс команды, обновляющий элемент по заданному id
 */

public class ValUpdate implements ValCommand {
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
        try{
            if(Long.parseLong(p[0]) <= 0)
                throw new Exception();
        }catch (Exception e){
            System.out.println("Пожалуйста, введите валентный id элемента(он должен быть натуральным числом)");
            return;
        }
        Long id = Long.parseLong(p[0]);
        ProductCli product = ProductCli.createProduct(sc, isFileReading);
        Object[] par = {id, product};
        client.sendCommand(new Update(), par);
        client.catchResult();
    }

    ///**
    // * метод, создающий элемент с заданным id, обновляющий его если он существует и добавляющий, если такого id не было
    // *
    // * @param sc
    // * @param productCollection
    // * @param p                 id обновляемого элемента(передается одно значение - long id, на все остальное будет выведена ошибка)
    // * @param isFileReading
    // */
//
    //@Override
    //public void executeWithParameters(Scanner sc, ProductCollection productCollection, String[] p, boolean isFileReading) {
    //
    //
    //
    //    if(!productCollection.getID().contains(id))
    //        System.out.println("элемента с введенным id не существует, пожалуйста, введите существующий id");
    //    else {
    //        Product updatedProduct = Product.createProduct(sc, productCollection, isFileReading);
    //        if(updatedProduct!= null) {
    //            updatedProduct.setId(id);
    //            //в ProductCollection прописан адд продукт, который заменяет существующий
    //            productCollection.addProduct(updatedProduct);
    //        }
    //    }
//
//
    //}
}
