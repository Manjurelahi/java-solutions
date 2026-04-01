/*
JDK8+ Code Test
Create an e-Commerce application based on below data and tasks.
Product - ProductId, ProductName, Category, Price
Order - OrderId, CustomerId, ProductId, Quantity, TotalAmount
Customer - CustomerId, CustomerName
1. Find expensive product per category
2. Find average order placed per product
3. Find total order count and total amount spent by each customer
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Customer {
    private String customerId;
    private String customerName;

    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}

class Product {
    private String productId;
    private String productName;
    private String category;
    private double price;

    public Product(String productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> productQuantityMap;

    public Order(String orderId, Customer customer, Map<Product, Integer> productQuantityMap) {
        this.orderId = orderId;
        this.customer = customer;
        this.productQuantityMap = productQuantityMap;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getProductQuantityMap() {
        return productQuantityMap;
    }

    public double getTotalAmount() {
        return getProductQuantityMap().entrySet().stream()
                .mapToDouble(productQuantityEntry -> productQuantityEntry.getKey().getPrice() * productQuantityEntry.getValue()).sum();
    }
}

public class ECommerce {

    public static Map<Product, Integer> addToCart(List<Product> products, Integer quantity, Map<Product, Integer> productQuantityMap) {
        for (Product product : products) {
            productQuantityMap.put(product, quantity);
        }
        return productQuantityMap;
    }

    public static List<Product> getExpensiveProductPerCategory(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.groupingBy(product -> product.getCategory()))
                .values().stream().reduce(new ArrayList<>(), (expensiveProductList, categoryProductList) -> {
                    expensiveProductList.add(categoryProductList.get(0));
                    return expensiveProductList;
                });
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("MOBILE1", "Mobile Phone", "Telecom", 15000),
                new Product("MOUSE1", "Mouse Device", "Computer Accessories", 600),
                new Product("EAR1", "Ear Headphone", "Computer Accessories", 550),
                new Product("KB1", "Keyboard Device", "Computer Accessories", 800),
                new Product("MONITOR1", "Monitor Device", "Computer Accessories", 5000),
                new Product("CPU1", "CPU Computer System", "Electronics", 25000),
                new Product("LAPTOP1", "Laptop Computer System", "Electronics", 50000),
                new Product("USB1", "USB Hub Device", "Computer Accessories", 500),
                new Product("ELE1", "Electric Extension Box", "Electrical", 750),
                new Product("FAN1", "Ceiling Fan", "Electrical", 1800)
        );

        List<Customer> customers = List.of(
                new Customer("SHOP1", "IT E-Commerce Shop"),
                new Customer("COMPANY1", "IT PVT LTD"),
                new Customer("HOTEL1", "IT Hotel"),
                new Customer("HOSPITAL1", "IT Hospital"),
                new Customer("USER1", "Manjur")
        );

        List<Order> orderList = new ArrayList<>();

        orderList.add(new Order("Order1",
                customers.stream().filter(customer -> customer.getCustomerId().equals("SHOP1")).findFirst().get(),
                addToCart(products, 100, new HashMap<Product, Integer>())));
        orderList.add(new Order("Order2",
                customers.stream().filter(customer -> customer.getCustomerId().equals("COMPANY1")).findFirst().get(),
                addToCart(products, 75, new HashMap<Product, Integer>())));

        orderList.add(new Order("Order3",
                customers.stream().filter(customer -> customer.getCustomerId().equals("HOTEL1")).findFirst().get(),
                addToCart(products.stream().filter(product ->
                                        !product.getProductId().equals("EAR1") && !product.getProductId().equals("LAPTOP1")
                                                && !product.getProductId().equals("USB1") && !product.getProductId().equals("ELE1"))
                                .collect(Collectors.toList())
                        , 50, new HashMap<Product, Integer>())));

        Map<Product, Integer> hospitalProductQuantityMap = addToCart(products.stream().filter(
                product -> product.getProductId().equals("MOUSE1")
                        || product.getProductId().equals("KB1")
                        || product.getProductId().equals("CPU1")
        ).collect(Collectors.toList()), 5, new HashMap<Product, Integer>());
        hospitalProductQuantityMap.put(products.stream().filter(product ->
                product.getProductId().equals("MONITOR1")).findFirst().get(), 30);
        orderList.add(new Order("Order4",
                customers.stream().filter(customer -> customer.getCustomerId().equals("HOSPITAL1")).findFirst().get(),
                hospitalProductQuantityMap));

        orderList.add(new Order("Order5",
                customers.stream().filter(customer -> customer.getCustomerId().equals("USER1")).findFirst().get(),
                addToCart(products.stream().filter(product -> !product.getProductId().equals("CPU1"))
                                .collect(Collectors.toList())
                        , 1, new HashMap<Product, Integer>())));

        orderList.add(new Order("Order6",
                customers.stream().filter(customer -> customer.getCustomerId().equals("COMPANY1")).findFirst().get(),
                addToCart(products, 25, new HashMap<Product, Integer>())));

        System.out.println("<==== 1. Expensive product details per category ====>");
        getExpensiveProductPerCategory(products).forEach(System.out::println);

        System.out.println("\n<==== 2. Average order placed per product ====>");
        final int totalOrderProductQuantities = orderList.stream()
                .mapToInt(order -> order.getProductQuantityMap().values().stream().mapToInt(quantity -> quantity).sum())
                .sum();
        Map<Product, Integer> productTotalOrderPlacedMap = new HashMap<>();
        orderList.stream().collect(Collectors.groupingBy(order -> order.getProductQuantityMap()))
                .keySet().stream().forEach(productQuantityMap -> {
                    productQuantityMap.forEach((product, quantity) -> {
                        productTotalOrderPlacedMap.put(product,
                                productTotalOrderPlacedMap.getOrDefault(product, 0) + quantity);
                    });
                });
        productTotalOrderPlacedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(productQuantityEntry -> {
                    System.out.println("\nProduct: " + productQuantityEntry.getKey().getProductName());
                    System.out.print("Quantity: " + productQuantityEntry.getValue() + "\t");
                    System.out.println("Average Order Placed: " + String.format("%.0f",
                            (Double.valueOf(productQuantityEntry.getValue()) / Double.valueOf(totalOrderProductQuantities)) * 100) + "%");
                });

        System.out.println("\n<==== 3. Total order count and total amount spent by each customer ====>");
        orderList.stream().collect(Collectors.groupingBy(order -> order.getCustomer())).forEach((customer, orders) -> {
            System.out.println("\n" + customer);
            System.out.println("Total Order Count: " + orders.size());
            System.out.println("Total Amount Spent: Rs. " + String.format("%.2f",orders.stream().mapToDouble(Order::getTotalAmount).sum()));
        });
    }
}

/*
Output:

<==== 1. Expensive product details per category ====>
Product{productId='MOBILE1', productName='Mobile Phone', category='Telecom', price=15000.0}
Product{productId='MONITOR1', productName='Monitor Device', category='Computer Accessories', price=5000.0}
Product{productId='LAPTOP1', productName='Laptop Computer System', category='Electronics', price=50000.0}
Product{productId='FAN1', productName='Ceiling Fan', category='Electrical', price=1800.0}

<==== 2. Average order placed per product ====>

Product: Monitor Device
Quantity: 281   Average Order Placed: 12%

Product: Keyboard Device
Quantity: 256   Average Order Placed: 11%

Product: Mouse Device
Quantity: 256   Average Order Placed: 11%

Product: CPU Computer System
Quantity: 255   Average Order Placed: 11%

Product: Ceiling Fan
Quantity: 251   Average Order Placed: 11%

Product: Mobile Phone
Quantity: 251   Average Order Placed: 11%

Product: Ear Headphone
Quantity: 201   Average Order Placed: 9%

Product: Laptop Computer System
Quantity: 201   Average Order Placed: 9%

Product: USB Hub Device
Quantity: 201   Average Order Placed: 9%

Product: Electric Extension Box
Quantity: 201   Average Order Placed: 9%

<==== 3. Total order count and total amount spent by each customer ====>

Customer{customerId='USER1', customerName='Manjur'}
Total Order Count: 1
Total Amount Spent: Rs. 75000.00

Customer{customerId='HOSPITAL1', customerName='IT Hospital'}
Total Order Count: 1
Total Amount Spent: Rs. 282000.00

Customer{customerId='SHOP1', customerName='IT E-Commerce Shop'}
Total Order Count: 1
Total Amount Spent: Rs. 10000000.00

Customer{customerId='COMPANY1', customerName='IT PVT LTD'}
Total Order Count: 2
Total Amount Spent: Rs. 10000000.00

Customer{customerId='HOTEL1', customerName='IT Hotel'}
Total Order Count: 1
Total Amount Spent: Rs. 2410000.00
*/