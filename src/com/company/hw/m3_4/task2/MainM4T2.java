package com.company.hw.m3_4.task2;

/*Создать проект "База данных заказов". Создать таблицы "Товары", "Клиенты" и "Заказы".
* Написать код для добавления новых клиентов, товаров и оформления заказов.(+)*/

/*Таблицы:
* CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`));
  *
  * CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `order_date` date NOT NULL,
  PRIMARY KEY (`id`));
  *
  * CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `price` double NOT NULL,
  `brand` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`));*/

import java.sql.*;

public class MainM4T2 {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/hw";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";


    public static void main(String[] args) {
        Connection connection = getConnection();

        if (connection == null) {
            System.out.println("Error creating connection");
            return;
        }

        //добавляем клиентов в базу
        addClint(connection, "Vasia", "Pupkin", "(063) 123 45 68");
        addClint(connection, "John", "Smith", "(041) 777 88 68");
        addClint(connection, "Peter", "Griffin", "(029) 555 33 11");


        //добавляем товар в базу
        addProduct(connection, "IphoneX", 15000, "Iphone", "phone");
        addProduct(connection, "Xiaomi Note10 Prime", 5000, "Xiaomi", "phone");
        addProduct(connection, "Asus X750", 25000, "Asus", "laptop");


        //создаем заказ
        createOrder(connection, 3, 1, new Date(System.currentTimeMillis()));
        createOrder(connection, 3, 3, new Date(System.currentTimeMillis()));


        //выводим на консоль заказ клиента с id 3
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM hw.Products WHERE id IN (SELECT id FROM hw.Orders WHERE client_id = 3)");
            try {
                ResultSet resultSet = ps.executeQuery();
                try {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        System.out.print(metaData.getColumnName(i) + "\t\t");
                    }
                    System.out.println();

                    while (resultSet.next()) {
                        for (int j = 1; j <= metaData.getColumnCount(); j++) {
                            System.out.print(resultSet.getString(j) + "\t\t");
                        }
                        System.out.println();
                    }

                }finally {
                    resultSet.close();
                }
            }finally {
                if (ps != null) ps.close();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return dbConnection;
    }

    //метод для добавления клиентов в базу
    private static void addClint(Connection connection, String name, String surname, String phone) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO hw.Clients(name, surname, phone) VALUES(?, ? ,?)");
            try {
                ps.setString(1, name);
                ps.setString(2, surname);
                ps.setString(3, phone);

                ps.executeUpdate();
                System.out.println("Client added in DB.");
            } finally {
                if (ps != null) ps.close();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private static void addProduct(Connection connection, String name, double price, String brand, String category) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO hw.Products(name, price, brand, category) VALUES(?, ?, ?, ? )");
            try {
                ps.setString(1, name);
                ps.setDouble(2, price);
                ps.setString(3, brand);
                ps.setString(4, category);

                ps.executeUpdate();
                System.out.println("Product added in DB.");
            }finally {
                if (ps != null) ps.close();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private static void createOrder(Connection connection, int clientId, int productId, Date orderDate) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO hw.Orders(client_id, product_id, order_date) VALUES(?, ?, ?)");
            try {
                ps.setInt(1, clientId);
                ps.setInt(2, productId);
                ps.setDate(3, orderDate);

                ps.executeUpdate();
                System.out.println("Order created.");
            }finally {
                if (ps != null) ps.close();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
