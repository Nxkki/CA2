package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static sample.Main1.primaryStage;

public class ingredientController {


    @FXML
    TextField txtFieldIngredientName;

    @FXML
    ChoiceBox cbxDrinkType;

    @FXML
    TextArea txtAreaDescription;

    @FXML
    Slider sldrAlchlCtnt;

    @FXML
    ListView lstViewIngdnt;


    public void initialize() {
//        try {
//            Main1.load();
//        } catch (Exception e) {
//            System.out.println("something is wrong");
//        }
        lstViewIngdnt.getItems().clear();
        Main1.addIngredientToList(lstViewIngdnt);
        cbxDrinkType.getItems().addAll("Alcoholic", "Non-Alcoholic");
        //sldrAlchlCtnt.setValue(5.);

    }


    public void addIngredient() {
        Ingredient tempI = new Ingredient(txtFieldIngredientName.getText(), cbxDrinkType.getSelectionModel().getSelectedItem().toString(), txtAreaDescription.getText(), sldrAlchlCtnt.getValue());
        Main1.ingredient.addElement(tempI);
        Main1.ingrednt.add(tempI, (int) sldrAlchlCtnt.getValue());
        lstViewIngdnt.getItems().clear();
        Main1.mergeSort(Main1.ingredient);
        Main1.addIngredientToList(lstViewIngdnt);

//        GenericLinkedList<Ingredient> ingredients = new GenericLinkedList<>();
        // Ingredient newIng = (new Ingredient(txtFieldIngredientName.getText(), cbxDrinkType.getSelectionModel().getSelectedItem().toString(), txtAreaDescription.getText(), sldrAlchlCtnt.getValue()));
        //Main1.ingredient.addElement(newIng);
        //Main1.ingrednt.add(newIng, newIng.getName().length());
//        Main1.ingrednt.add(newIng);
        Main1.mergeSort(Main1.ingredient);
        Main1.addIngredientToList(lstViewIngdnt);
        lstViewIngdnt.getItems().addAll("Name:" + txtFieldIngredientName.getText() + '\n' + "Drink Type:" + cbxDrinkType.getValue() + '\n' + "Textual Description" + txtAreaDescription.getText() + '\n' + "Alcohol Content:" + sldrAlchlCtnt.getValue() + '%');


        try {
            Main1.save();
        } catch (Exception e) {
            System.out.println("something is wrong");


        }
        txtFieldIngredientName.setText("");
        cbxDrinkType.setValue(null);
        txtAreaDescription.setText("");

        System.out.println("List of ingredients:");
        for (Ingredient i : Main1.ingredient)
            System.out.println(i);
//   Main1.mergeSort(Main1.ingredient);
//pretend user entered 0
        GenericLinkedList<Ingredient> tempIngredList = Main1.ingrednt.getLinkListAtElement(0);
        System.out.println(" List of ingredients at 0 element:");
        for (Ingredient i : tempIngredList)
            System.out.println(i);
        Main1.ingrednt.displayHashTable();
        Main1.mergeSort(tempIngredList);
        System.out.println(" Ordered List of ingredients at 0 element:");
        for (Ingredient i : tempIngredList)
            System.out.println(i.getName() + i.getAlcoholContent());


    }


//    public void btnBackToIndex(){
//
//
//
//}
//
}