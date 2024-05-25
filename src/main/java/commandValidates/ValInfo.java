package commandValidates;

import client.*;
import servCommands.Info;
import innerClasses.Month;

import java.util.Scanner;

/**
 * Класс команды, выводящей в консоль краткую информацию о коллекции(дата создания, количество и тип элементов)
 */

public class ValInfo implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        client.sendCommand(new Info(), null);
        client.catchResult();
    }

    /**
     * метод, выводящей в консоль краткую информацию о коллекции(дата создания, количество и тип элементов)
     */

    //@Override
    //public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading){
    //    String[] data = productCollection.getDate().toString().split(" ");
//
    //    System.out.println("Коллекция состоит из элементов типа Product, она была создана " +
    //            data[2] + " " + Month.getMounthTranslation(data[1]) + " " + data[5] + " года в " + data[3] +
    //            ". На данный момент она содержит " + productCollection.getLen() + " различных элементов");
    //}
}
