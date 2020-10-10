package sample;

public class Drink extends recipeController {
    private String name;
    private String placeOfOrigin;
    private String textualDescription;
    public static GenericLinkedList<Recipe>recipes= new GenericLinkedList<>();


    public Drink(String name, String placeOfOrigin, String textualDescription) {
        this.name = name;
        this.placeOfOrigin = placeOfOrigin;
        this.textualDescription = textualDescription;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getTextualDescription() {
        return textualDescription;
    }

    public void setTextualDescription(String textualDescription) {
        this.textualDescription = textualDescription;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", placeOfOrigin='" + placeOfOrigin + '\'' +
                ", textualDescription='" + textualDescription + '\'' +
                ", recipes=" + recipes ;
    }
}
