package util;

public class MenuUtil {

    public static <T extends Enum<T>> void showMenu(Class<T> enumType) {
        int index = 1;
        for (T option : enumType.getEnumConstants()) {
            System.out.println(index++ + ". " + option.toString());
        }
    }
}
