package Domain;

public class MealPlan {

    private int planID;
    private int userID;
    private String userName;
    private String day;
    private String mealTime;
    private int mealID;
    private String mealName;

    // For New MealPlans
    public MealPlan(int userID, String userName, String day, String mealTime, int mealID, String mealName) {

        this.userID = userID;
        this.userName = userName;
        this.day = day;
        this.mealTime = mealTime;
        this.mealID = mealID;
        this.mealName = mealName;
    }

    // For Existing MealPlans
    public MealPlan(int planID, int userID, String userName, String day, String mealTime, int mealID, String mealName) {
        
        this.planID = planID;
        this.userID = userID;
        this.userName = userName;
        this.day = day;
        this.mealTime = mealTime;
        this.mealID = mealID;
        this.mealName = mealName;
    }

    // Getters and setters for each field
    public int getPlanID() {
        return planID;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getDay() {
        return day;
    }

    public String getMealTime() {
        return mealTime;
    }

    public int getMealID() {
        return mealID;
    }

    public String getMealName() {
        return mealName;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "planID=" + planID +
                ", userID=" + userID +
                ", userName='" + userName + '\'' +
                ", day='" + day + '\'' +
                ", mealTime='" + mealTime + '\'' +
                ", mealID=" + mealID +
                ", mealName='" + mealName + '\'' +
                '}';
    }
}