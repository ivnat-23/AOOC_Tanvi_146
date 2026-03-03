package Ecommerce;
public class Customer {
    private String customerName;
    private int customerId;
    public Customer(String customerName, int customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }
    public void displayCustomer() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerId);
    }
}