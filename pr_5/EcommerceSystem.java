import Ecommerce.Product;
import Ecommerce.Customer;
import Ecommerce.Order;
public class EcommerceSystem {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 50000);
        Customer customer1 = new Customer("Tanvi Kodoli", 146);
        Order order1 = new Order(product1, customer1, 2);
        System.out.println("---- Ecommerce System ----");
        order1.placeOrder();
        System.out.println();
        order1.displayOrder();
    }
}