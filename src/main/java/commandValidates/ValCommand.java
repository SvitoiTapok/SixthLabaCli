package commandValidates;

import client.Client;

import java.util.Scanner;

/**
 * Интерфейс всех для команд
 */

public interface ValCommand {
    void validate(Scanner sc, String[] p, boolean isFileReading, Client client);
}
