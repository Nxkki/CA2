package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static sample.Main1.*;
import static sample.Main1.ingrednt;

public class deleteController {

    @FXML
    TextArea txtAreaTextualDescription;

  @FXML
    TextField updateDrink,txtFieldDrinkName,txtFieldPlaceOfOrigin,txtFieldIngName;


public void deleteDrink(){

    Main1.drink.head=null;
}
public void deleteAParticularDrink(){
    int index = drik.hashFunction2(txtFieldDrinkName.getText().length());
    GenericNode<Drink> tempNode = drik.hashTable[index].head;

    while(tempNode !=null) {

        if (tempNode.getContents().getName().equalsIgnoreCase(txtFieldDrinkName.getText())) {
            drink.remove(tempNode.getContents());
            tempNode.getContents().setName(null);
      tempNode.getContents().setPlaceOfOrigin(null);
      tempNode.getContents().setTextualDescription(null);

        }
        tempNode = tempNode.next;
    }



    }

public void deleteIng(){
    ingredient.head=null;
}
public void deleteAParticularIng(){
    int index = ingrednt.hashFunction2(txtFieldIngName.getText().length());
    GenericNode<Ingredient> tempNode = ingrednt.hashTable[index].head;
    while(tempNode !=null){

        if (tempNode.getContents().getName().equalsIgnoreCase(txtFieldIngName.getText())){
//           in
              tempNode.getContents().setName(null);
            tempNode.getContents().setType(null);
            tempNode.getContents().setTextualDescription(null);
            tempNode.getContents().setAlcoholContent(0.0);

        }
        tempNode=tempNode.next;

}}
public void updateDrink(){
    //get the name the updtae it with
    int index = drik.hashFunction2(updateDrink.getText().length());
    GenericNode<Drink> tempNode = drik.hashTable[index].head;
    while(tempNode !=null){

        if (tempNode.getContents().getName().equalsIgnoreCase(updateDrink.getText())){


            tempNode.getContents().setName(null);

            tempNode.getContents().setPlaceOfOrigin(null);
            tempNode.getContents().setTextualDescription(null);

            //this way or delete entry by making it empty and create another drink and add it somewhere else
//            tempNode.getContents().setName(txtFieldDrinkName.getText());
//            tempNode.getContents().setPlaceOfOrigin(txtFieldPlaceOfOrigin.getText());
//            tempNode.getContents().setTextualDescription(txtAreaTextualDescription.getText());
            Drink newDrink = new Drink(txtFieldDrinkName.getText(),txtFieldPlaceOfOrigin.getText(),txtAreaTextualDescription.getText());
            Main1.drink.add(newDrink);
            Main1.drik.add(newDrink, newDrink.getName().length());
            try {
                Main1.save();
            } catch (Exception e) {

            }



}}}


    public void btnBackToIndex(){
        try {


            Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }


}

