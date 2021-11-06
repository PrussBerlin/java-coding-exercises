package com.company;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {


        String path = FileSystems.getDefault().getPath(".").toString() + "/testjava.db";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + path);
            Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                    "(name TEXT, phone INTEGER, email TEXT)");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
