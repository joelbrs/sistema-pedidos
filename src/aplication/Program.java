package aplication;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Coloque as Informações do Cliente:");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de Nascimento (DD/MM/YYY): ");
        Date birthDate = sdf.parse(sc.next());
        System.out.println();

        Client client = new Client(name, email, birthDate);

        System.out.println("Coloque as informações do pedido:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        System.out.print("Quantos itens para esse pedido? ");
        Integer n = sc.nextInt();
        System.out.println();

        Order order = new Order(new Date(), status, client);

        for (int i = 1; i <= n; i++){
            System.out.println("Coloque as informações do item #" + i);
            System.out.print("Nome do Produto: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Preço do Produto: ");
            Double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantidade: ");
            Integer quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);

        sc.close();

    }

}
