package com.example.tvstore;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    Connection connection;

    public DBConnection(){
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost/project_javafx","root","");
            System.out.println("connection success");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    List<Television> getTelevisions(){
        ArrayList<Television>televisions=new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("SELECT * From store").executeQuery();
            while (resultSet.next()){

                int id =resultSet.getInt("id");
                String name =resultSet.getString("name");
                String brand= resultSet.getString("brand");
                int quantity =resultSet.getInt("quantity");
                String high_resolution=resultSet.getNString("high_resolution");
                String image =resultSet.getNString("image");
                String size =resultSet.getNString("size");
                Float price=resultSet.getFloat("price");
                System.out.println("============");
                System.out.println(id);
                System.out.println(name);
                System.out.println(brand);
                System.out.println(quantity);
                System.out.println(high_resolution);
                System.out.println(image);
                System.out.println(size);
                System.out.println(price);
                televisions.add(new Television(id,name,brand,quantity,high_resolution,image,size,price));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return televisions;
    }

    void updateTelevition(Television television){
        String sql="UPDATE store SET name='"+television.name+"',brand='"+television.brand+"',quantity="+television.quantity+",high_resolution='"+
                television.high_resolution+"',image='"+television.image+"',size='"+television.size+"',price="+television.price+"WHERE id="+television.id;
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void deleteteletition (int id){
        String sql ="DELETE FROM store WHERE id=" +id+"";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertTelevition(Television television) {
        String sql="INSERT INTO store(name, brand,quantity,high_resolution,image,size,price) VALUES ('"+television.name+"','"+
                television.brand+"',"+television.quantity+",'"+television.high_resolution+"','"+television.image+"','"+television.size+"',"+television.price+"))";

        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}


