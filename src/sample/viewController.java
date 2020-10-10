package sample;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.awt.*;
import java.io.IOException;

//    package sample;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.ListView;
//
//import sample.Drink;
//
//import javax.swing.text.TableView;
//import java.awt.*;
//import java.io.IOException;
import static sample.Main1.*;


public class viewController {
        Parent root=null;
        @FXML
        TextArea textAreaView;
        @FXML
        ListView drinkList;
        @FXML
         ListView ingList,recipeList;
        @FXML
        ListView bookingList;
        @FXML
        ChoiceBox drinkChoiceBox,ingredientChoiceBox;
   @FXML
   javafx.scene.control.TextField ingredientTextField,recipeTextField;
        
        public void initialize(){
            Main1.addDrinkToList(drinkList);

            }

        public void loadIng(){

//if (ingredientTextField.getText().length()>0){
//    //int index = ingrednt.hashFunction2(ingredientTextField.getText().length());
//    int index=0;
//    GenericNode<Ingredient> tempNode = ingrednt.hashTable[index].head;
//
//
//
//    while (tempNode!=null){
//        if (tempNode.getContents().getName().contains(ingredientTextField.getText())){
//            ingList.getItems().add(tempNode.getContents().getName() + " "+ tempNode.getContents().getType() + " "
//                    + tempNode.getContents().getTextualDescription() + " " + tempNode.getContents().getAlcoholContent());
//
//        }
//        else {}
//        tempNode=tempNode.next;
//        index++;
//}
//}
//        else{
                ingList.getItems().clear();
                Main1.addIngredientToList(ingList);}
//        }
        public void loadRecipe(){

            recipeList.getItems().clear();
            Main1.addRecipeToList(recipeList);
        }
        public void loadTheseRecipes(){
            recipeList.getItems().clear();
           String search=recipeTextField.getText();
           GenericNode<Recipe> tempNode= recipeController.recipes.head;
           while (tempNode!=null) {
               if (tempNode.getContents().getIngredient().getName().contains(search)) {

                   recipeList.getItems().add(tempNode.getContents().toString());
               }
               else {
                   recipeList.getItems().add("");
               }
               tempNode = tempNode.next;

           }}
//
//            Drink theDrink = Main1.findDrink(drinkChoiceBox.getSelectionModel().getSelectedIndex());
//
//            ingredient tempIng= theDrink.head;
//
//            List.getItems().clear();
//            ingredientChoiceBox.getItems().clear();
//
//            while(tempIng!=null){
//
//                prefList.getItems().add(tempIng.getDate()+" - "+tempIng.getTime());
//                ingredientChoiceBox.getItems().add(tempIng.getDate()+" - "+tempIng.getTime());
//                tempIng=tempIng.next;
//            }
//        }
//
//        public void loadBooking(){
//
//
//            Drink theDrink = Main1.findDrink(drinkChoiceBox.getSelectionModel().getSelectedIndex());
//            ingredient tempIngredient= theDrink.head;
//            Booking tempBooking = tempIng.head;
//            bookingList.getItems().clear();
//            while(tempIng!=null){
//
//                bookingList.getItems().add(tempBooking.toString());
//                tempIng=tempIng.next;
//            }
//        }
        public void showIndexScreen(ActionEvent e) {


            try {

                root = FXMLLoader.load(getClass().getResource("index.fxml"));

                primaryStage.setTitle("West End Theatre");
                primaryStage.setScene(new Scene(root));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }


