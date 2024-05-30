import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(name + " - $" + price);
    }
}

class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        } else {
            System.out.println("Invalid item index");
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.println("Your Shopping Cart:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName());
        }
        System.out.println("Total: $" + getTotalPrice());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        Product[] products = {
            new Product("Product 1", 10.99),
            new Product("Product 2", 5.99),
            new Product("Product 3", 7.49)
        };

        System.out.println("Available Products:");
        for (Product product : products) {
            product.display();
        }

        while (true) {
            System.out.print("Enter product number to add to cart (0 to finish): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= products.length) {
                cart.addItem(products[choice - 1]);
            } else {
                System.out.println("Invalid product number");
            }
        }

        cart.display();

        scanner.close();
    }
}
