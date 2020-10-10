package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main1 extends Application {
    public static Stage primaryStage;

    public static GenericLinkedList<Ingredient> ingredient =new GenericLinkedList();
    public static FastHashSC<Ingredient> ingrednt=new FastHashSC<>(20);
    public static FastHashSC<Drink> drik =new FastHashSC<>(20);
    public  static GenericSet<Drink> drink = new GenericSet<>();


//    public void see(){
//    drink.contains(Drink name);
//}
    @Override
    public void start(Stage ps) throws Exception{
        primaryStage = ps;

        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        load();
    }
    public static void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream
                (new FileWriter("drink.xml"));

        out.writeObject(drink);
        out.close();
        out = xstream.createObjectOutputStream(new FileWriter("ingredient.xml"));
  // new FileWriter("ingredient.xml");
        out.writeObject(ingredient);
        out.close();

        out = xstream.createObjectOutputStream
                (new FileWriter("recipe.xml"));

        out.writeObject(recipeController.recipes);
        out.close();
        //fastHash
        out = xstream.createObjectOutputStream(new FileWriter("drik.xml"));
        out.writeObject(drik);
        out.close();
//        ingrednt
        out = xstream.createObjectOutputStream(new FileWriter("FHIngrednt.xml"));
        out.writeObject(ingrednt);
        out.close();

    }
    public static void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream
                (new FileReader("drink.xml"));
        drink = (GenericSet<Drink>) is.readObject();

       is= xstream.createObjectInputStream (new FileReader("ingredient.xml"));
        ingredient =(GenericLinkedList<Ingredient>) is.readObject();
        is.close();
        ingredient.setNumElem();

        is= xstream.createObjectInputStream (new FileReader("recipe.xml"));
        recipeController.recipes =(GenericLinkedList<Recipe>) is.readObject();
        is.close();

        //Fasthash
        is= xstream.createObjectInputStream (new FileReader("drik.xml"));
        drik =(FastHashSC<Drink>) is.readObject();
        is.close();

        is= xstream.createObjectInputStream (new FileReader("fhIngrednt.xml"));
        ingrednt =(FastHashSC<Ingredient>) is.readObject();
        is.close();

//       addToHashSet();


    }
    public static void addToHashSet( ){
        ingrednt.clear();
        for (int i = 0;i<ingredient.size();i++ ){

            ingrednt.add(ingredient.getElement(i),(int) ingredient.getElement(i).getAlcoholContent());
        }
    }
    public static void getDrink(ChoiceBox x){
        GenericSet.GenericSetItem tempDrink = ((GenericSet.GenericSetItem)(Main1.drink.head));
        while (tempDrink != null) {

            x.getItems().add(tempDrink.item.toString());
            tempDrink = tempDrink.next;
        }}


    public static Object findDrink(int index) {
        GenericSet.GenericSetItem temp= ((GenericSet.GenericSetItem) (Main1.drink.head));
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }
    public static void getIngrediant(ChoiceBox x)
    {
//        #
        x.getItems().clear();
        GenericNode tempIngredient = Main1.ingredient.head;

        while(tempIngredient!=null){

            x.getItems().add(((Ingredient)tempIngredient.getContents()).getName());
            tempIngredient = tempIngredient.next;
        }
    }
    public static GenericNode findIngrediant(int index) {
        GenericNode temp= ((GenericNode) (Main1.ingredient.head));
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.next;
    }
    public static void addDrinkToList(ListView addDrinkListView) {
        //if(addShowListView!=null)
        addDrinkListView.getItems().clear();
        if (drink == null)
            addDrinkListView.getItems().add("");
        else {
            GenericSet.GenericSetItem tmp =(drink.getHead());
            //for (int i = 1; i < 2; i++) { //change te 5 to number of shows

            while(tmp != null){
                addDrinkListView.getItems().add((Drink)tmp.item);
                tmp = tmp.next;
            }
        }
    }
    public static void addIngredientToList(ListView addIngredientListView) {
        //if(addShowListView!=null)
        addIngredientListView.getItems().clear();
        if (drink == null)
            addIngredientListView.getItems().add("");
        else {
            GenericNode tmp =(ingredient.getHead());
            //for (int i = 1; i < 2; i++) { //change te 5 to number of shows
            while(tmp != null){
                mergeSort(ingredient);
                addIngredientListView.getItems().add((Ingredient)tmp.getContents());
                tmp = tmp.next;
            }
        }


    }
    public static void addRecipeToList(ListView addRecipeListView) {//},GenericLinkedList<Recipe>recipes) {
        //if(addShowListView!=null)
        addRecipeListView.getItems().clear();
        if (drink == null)
            addRecipeListView.getItems().add("");
        else {
            GenericNode tmp =(recipeController.recipes.getHead());
            //for (int i = 1; i < 2; i++) { //change te 5 to number of shows
            while(tmp != null){
                addRecipeListView.getItems().add((Recipe)tmp.getContents());
                tmp = tmp.next;
            }
        }


    }
    public static void addIngredientToChoice(ChoiceBox addIngredientChoiceBox) {
        //if(addShowListView!=null)
        addIngredientChoiceBox.getItems().clear();
        if (ingredient == null)
            addIngredientChoiceBox.getItems().add("");
        else {
            GenericNode tmp =(ingredient.getHead());
            //for (int i = 1; i < 2; i++) { //change te 5 to number of shows
            while(tmp != null){
                addIngredientChoiceBox.getItems().add((Ingredient)tmp.getContents());
                tmp = tmp.next;
            }
        }


    }



    public static void mergeSort(GenericLinkedList<Ingredient>ingredients) {
        if(ingredients.size()>1) {
//Create 2 sublists as evenly sized as possible
//            int x=a.length/2, y=a.length-x;
//            int[] xa=new int [x];
//            int[] ya=new int [y];

            int x=ingredients.size()/2, y=ingredients.size()-x;
            GenericLinkedList<Ingredient> xa=new GenericLinkedList<>();
            GenericLinkedList<Ingredient> ya=new GenericLinkedList<>();
//Copy elements into sub lists
//            int i;
//            for(i=0;i<x;i++) xa[i]=a[i];
//            for(int i2=0;i2<y;i2++,i++) ya[i2]=a[i];
            int i;
            for(i=0;i<x;i++) xa.addElement(ingredients.getElement(i));
            for(int i2=0;i2<y;i2++,i++) ya.addElement(ingredients.getElement(i));


//Recursively merge sort the sub lists independently
            mergeSort(xa);
            mergeSort(ya);
//Merge the 2 sorted sub lists
//            i=0;
//            int xai=0,yai=0;
//            while(xai<xa.length && yai<ya.length)
//                a[i++] = (xa[xai]<ya[yai]) ? xa[xai++] : ya[yai++];
//            while(xai<xa.length) a[i++]=xa[xai++];
//            while(yai<ya.length) a[i++]=ya[yai++];

            i=0;
            int xai=0,yai=0;
            while(xai<xa.size() && yai<ya.size()) {
                String name1 = xa.getElement(xai).getName();
                String name2 = ya.getElement(yai).getName();
                ingredients.setElement(i++ , (name1.compareTo(name2)<0 ? xa.getElement(xai++)  :ya.getElement(yai++)));

            }
            while(xai<xa.size()) ingredients.setElement(i++, xa.getElement(xai++));
            while(yai<ya.size()) ingredients.setElement(i++,ya.getElement(yai++));
        }
    }


    public static void selectionSort(GenericLinkedList<Ingredient> a){
//        for(int sp=0;sp<a.length-1;sp++){
//            int smallestIndex=sp;
//            for(int i=sp+1;i<a.length;i++)
//                if(a[i]<a[smallestIndex])
//                    smallestIndex=i;
//            if(smallestIndex!=sp) {
//                int swap=a[sp];
//                a[sp]=a[smallestIndex];
//                a[smallestIndex]=swap;
//            }
//        }

//        for(int sp=0;sp<a.size()-1;sp++){
//            int smallestIndex=sp;
//            for(int i=sp+1;i<a.size();i++)
//                if(a.getElement(i)<a.)
//                    smallestIndex=i;
//            if(smallestIndex!=sp) {
//                int swap=a[sp];
//                a[sp]=a[smallestIndex];
//                a[smallestIndex]=swap;
//            }
//        }
    }

}
