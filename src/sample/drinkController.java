package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.Main1.primaryStage;

public class drinkController {

    @FXML
    TextField txtFieldDrinkName;

    @FXML
    TextField txtFieldPlaceOfOrigin;

    @FXML
    TextArea txtAreaTextualDescription;

    @FXML
    ListView lstViewDrink;


    public static Drink chosenDrink;
    public void initialize(){

        try {
            Main1.load();
        } catch (Exception e) {

            System.out.println("something is wrong");
        }
        lstViewDrink.getItems().clear();
        Main1.addDrinkToList(lstViewDrink);
        chosenDrink = (Drink)lstViewDrink.getSelectionModel().getSelectedItem();

    }
    public void addDrink(){
    lstViewDrink.getItems().addAll("Name:"+txtFieldDrinkName.getText()+'\n'+"Place Of Origin:"+txtFieldPlaceOfOrigin.getText()+'\n'
    +"Textual Description:"+ txtAreaTextualDescription.getText());

    Drink newDrink = new Drink(txtFieldDrinkName.getText(),txtFieldPlaceOfOrigin.getText(),txtAreaTextualDescription.getText());
   Main1.drink.add(newDrink);

//   adding iteam to hash table
       // Main1.,drik.hashFunction();
       // Main1.drik.hashFunction1(txtFieldDrinkName.getText());
Main1.drik.add(newDrink, newDrink.getName().length());
    txtFieldDrinkName.setText("");
    txtFieldPlaceOfOrigin.setText("");
    txtAreaTextualDescription.setText("");
        try {
            Main1.save();
        } catch (Exception e) {

        }

    }
//public void search(){
//        txtFieldDrinkName.getText()=
//}
    public void btnBackToIndexScreen(){

        try {


            Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }

    public void btnAddRecipe (){

        if(lstViewDrink.getSelectionModel().getSelectedIndex()>=0){

            try {
                chosenDrink=(Drink) lstViewDrink.getSelectionModel().getSelectedItem();

                Parent root = FXMLLoader.load(getClass().getResource("recipe.fxml"));
                primaryStage.setTitle("Add Recipe");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (Exception e) {
                System.out.println("something is wrong");
            }
//            Stage primaryStage = new Stage();
//            try {
//
//                chosenDrink=(Drink) lstViewDrink.getSelectionModel().getSelectedItem();
//
//                Parent root = FXMLLoader.load(getClass().getResource("recipe.fxml"));
//                primaryStage.setTitle("Hello World");
//                primaryStage.setScene(new Scene(root));
//                primaryStage.show();
//            } catch (Exception e) {
//                System.out.println("something is wrong");
//            }
        }


//        try {
//
//
//            Parent root = FXMLLoader.load(getClass().getResource("recipe.fxml"));
//            primaryStage.setTitle("Hello World");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
//        } catch (Exception e) {
//            System.out.println("something is wrong");
//        }

}}
