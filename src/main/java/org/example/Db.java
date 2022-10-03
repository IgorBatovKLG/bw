package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {


    private Connection getCon(int id){
        Connection connection = null;
        try {
            return connection = DriverManager.getConnection("jdbc:sqlite:D:/db2/wb"+id+".db");
        } catch (SQLException e) {

        }
        return connection;
    }

    public void unsertDb(int id, int count, int idDb){
        try (PreparedStatement statement = getCon(idDb).prepareStatement("INSERT INTO idWb VALUES (?,?,?)")) {
            statement.setString(2, String.valueOf(id));
            statement.setInt(3, count);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void inserdProd(String id, String name, String price, int idDb){
        try (PreparedStatement statement = getCon(idDb).prepareStatement("INSERT INTO prod VALUES (?,?,?,?)")) {
            statement.setString(2, id);
            statement.setString(3, name);
            statement.setString(4, price);
            statement.executeUpdate();
        } catch (SQLException throwables) {

        }
    }

    public void updateIdWb(int id, int count, int idDb){
        try (PreparedStatement statement = getCon(idDb).prepareStatement("update idWb set countprod = (?) where idWb=(?)")) {
            statement.setInt(2, id);
            statement.setInt(1, count);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Integer> getidWb( int idDb){
        List<Integer> add = new ArrayList<>();
        try (PreparedStatement statement = getCon(idDb).prepareStatement("select idWb from idWb where countProd==100")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                add.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return add;
    }
}
