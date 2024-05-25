package client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        System.out.println("Попытка подключения к серверу");
        Scanner sc = new Scanner(System.in);
        while (!client.createConnection()){}
        CommandReader.readCommands(sc, false, client);
    }

}
