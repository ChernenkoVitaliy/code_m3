package com.company.examples.m4.sample1_jdbc;

import java.sql.*;

public class MainM4S1 {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS Test (" +
            "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            "comment VARCHAR(100) NOT NULL)";

    private static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return dbConnection;
    }

    public static void main(String[] args) {
        Connection connection = getDBConnection();
        if (connection == null) {
            System.out.println("Error creating connection!");
            return;
        }

        try {
            try {
                //#1
                Statement st = connection.createStatement();
                try {
                    st.execute(CREATE_TABLE_SQL);
                }finally {
                    if (st != null) st.close();
                }


                //#2
                st = connection.createStatement();
                try {
                    st.executeUpdate("INSERT INTO Clients (phone) VALUES ('06312345678')"); //for INSERT, UPDATE & DELETE
                }finally {
                    if (st != null) st.close();
                }


                //#3
                long groupId = -1;

                st = connection.createStatement();
                try{
                    ResultSet rs = st.executeQuery("SELECT id FROM mydb.Groups WHERE name='Group-1'");
                    if (rs.next()) {
                        groupId = rs.getLong(1);
                    }else {
                        System.out.println("Group not found!");
                        return;
                    }
                }finally {
                    if (st != null) st.close();
                }


                //#4
                PreparedStatement ps = connection.prepareStatement("INSERT INTO Clients (name, phone, group_id) VALUES(?, ?, ?)");
                try{
                    ps.setString(1, "Ivan");
                    ps.setString(2, "0677777777");
                    ps.setLong(3, groupId);

                    ps.executeUpdate();
                }finally {
                    if (ps != null) ps.close();
                }


                //#4a
                connection.setAutoCommit(false);
                try {
                    ps = connection.prepareStatement("INSERT INTO Clients (name, phone, group_id) VALUES(?, ?, ?)");
                    try {
                        for (int i = 0; i < 10; i++) {
                            ps.setString(1, "John");
                            ps.setString(2, "1234567" + i);
                            ps.setLong(3, groupId);

                            ps.executeUpdate();
                        }

                        connection.commit();
                    }finally {
                        if (ps != null) ps.close();
                    }
                }catch (Exception ex) {
                    connection.rollback();
                }
                connection.setAutoCommit(true);


                //#5
                ps = connection.prepareStatement("SELECT * FROM Clients");
                try {
                    ResultSet rs = ps.executeQuery();
                    try {
                        ResultSetMetaData md = rs.getMetaData();

                        for (int i = 1; i <= md.getColumnCount(); i++)
                            System.out.print(md.getColumnName(i) + "\t\t");
                        System.out.println();

                        while (rs.next()) {
                            for (int i = 1; i < md.getColumnCount(); i ++)
                                System.out.print(rs.getString(i) + "\t\t");
                            System.out.println();
                        }
                    }finally {
                        rs.close();
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
