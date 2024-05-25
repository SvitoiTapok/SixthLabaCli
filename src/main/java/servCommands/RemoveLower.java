package servCommands;

import client.ProductCli;
import server.Product;
import server.ProductCollection;
import server.Server;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Класс команды, удаляющей из коллекции все элементы меньше заданного(сортировка выполняется в лексикографическом порядке по именам продуктов)
 */

public class RemoveLower implements Command{
    public void execute(ProductCollection productCollection, Object[] p, Server server) {
        ProductCli productCli = (ProductCli) p[0];
        Product product = new Product(productCli, productCollection);
        List<Product> prods = productCollection.getProducts();
        LinkedHashSet<Product> removedProds = new LinkedHashSet<>();
        for(Product prod: prods){
            if(prod.compareTo(product)<0)
                removedProds.add(prod);
        }
        productCollection.removeProducts(removedProds);
        server.addMessage("Продукты удалены");
    }
}
