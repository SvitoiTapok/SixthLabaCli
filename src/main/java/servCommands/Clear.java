package servCommands;

import server.ProductCollection;
import server.Server;

/**
 * Класс, команды очищающей коллекцию
 */

public class Clear implements Command{
    @Override
    public void execute(ProductCollection productCollection, Object[] p, Server server) {
        productCollection.clearCollection();
        server.addMessage("Коллекция очищена");
    }
}
