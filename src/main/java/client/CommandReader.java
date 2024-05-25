package client;

import commandValidates.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CommandReader {
    //private final HashMap<String, Command> commands = new HashMap<>();
    //private Scanner MainScanner = new Scanner(System.in);
    private boolean isFileReading = false;
    private final static HashMap<String, ValCommand> commands = new HashMap<>();
    //для подпрограмм
    //public static Scanner[] previousScanners = new Scanner[10];
    //static {
    //    previousScanners[0] = new Scanner(System.in);
    //}
    static {
        commands.put("help", new ValHelp());
        commands.put("info", new ValInfo());
        commands.put("show", new ValShow());
        commands.put("add", new ValAdd());
        commands.put("update", new ValUpdate());
        commands.put("remove_by_id", new ValRemoveByID());
        commands.put("clear", new ValClear());
        commands.put("execute_script", new ValExecuteScript());
        commands.put("exit", new ValExit());
        commands.put("add_if_min", new ValAddIfMin());
        commands.put("remove_greater", new ValRemoveGreater());
        commands.put("remove_lower", new ValRemoveLower());
        commands.put("average_of_price", new ValAverageOfPrice());
        commands.put("filter_starts_with_name", new ValFilterStartsWithName());
        commands.put("filter_less_than_owner", new ValFilterLessThanOwner());
        commands.put("write", new ValWrite());
    }
    public static void readCommands(Scanner mainScanner, boolean isFileReading, Client client){
        //MainScanner = sc;
        while (mainScanner.hasNextLine()){
            //String input = sc.nextLine();
            String[] splitedInput = mainScanner.nextLine().split(" ");
            //если команда есть в списке вызываем ее без параметров или с параметрами в зависимости от инпута
            if (commands.containsKey(splitedInput[0])){
                if(splitedInput.length==1) {
                    commands.get(splitedInput[0]).validate(mainScanner, null, isFileReading, client);
                    //client.catchResult();
                }else {
                    commands.get(splitedInput[0]).validate(mainScanner, Arrays.copyOfRange(splitedInput, 1, splitedInput.length), isFileReading, client);
                    //client.catchResult();
                }
            }else {
                System.out.println("команды " + splitedInput[0] + " не было найдено. Пожалуйста, введите help для получения доступного списка команд");
            }
        }
        //if(isFileReading){
        //    MainScanner = previousScanners[nesting-1];

            //System.out.println(MainScanner.nextLine() +"cr");
        }
    }
