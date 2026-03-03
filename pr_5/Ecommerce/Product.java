package Ecommerce;
public class Product {
    private String productName;
    private double price;
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public String getProductName() {
        return productName;
    }
    public void displayProduct() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }
}