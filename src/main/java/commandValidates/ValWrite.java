package commandValidates;

import client.Client;
import servCommands.Write;

import java.util.Scanner;

public class ValWrite implements ValCommand {
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
        client.sendCommand(new Write(), p);
        client.catchResult();

    }

    //@Override
    //public void executeWithParameters(Scanner sc, ProductCollection productCollection, String[] p, boolean isFileReading) {
    //    System.out.println(p[0]);
    //}
}
