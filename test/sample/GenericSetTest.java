package sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sample.Drink;
//import sample.GenericSet;
////import sample.GenericLinkedList;
//import sample.Ingredient;
//import sample.Recipe;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNull;
import static sample.Main1.drink;

public class GenericSetTest {
    GenericSet<Ingredient> ingredientPopulated, ingredientEmpty;

    Ingredient ingredientOne, ingredientTwo, ingredientThree,ingredientFour;

    GenericSet<Drink> drinkPopulated, drinkEmpty;
    Drink drinkOne, drinkTwo, drinkThree, drinkFour;
    Recipe recipeOne,recipeTwo, recipeThree;
   // Ingredient ingredientOne, ingredientTwo, ingredientThree;
    @Before
    public void setup(){
        ingredientOne= new Ingredient("coffee","Non-Alcoholic","Very sour",0);
        ingredientTwo= new Ingredient("apple","Non-Alcoholic","Very sweet",0);
        ingredientFour= new Ingredient("sugar", "Non-Alcoholic","needed in modest amounts", 0);

        ingredientThree= new Ingredient("vodka","Alcoholic","liquid",40);
        recipeOne = new Recipe(drinkOne,ingredientOne , "20");
        recipeTwo = new Recipe(drinkTwo,ingredientTwo,  "1");
        recipeThree = new Recipe(drinkThree,ingredientThree, "40");
        drinkOne = new Drink("Caramel Coffee", "America", "sweet and sour");
        drinkTwo = new Drink("Apple Juice", "Zim", "refreshing");
        drinkThree = new Drink("Vodka and lime", "Russia", "For Over 18");
        drinkFour= new Drink("Yang", "Brussels", "Children love");


        //Setting up a Populated drink List

        drinkPopulated= new GenericSet<>() ;
        drinkPopulated.add(drinkOne);
        drinkPopulated.add(drinkTwo);
        drinkPopulated.add(drinkThree);

//        drinkPopulated
        drinkOne.getName();
        drinkTwo.getPlaceOfOrigin();
        drinkThree.getTextualDescription();
//        drinkPopulated.getEndDate(drinkTwo);
//        drinkPopulated.getTitle(drinkThree);


        //Setting up a Populated ingredent List
        ingredientPopulated= new GenericSet<>() ;
    ingredientPopulated.add(ingredientOne);
    ingredientPopulated.add(ingredientTwo);
    ingredientPopulated.add(ingredientThree);

    ingredientEmpty= new GenericSet<>();
//
        //Setting up an Empty List
        drinkEmpty = new GenericSet<>();

        //getDrinkVerifyIndexes();
    }

    @After
    public void teardown(){
        drinkPopulated = drinkEmpty = null;
        drinkOne = drinkTwo = drinkThree = drinkFour = null;
        recipeOne = recipeTwo = recipeThree = null;

    }

    @Test
    public void addDrink() {
        //adding to populated list
        assertEquals(3 , drinkPopulated.size());
        drinkPopulated.add(drinkFour);
        assertEquals((drinkPopulated.contains(drinkFour)), true);
        assertEquals(4 , drinkPopulated.size());
        //assertEquals("Yang", drinkPopulated.head.item.getName());

        //adding to empty list
        assertEquals(0, drinkEmpty.size());
        drinkEmpty.add(drinkTwo);
        assertEquals((drinkEmpty.contains(drinkTwo)), true);
        assertEquals(drinkEmpty.contains(drinkOne), false);

        //assertEquals("Apple Juice", drinkEmpty.head.item.getName());
        assertEquals(1, drinkEmpty.size());

    }
    @Test
    public void addIng() {
        //adding to populated list
        assertEquals(3 , ingredientPopulated.size());
        ingredientPopulated.add(ingredientFour);
        assertEquals((ingredientPopulated.contains(ingredientFour)), true);
        assertEquals(4 , ingredientPopulated.size());
        //assertEquals("Yang", drinkPopulated.head.item.getName());

        //adding to empty list
        assertEquals(0, ingredientEmpty.size());
        ingredientEmpty.add(ingredientTwo);
        assertEquals((ingredientEmpty.contains(ingredientTwo)), true);
        assertEquals(ingredientEmpty.contains(ingredientOne), false);

        //assertEquals("Apple Juice", drinkEmpty.head.item.getName());
        assertEquals(1, ingredientEmpty.size());

    }

//    @Test
//    public void clear() {
//        //retrieving an existing Drink from populated list
//        assertEquals("Caramel Coffee", drinkPopulated.head.next.next.next);
//        assertThat(drinkPopulated.size(), is(instanceOf(Drink.class)));
//        assertThat(drinkPopulated.head.itemgetName(), is( "Mumford and Sons"));
//
//        //retrieving a non-existant Drink from populated list
//        assertNull(drinkPopulated.getDrink(6));
//        assertNull(drinkPopulated.getDrink(-1));
//
//        //retrieving from empty list
//        assertEquals(0, drinkEmpty.size());
//        assertNull(drinkEmpty.size());
//    }



//    @Test
//    public void remove() {
//
//    assertEquals(4,drinkPopulated.size());
//    drinkPopulated.remove(drinkOne);
//    assertEquals( 3,drinkPopulated.size());
//
//
//    }
    @Test
    public void removeDrink() {
        //removing an existing Drink from populated list
        assertEquals(3, drinkPopulated.size());
        drinkPopulated.remove(drinkOne);
        assertEquals(2, drinkPopulated.size());


        //attempting to remove from empty list
        drinkEmpty.remove(drinkTwo);
        assertEquals(0, drinkEmpty.size());

        //attempting to remove A Non existing element from empty list
        drinkEmpty.remove(drinkOne);
        assertEquals(0, drinkEmpty.size());
    }
    @Test
    public void removeIng() {
        //removing an existing Drink from populated list
        assertEquals(3, ingredientPopulated.size());
        ingredientPopulated.remove(ingredientOne);
        assertEquals(2, ingredientPopulated.size());


        //attempting to remove from empty list
        ingredientEmpty.remove(ingredientTwo);
        assertEquals(0, ingredientEmpty.size());

        //attempting to remove A Non existing element from empty list
        ingredientEmpty.remove(ingredientOne);
        assertEquals(0, ingredientEmpty.size());
    }
    @Test
   public void startofDrinkLIst(){
        //prove its adding to the front of the list
        assertEquals(3, drinkPopulated.size());
        assertEquals(drinkPopulated.getHead().item.getName(),drinkThree.getName());
        drinkPopulated.add(drinkFour);
        assertEquals(4, drinkPopulated.size());
        assertEquals(drinkPopulated.getHead().item.getName(),drinkFour.getName());

        //proving it adds to the front in an emoty list
        assertEquals(0,drinkEmpty.size());
        drinkEmpty.add(drinkFour);
        drinkEmpty.add(drinkThree);

        assertEquals(drinkEmpty.getHead().item.getName(),drinkThree.getName());
    }

    @Test
    public void startofIngLIst(){
        //prove its adding to the front of the list
        assertEquals(3, ingredientPopulated.size());
        assertEquals(ingredientPopulated.getHead().item.getName(),ingredientThree.getName());
        ingredientPopulated.add(ingredientFour);
        assertEquals(4, ingredientPopulated.size());
        assertEquals(ingredientPopulated.getHead().item.getName(),ingredientFour.getName());

        assertEquals(0,ingredientEmpty.size());
        ingredientEmpty.add(ingredientFour);
        ingredientEmpty.add(ingredientThree);

        assertEquals(ingredientEmpty.getHead().item.getName(),ingredientThree.getName());
    }


//    public void listOfDrinks() {
//        //listing an empty list
//        assertThat(drinkEmpty.contains(drinkOne ).contains("no drinks in the list"), is(true));
//
//        //listing a populated list
//        assertEquals(drinkPopulated.listDrinks().contains("kelanhi"), true);
//        assertEquals(drinkPopulated.listDrinks().contains("John hall"), true);
//        assertEquals(drinkPopulated.listDrinks().contains("Mumford and Son"), true);
//        assertEquals(drinkPopulated.listDrinks().contains("0:"), true);
//        assertEquals(drinkPopulated.listDrinks().contains("1:"), true);
//        assertEquals(drinkPopulated.listDrinks().contains("2:"), true);
//    }

}
