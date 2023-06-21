package task1706;

public class OurPresident {
    static {
        synchronized (OurPresident.class){
           president = new OurPresident();
        }
    }
    private static OurPresident president;

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
