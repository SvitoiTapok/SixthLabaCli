package commandValidates;

import client.Client;
import servCommands.Help;

import java.util.Scanner;

/**
 * Класс команды, выводящей все доступные команды
 */

public class ValHelp implements ValCommand {
    @Override
    public void validate(Scanner sc, String[] p, boolean isFileReading, Client client) {
        if (p!= null){
            System.out.println("Команда не принимает аргументов");
            return;
        }
        client.sendCommand(new Help(), null);
        client.catchResult();
    }

    /**
     * метод, вывоящий в консоль все доступные команды с описанием
     */

    //@Override
    //public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading){
    //    System.out.println("Вот все доступные команды с описанием:");
    //    System.out.println("help : вывести справку по доступным командам\n" +
    //            "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
    //            "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
    //            "add {element} : добавить новый элемент в коллекцию\n" +
    //            "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
    //            "remove_by_id id : удалить элемент из коллекции по его id\n" +
    //            "clear : очистить коллекцию\n" +
    //            "save : сохранить коллекцию в файл\n" +
    //            "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
    //            "exit : завершить программу (без сохранения в файл)\n" +
    //            "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
    //            "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
    //            "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
    //            "average_of_price : вывести среднее значение поля price для всех элементов коллекции\n" +
    //            "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки\n" +
    //            "filter_less_than_owner owner : вывести элементы, значение поля owner которых меньше заданного");
    //}
}
