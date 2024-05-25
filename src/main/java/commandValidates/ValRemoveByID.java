package commandValidates;


import client.Client;
import servCommands.RemoveByID;

import java.util.Scanner;

/**
 * Класс команды, удаляющей из коллекции элемент по id
 */

public class ValRemoveByID implements ValCommand {
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
            System.out.println("пожалуйста, введите валентный id элемента(он должен быть натуральным числом)");
            return;
        }
        Long[] id = {Long.parseLong(p[0])};
        client.sendCommand(new RemoveByID(), id);
        client.catchResult();
    }

    ///**
    // * метод, удаляляющий элемент из коллекции по заданному id(если элемента нет, то команда не делает ничего
    // *
    // * @param sc
    // * @param productCollection
    // * @param p                 передается id(он должен быть типа long). при передаче более чем одного параметра команда выведет предупреждение
    // * @param isFileReading
    // */

   // @Override
   // public void executeWithParameters(Scanner sc, ProductCollection productCollection, String[] p, boolean isFileReading) {
   //
   //
   //
   //     productCollection.removeProduct(id);
   //     System.out.println("объект с id=" + id + "(если такой был) удален");
   // }
}
