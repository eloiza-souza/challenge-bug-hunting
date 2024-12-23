package test;

import model.Category;
import util.EnumHandler;

import static model.Category.SERIE;
import static model.Category.isValidCategory;

public class TestCategory {
    public static void main(String[] args) {

        Category category = SERIE;
        System.out.println(category.toString());
        System.out.println(isValidCategory("série"));
        EnumHandler.printAllValues(category.getDeclaringClass());
    }
}
