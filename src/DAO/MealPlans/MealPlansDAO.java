package DAO.MealPlans;

import java.util.List;

import Domain.MealPlan;

public interface MealPlansDAO {
    
    int createMealPlan(MealPlan mealPlan) throws Exception;
    MealPlan readMealPlanById(int mealPlanID) throws Exception;
    List<MealPlan> readAllMealPlans() throws Exception;
    void updateMealPlan(MealPlan mealPlan) throws Exception;
    void deleteMealPlan(int mealPlanID) throws Exception;
}
