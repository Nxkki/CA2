package sample;

public class Ingredient {

    private String name;
    private String type;
    private String textualDescription;
    private double alcoholContent;


    public Ingredient(String name, String type, String textualDescription, double alcoholContent) {
        this.name = name;
        this.type = type;
        this.textualDescription = textualDescription;
        this.alcoholContent = alcoholContent;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTextualDescription() {
        return textualDescription;
    }

    public void setTextualDescription(String textualDescription) {
        this.textualDescription = textualDescription;
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(double alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", textualDescription='" + textualDescription + '\'' +
                ", alcoholContent=" + alcoholContent +
                '}';
    }
}
