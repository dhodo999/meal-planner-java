package Domain;

public class MealIngredient {
    
    private int mealIngredientID;
    private int mealID;
    private String mealName;
    private int ingredientID;
    private String ingredientName;

    // For New MealIngredients
    public MealIngredient(int mealID, String mealName, int ingredientID, String ingredientName) {

        this.mealID = mealID;
        this.mealName = mealName;
        this.ingredientID = ingredientID;
        this.ingredientName = ingredientName;
    }

    // For Existing MealIngredients
    public MealIngredient(int mealIngredientID, int mealID, String mealName, int ingredientID, String ingredientName) {

        this.mealIngredientID = mealIngredientID;
        this.mealID = mealID;
        this.mealName = mealName;
        this.ingredientID = ingredientID;
        this.ingredientName = ingredientName;
    }

    public int getMealIngredientID() {
        return mealIngredientID;
    }

    public int getMealID() {
        return mealID;
    }

    public String getMealName() {
        return mealName;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setMealIngredientID(int mealIngredientID) {
        this.mealIngredientID = mealIngredientID;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "MealIngredient{" +
                "mealIngredientID=" + mealIngredientID +
                ", mealID=" + mealID +
                ", mealName='" + mealName + '\'' +
                ", ingredientID=" + ingredientID +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
