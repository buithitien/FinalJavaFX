package com.example.tvstore;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DBConnection connection = new DBConnection();
        VBox root = new VBox();
        VBox televisionRoot = new VBox();

        HBox hInterpellations = new HBox();
        TextField tfName = new TextField();
        TextField tfBrand = new TextField();
        TextField tfQuantity = new TextField();
        TextField tfHigh_resolution = new TextField();
        TextField tfImage = new TextField();
        TextField tfSize = new TextField();
        TextField tfPrice = new TextField();


        Button btnAdd = new Button("Add");

        Button btnEdit = new Button("Update");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                connection.insertTelevition(new Television(tfName.getText(),tfBrand.getText(),Integer.parseInt(tfQuantity.getText()),
                        tfHigh_resolution.getText(),tfImage.getText(),tfSize.getText(), Float.parseFloat(tfPrice.getText())));
                getThenDisplayTelevition(televisionRoot, connection);
            }
            private void getThenDisplayTelevition(VBox root, DBConnection connection) {
            }
        });

//        btnEdit.setOnAction(event -> {
//            connection.updateTelevition(new Television(tfName.getText(),tfBrand.getText(),tfQuantity.getText(),
//                    tfHigh_resolution.getText(),tfImage.getText(),tfSize.getText(), Float.parseFloat(tfPrice.getText(),Integer.parseInt(tfName.getId())));
//            getThenDisplayStudents(animalsRoot, connection);
//        });


        List<Television>televisions=connection.getTelevisions();

        dispTelevitions(connection,televisionRoot,televisions);

        hInterpellations.getChildren().addAll(tfName,tfBrand,tfQuantity,tfHigh_resolution,tfImage,tfSize,tfPrice,btnAdd);
        root.getChildren().addAll(hInterpellations,televisionRoot);
        getThenDisplayTelevitions(televisionRoot, connection);
        Scene scene = new Scene(root, 360, 240);
        stage.setTitle("TV STORE -- Út Tiến");
        stage.setScene(scene);
        stage.show();
    }
    void dispTelevitions(DBConnection connection, VBox root, List<Television> televisions) {
        root.getChildren().clear();
        for (int i = 0; i < televisions.size(); i++) {
            final int finialI = i;
            HBox televitionBox = new HBox();
            Label lbId = new Label("" + televisions.get(i).id);
            Label lbName = new Label(televisions.get(i).name);
            Label lbBrand = new Label("" + televisions.get(i).brand);
            Label lbQuatity = new Label("" + televisions.get(i).quantity);
            Label lbHigh_resolution = new Label("" + televisions.get(i).high_resolution);
            Label lbImage = new Label("" + televisions.get(i).image);
            Label lbSize = new Label("" + televisions.get(i).size);
            Label lbPrice = new Label("" + televisions.get(i).price);
            Button btnDelete = new Button("Delete");
            Button btnUpdate=new Button("Update");

            btnDelete.setOnAction(actionEvent -> {
                System.out.println("Click delete " + televisions.get(finialI).id);
                connection.deleteteletition(Integer.parseInt(String.valueOf(televisions.get(finialI).id)));
                getThenDisplayTelevitions(root, connection);
            });
            btnUpdate.setOnAction(actionEvent -> {
                System.out.println("Click update " + televisions.get(finialI).id);
                connection.updateTelevition(televisions.get(finialI));
                getThenDisplayTelevitions(root, connection);
            });

            televitionBox.setSpacing(20);
            televitionBox.getChildren().addAll(lbId, lbName, lbBrand,lbQuatity,lbHigh_resolution,lbImage,lbSize,lbPrice, btnDelete, btnUpdate);
            root.getChildren().add(televitionBox);
        }
    }


    void getThenDisplayTelevitions(VBox root, DBConnection connection) {
        List<Television>televisions=connection.getTelevisions();
//        dispTelevitions(televisions);
    }

    public static void main(String[] args) {
        launch();
    }
}
