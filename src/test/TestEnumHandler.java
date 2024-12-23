package test;

import model.Category;
import util.EnumHandler;

import static util.EnumHandler.printAllValues;

public class TestEnumHandler {
    public static void main(String[] args) {

        printAllValues(Category.class);
    }
}

