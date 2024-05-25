package client;

import servCommands.Command;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Client {
    private final int port = 45000;
    //private final int port = 1110;
    //private InetAddress inetAddress;
    private Socket sock;
    private OutputStream os;
    private InputStream is = null;


    public boolean createConnection(){
       //try {
       //    inetAddress = InetAddress.getLocalHost();
       //}catch (UnknownHostException e) {
       //    System.out.println("Некорректный адрес хоста");
       //}
        try {
            sock = new Socket("localhost", port);
            //sock = new Socket(inetAddress, port);
            is = sock.getInputStream();
            System.out.println("Соединение установленно");
            return true;
        } catch (IOException e) {
            System.out.println("Не удалось установить соединение");
            return false;
            //System.out.println("Не удалось подключится к серверу, повторая попытка через 2 секунды");
            //try {
                //    Thread.sleep(2000);
                //} catch (InterruptedException ex) {
                //    System.out.println("Возникла ошибка с потоком выполнения");
                //}
        }
    }

    private byte[] serialize(Command command, Object[] p) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(command);
        objectOutputStream.flush();
        //objectOutputStream.writeObject("ahahahahha");
        //objectOutputStream.flush();
        if (p != null) {
            for (Object x : p) {
                objectOutputStream.writeObject(x);
                //System.out.println(x);
                objectOutputStream.flush();
            }
        }
        //objectOutputStream.writeObject(null);
        //objectOutputStream.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        //for(byte x: bytes)System.out.print(x);
        return bytes;

    }

    public void sendCommand(Command command, Object[] p){
        try {
            os = sock.getOutputStream();
        }catch (IOException e){
            System.out.println("Соединение было прервано, повторная попытка подключения");
            createConnection();
        }
        try {
            byte[] b = serialize(command, p);
            os.write(b);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Возникли проблемы с сериализацией объектов");

        }

    }

    private String deserialize(byte[] data) throws Exception{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        String result = (String) objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }


    public void catchResult(){
        try {
            byte[] data = new byte[64000];
            int size = is.read(data);
            //for(byte i: Arrays.copyOfRange(data,0, size))System.out.print((char) i);
            String result = deserialize(Arrays.copyOfRange(data,0, size));
            //костыль для update, пока не знаю, как сделать лучше
            System.out.println(result);
        } catch (Exception e){
            System.out.println("Соединение было прервано, повторная попытка подключения");
            createConnection();
        }
    }
}
