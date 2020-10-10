package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class recipeController  {
    @FXML
    Label lblDrinkRecipe;
    @FXML
    ChoiceBox cbxRecipeDrink;

    @FXML
    ChoiceBox cbxRecipeIngredient;

    @FXML
    TextField txtFieldRecipeQuantity;

    @FXML
    ListView lstViewRecipe;
    public  static GenericLinkedList<Recipe>recipes= new GenericLinkedList<>();

    public void initialize(){
        //Main1.addDrinkToChoice(cbxRecipeDrink);
        lblDrinkRecipe.setText(drinkController.chosenDrink.getName());
        // cbxRecipeIngredient.getItems().addAll(ingredientController.chosenIngredient.getName());
        Main1.addIngredientToChoice(cbxRecipeIngredient);
//        Main1.getIngrediant(cbxRecipeIngredient);
    }


    public void btnRecipeAdd(){

        recipes.addElement(new Recipe(drinkController.chosenDrink,(Ingredient)cbxRecipeIngredient.getSelectionModel().getSelectedItem(),txtFieldRecipeQuantity.getText()));

        lstViewRecipe.getItems().clear();

        Main1.addRecipeToList(lstViewRecipe);

        cbxRecipeIngredient.setValue(null);
        txtFieldRecipeQuantity.setText("");

        System.out.println("List of recipes:");
        for(Recipe i : recipes)
            System.out.println(i);

        try {
            Main1.save();
        } catch (Exception e) {
            System.out.println("something is wrong");



        }}



    public void btnSubmitRecipe(){

///find the drink obj that matches the name
        //ad the recipe to that object
        //Drink.recipes.addElement(new Recipe(txtFieldRecipeName.getText(),txtFieldRecipeQuantity.getText()));
    }

    public void btnBackMain(){
        Stage primaryStage = new Stage();
        try {


            Parent root = FXMLLoader.load(getClass().getResource("drink.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }
//    public void btnBackMain(){
//        Stage primaryStage = new Stage();
//        try {
//
//
//            Parent root = FXMLLoader.load(getClass().getResource("drink.fxml"));
//            primaryStage.setTitle("Hello World");
//            primaryStage.setScene(new Scene(root, 600, 500));
//            primaryStage.show();
//        } catch (Exception e) {
//            System.out.println("something is wrong");
//        }
//    }



}
//package sample;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//import static sample.Main1.primaryStage;
//
//public class recipeController  {
//    Parent root = null;
//    @FXML
//    Label lblDrinkRecipe;
//    @FXML
//    ChoiceBox drinkNameChoiceBox, ingrediantChoiceBox;
//    @FXML
//    Slider ingrediantSlider;
//    @FXML
//    TextField txtFieldRecipeQuantity;
//
//    @FXML
//    ListView lstViewRecipe;
//
//    public  static GenericLinkedList<Recipe>recipes= new GenericLinkedList<>();
//
//    public void initialize(){
//       // lblDrinkRecipe.setText(drinkController.chosenDrink.getName());
//       // Main1.getDrink(drinkNameChoiceBox);
//        Main1.getIngrediant(ingrediantChoiceBox);
//
//    }
//
//
//
//    public void showIndexScreen(ActionEvent e) {
//        try {
//
//            Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
//
//            primaryStage.setTitle("index");
//            primaryStage.setScene(new Scene(root));
////            primaryStage.show();
//        }
//
//        catch (IOException e1) {
//            e1.printStackTrace();
//        }}
//            public void btnSubmitRecipe(){
//        lstViewRecipe.getItems().addAll();
//
//      //  Drink.recipes.addElement(new Recipe(txtFieldRecipeName.getText(),txtFieldRecipeQuantity.getText()));
//    }
//
//
//    public void btnBackMain(){
//        Stage primaryStage = new Stage();
//        try {
//
//
//            Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
//            primaryStage.setTitle("Hello World");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
//        } catch (Exception e) {
//            System.out.println("something is wrong");
//        }
//    }
//
//    public void AddRecipe(){
//
//        recipes.addElement(new Recipe((Ingredient)ingrediantChoiceBox.getSelectionModel().getSelectedItem(),txtFieldRecipeQuantity.getText()));
//        try {
//            Main1.save();
//        } catch (Exception e) {
//            System.out.println("something is wrong");
//
//
//            lstViewRecipe.getItems().clear();
//
//        Main1.addRecipeToList(lstViewRecipe);
//
//        ingrediantChoiceBox.setValue(null);
//        txtFieldRecipeQuantity.setText("");
//
//        System.out.println("List of recipes:");
//        for(Recipe i : recipes)
//            System.out.println(i);
//
//
//
//    }
//
//
//}}
