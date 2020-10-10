
package sample;

public class Recipe {

    private Drink drink;
    private Ingredient ingredient;
    private String quantity;


    public Recipe(Drink drink,Ingredient ingredient, String quantity) {
        this.drink= drink;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Recipe{" + drink +":" +
                "ingredient=" + ingredient +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
//package sample;
//
//public class Recipe {
//    private Ingredient ingredient;
//    private String quantity;
//
//
//    public Recipe(Ingredient ingredient, String quantity) {
//        this.ingredient = ingredient;
//        this.quantity = quantity;
//    }
//
//
//    public Ingredient getIngredient() {
//        return ingredient;
//    }
//
//    public void setIngredient(Ingredient ingredient) {
//        this.ingredient = ingredient;
//    }
//
//    public String getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(String quantity) {
//        this.quantity = quantity;
//    }
//
//    @Override
//    public String toString() {
//        return "Recipe{" +
//                "ingredient=" + ingredient +
//                ", quantity='" + quantity + '\'' +
//                '}';
//    }
//}
