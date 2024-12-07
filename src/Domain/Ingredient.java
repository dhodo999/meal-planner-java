package Domain;

public class Ingredient {
    
    private int ingredientID;
    private String ingredientname;
    private String description;
    private int quantity;
    
    // For New Ingredients
    public Ingredient(String ingredientname, String description, int quantity) {

        this.ingredientname = ingredientname;
        this.description = description;
        this.quantity = quantity;
    }

    // For Existing Ingredients
    public Ingredient(int ingredientID, String ingredientname, String description, int quantity) {

        this.ingredientID = ingredientID;
        this.ingredientname = ingredientname;
        this.description = description;
        this.quantity = quantity;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public String getName() {
        return ingredientname;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public void setName(String ingredientname) {
        this.ingredientname = ingredientname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredient [ingredientID=" + ingredientID + ", ingredientname=" + ingredientname + ", description="
                + description + ", quantity=" + quantity + "]";
    }
}
