package android.utility;

public class TestData {
    private static String itemName;
    private static int itemQuantity;


    public static String getItemName() {
        return itemName;
    }

    public static void setItemName(String itemName) {
        TestData.itemName = itemName;
    }

    public static int getItemQuantity() {
        return itemQuantity;
    }

    public static void setItemQuantity(int itemQuantity) {
        TestData.itemQuantity = itemQuantity;
    }

}
