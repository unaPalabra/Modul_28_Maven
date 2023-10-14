package Task_28_3_4;

@Author("Tom Stap")

public class Main {
    public static void main(String[] args) {
        Main map = new Main();

        Class<?> clazz = map.getClass();
        Author annotation = clazz.getAnnotation(Author.class);

        System.out.println("Author: " + annotation.value());
    }
}
