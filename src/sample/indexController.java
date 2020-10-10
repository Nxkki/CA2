package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;

import static sample.Main1.primaryStage;

public class indexController {
    Parent root = null;



    public void showDrinksScreen(){

        try {


            Parent root = FXMLLoader.load(getClass().getResource("drink.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }


    public void showIngedientsScreen(){

        try {


            Parent root = FXMLLoader.load(getClass().getResource("ingredient.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }

    public void showUpdateScreen(){

        try {


            Parent root = FXMLLoader.load(getClass().getResource("update.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }
//    public void showViewScreen(){
//        try {
//
//            Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
//            primaryStage.setTitle("Add Recipe");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
//        } catch (Exception e) {
//            System.out.println("something is wrong");
//        }
//    }
    public void showSearchScreen(){
        try {

            Parent root = FXMLLoader.load(getClass().getResource("search.fxml"));
            primaryStage.setTitle("Search");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }
    public void showViewScreen(){
        try {

            Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
            primaryStage.setTitle("Search");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }
    public void showDeleteScreen(){

        try {


            Parent root = FXMLLoader.load(getClass().getResource("delete.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }


//    public void btnSearchIngredients(){
//         // Main1.ingrednts.add(new Ingredients(ingredientsController.cbxDrink.getValue().toString(),ingredientsController.cbxDrinkType.getValue().toString(),
//          //        ingredientsController.txtAreaIngredients.getText(),ingredientsController.sldrAlchlCtnt.getValue()),ingredientsController.c);
//         // );
    }

