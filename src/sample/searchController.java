package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import static sample.Main1.*;

public class searchController {


    @FXML
    TextField searchTextField, ingTextField, keyTextField;
    @FXML
    ListView searchListview;
    @FXML
    ChoiceBox alcoChoiceBox;

    public void searchForKeyWord(){
        searchListview.getItems().clear();
        int index = drik.hashFunction2(keyTextField.getText().length());
        GenericNode<Drink> tempNode = drik.hashTable[index].head;
        int ingIndex = ingrednt.hashFunction2(keyTextField.getText().length());
        GenericNode<Ingredient> ingTempNode = ingrednt.hashTable[ingIndex].head;
        while(tempNode !=null && ingTempNode !=null){

            if (ingTempNode.getContents().getName().equalsIgnoreCase(keyTextField.getText())|| tempNode.getContents().getName().equalsIgnoreCase(keyTextField .getText())|| tempNode.getContents().getTextualDescription().equalsIgnoreCase(searchTextField .getText())|| tempNode.getContents().getPlaceOfOrigin().equalsIgnoreCase(searchTextField .getText())){
                searchListview.getItems().add("Name:"+tempNode.getContents().getName()+'\n'+"Place Of Origin:"+tempNode.getContents().getPlaceOfOrigin()+'\n'
                        +"Textual Description:"+ tempNode.getContents().getTextualDescription()
                        +'\n'+
                        ingTempNode.getContents().getName().equalsIgnoreCase(keyTextField.getText()));
            }
            else {}
            tempNode=tempNode.next;
            ingTempNode=ingTempNode.next;

    }
//        int ingIndex = ingrednt.hashFunction2(keyTextField.getText().length());
//        GenericNode<Ingredient> ingTempNode = ingrednt.hashTable[ingIndex].head;

//        while (ingTempNode !=null){
//            if (ingTempNode.getContents().getName().equalsIgnoreCase(keyTextField.getText())){
//                searchListview.getItems().add(
//            }
//            else {}
//            ingTempNode=ingTempNode.next;



        }


   public void searchDrink(){
        searchListview.getItems().clear();

 int index = drik.hashFunction2(searchTextField.getText().length());
    GenericNode<Drink> tempNode = drik.hashTable[index].head;

       while(tempNode !=null){

           if (tempNode.getContents().getName().equalsIgnoreCase(searchTextField .getText())){
          searchListview.getItems().add("Name:"+tempNode.getContents().getName()+'\n'+"Place Of Origin:"+tempNode.getContents().getPlaceOfOrigin()+'\n'
                       +"Textual Description:"+ tempNode.getContents().getTextualDescription());

           }
           // do a else if for .dot contains but is not the same try a differnet spelling this
           else {
//               searchListview.getItems().add("Nothing found");
           }
        tempNode=tempNode.next;
    }
    }

public void searchACDrink(){
    searchListview.getItems().clear();

    if (alcoChoiceBox.getSelectionModel().getSelectedItem().equals("Alcoholic")) {

        int index = 0;
        GenericNode<Ingredient> tempNode = ingrednt.hashTable[index].head;

        while (tempNode != null) {

            if (tempNode.getContents().getAlcoholContent() >0) {

                searchListview.getItems().add(tempNode.getContents().getName() + '\n' + tempNode.getContents().getAlcoholContent()
                        + '\n' + tempNode.getContents().getTextualDescription());
                      try {
                          Main1.load();
                      } catch (Exception e) {
                          System.out.println("something is wrong");
                      }
            } else {
            }
            tempNode = tempNode.next;
            index++;



    }}


   else{



                int index = 0;
                GenericNode<Ingredient> tempNode = ingrednt.hashTable[index].head;
                while (tempNode != null) {

                    if (tempNode.getContents().getAlcoholContent() == 0) {

                        searchListview.getItems().add(tempNode.getContents().getName() + tempNode.getContents().getAlcoholContent() + tempNode.getContents().getTextualDescription());
                    } else {
                    }
                        tempNode = tempNode.next;
                        index++;

                }




    }
}


public void searchIng(){

       // cant access the loaded list
    searchListview.getItems().clear();
//    String ing=  ingTextField.getText();
    int index = ingrednt.hashFunction2(ingTextField.getText().length());
    GenericNode<Ingredient> tempNode = ingrednt.hashTable[index].head;



    while (tempNode!=null){
        if (tempNode.getContents().getName().equalsIgnoreCase(ingTextField.getText())){
            searchListview.getItems().add(tempNode.getContents().getName() + " "+ tempNode.getContents().getType() + " "
            + tempNode.getContents().getTextualDescription() + " " + tempNode.getContents().getAlcoholContent());

        }
        else {}
        tempNode=tempNode.next;
}
   }
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
