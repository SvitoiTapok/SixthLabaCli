package servCommands;

import innerClasses.Person;
import server.Product;
import server.ProductCollection;
import server.Server;

import java.util.List;

/**
 * Класс команды, выводящей все элементы коллекции, значение поля owner которых меньше заданного(сравнение производится сравнением имени владельца лексикографическим порядком)
 */

public class FilterLessThanOwner implements Command{
    /**
    * метод, создающий объект Person и выводящий в консоль все элементы коллекции, значение поля owner которых меньше созданного
    */
    @Override
    public void execute(ProductCollection productCollection, Object[] p, Server server) {
        Person owner = (Person) p[0];
        List<Product> products = productCollection.getProducts();
            server.addMessage("Все продукты, имена владельцев которых меньше в лексикографическом порядке:");
            for (Product product : products) {
                if (product.getOwner().compareTo(owner) < 0)
                    server.addMessage(product.toString());

            }
            //System.out.println(products);
        }
    }
