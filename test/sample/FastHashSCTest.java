//package sample;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static junit.framework.TestCase.assertEquals;
//import sample.FastHashSC;
//public class FastHashSCTest {
//    GenericSet<Ingredient> ingredientPopulated, ingredientEmpty;
//
//    Ingredient ingredientOne, ingredientTwo, ingredientThree,ingredientFour;
//    private FastHashSC<Ingredient> ingPopulated =new FastHashSC<>(20);
//    private FastHashSC<Ingredient> ingEmpty;
//
//@Before
//    public void setup(){
//    ingredientOne= new Ingredient("coffee","Non-Alcoholic","Very sour",0);
//    ingredientTwo= new Ingredient("apple","Non-Alcoholic","Very sweet",0);
//    ingredientThree= new Ingredient("vodka","Alcoholic","liquid",40);
//    ingredientFour= new Ingredient("sugar", "Non-Alcoholic","needed in modest amounts", 0);
//
//    ingredientPopulated= new GenericSet<>() ;
//    ingredientPopulated.add(ingredientOne);
//    ingredientPopulated.add(ingredientTwo);
//    ingredientPopulated.add(ingredientThree);
//
//    ingredientEmpty= new GenericSet<>();
//
//    //populaing fast hash
//    ingPopulated.add(ingredientOne,ingredientOne.getName().length());
//    ingPopulated.add(ingredientTwo,ingredientTwo.getName().length());
//    ingPopulated.add(ingredientThree,ingredientThree.getName().length());
//
//    //setting up an emoty fast hash
//    ingEmpty=new FastHashSC<>(20);
//}
//@After
//    public void teardown(){
//    ingredientPopulated=ingredientEmpty= null;
//    ingredientOne=ingredientTwo=ingredientThree=null;
//}
//
//@Test
//public void checkSize(){
//    //adding to an an already popluated hash table
//    assertEquals(20, ingPopulated.hashTable.length);
////    ingPopulated.add(ingredientFour);
////    assertEquals(4, ingPopulated.hashTable.length);
////    //adding to an empty hash table
////    assertEquals(0,ingEmpty.hashTable);
//}
//    @Test
//    public void displayHashTable() {
//
//
//    }
//
////    @Test
////    public void hashFunction1() {
////    assertEquals(0,hashFunction1(ingredientOne.getName()));
////    }
//
//    @Test
//    public void getHashTable() {
//    }
//
//    @Test
//    public void add() {
//assertEquals();
//    }
//
//    @Test
//    public void getLinkListAtElement() {
//    assertEquals(ingPopulated.,ingPopulated.getLinkListAtElement(0));
//    }
//}
