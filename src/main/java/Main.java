public class Main {

    public static void printObjectSize(Object object) {
        System.out.println("Object type: " + object.getClass() +
                ", size: " + InstrumentationAgent.getObjectSize(object) + " bytes");
    }

    public static void main(String[] arguments) {
        Runnable runnable = () -> System.out.println("Hello kitty");
        Thread thread = new Thread(runnable);
        Fiber fiber = Fiber.schedule(runnable);

        printObjectSize(thread);
        printObjectSize(fiber);

//        Object type: class java.lang.Thread, size: 384 bytes
//        Object type: class java.lang.Fiber, size: 80 bytes
    }
}
