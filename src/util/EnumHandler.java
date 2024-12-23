package util;

public class EnumHandler {

    /**
     * Prints all values of the given enum type along with their descriptions.
     *
     * @param enumClass The class of the enum type.
     * @param <T>       The type of the enum.
     */
    public static <T extends Enum<T>> void printAllValues(Class<T> enumClass) {
        int index = 1;
        for (T constant : enumClass.getEnumConstants()) {
            System.out.println(index++ + ". " + constant.toString());
        }
    }

}
