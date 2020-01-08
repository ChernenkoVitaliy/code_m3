package com.company.hw.m3_4.task1;

/*Спроектировать базу "Квартиры". Каждая запись в базе содержит данные о квартире(район, адрес, площадь,
кол. комнат, цена). Сделать возможность выборки квартир из списка по параметрам.(+)*/

/*CREATE TABLE `flats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `area` float NOT NULL,
  `rooms` tinyint(4) NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
)*/

import java.sql.*;

public class MainM4T1 {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/hw";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private static Connection getConnection() {
        Connection dbconnection = null;

        try {
            Class.forName(DB_DRIVER);
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }

        try {
            dbconnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return dbconnection;
    }

    private static void addFlats(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO Flats(city, address, area, rooms, price) VALUES(?, ?, ?, ?, ?)");

        try {
            for (int i = 0; i < 10; i++) {

                ps.setString(1, "Bucha");
                ps.setString(2, "Barbusa " + i);
                ps.setFloat(3, 15 * i + 1);
                ps.setInt(4, i + 1);
                ps.setDouble(5, 10000 * i + 1);

                ps.executeUpdate();

            }
        }finally {
            if (ps != null) ps.close();
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();

        if (connection == null) {
            System.out.println("Error creating connection");
            return;
        }

        try {
            try {
//                addFlats(connection);


                //Выбираем квартиры из базы с ценой больше 10000 и площадью меньше 100
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM hw.Flats WHERE price > 20000 AND area < 100");
                try {
                    ResultSet resultSet = ps.executeQuery();
                    try {
                        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

                        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                            System.out.print(resultSetMetaData.getColumnName(i) + "\t\t");
                        }
                        System.out.println();

                        while (resultSet.next()) {
                            for (int j = 1; j <= resultSetMetaData.getColumnCount(); j++) {
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
            }finally {
                connection.close();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }

    }
}
