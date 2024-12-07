package Domain;

public class Meal {
    
    private int mealID;
    private String mealName;
    private String category;
    private String ingredients;
    
    // For New Meals
    public Meal(String mealname, String category, String ingredients) {

        this.mealName = mealname;
        this.category = category;
        this.ingredients = ingredients;
    }

    // For Existing Meals
    public Meal(int mealID, String mealname, String category, String ingredients) {

        this.mealID = mealID;
        this.mealName = mealname;
        this.category = category;
        this.ingredients = ingredients;
    }

    public int getMealID() {
        return mealID;
    }

    public String getMealName() {
        return mealName;
    }

    public String getCategory() {
        return category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public void setName(String mealname) {
        this.mealName = mealname;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Meal{" + "mealID=" + mealID + ", mealname=" + mealName + ", category=" + category + ", ingredients=" + ingredients + '}';
    }
}
