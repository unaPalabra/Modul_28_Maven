import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Error_reflection {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException,
            InstantiationException, NoSuchFieldException, InvocationTargetException {
        HashMap map = new HashMap(); //Создадим объект класса HashMap

        Class<?> clazz = map.getClass(); //Получим у него класс

        //Создадим новый объект класса HashMap
        HashMap instance = (HashMap) clazz.getConstructor().newInstance();

        //Получим у созданного объекта поле size
        Field field = instance.getClass().getDeclaredField("size");

        //Установим доступность поля
        field.setAccessible(true);

        //Установим полю size значение 10
        field.setInt(instance, 10);

        System.out.println("Map is empty: " + instance.isEmpty());
        System.out.println("Map size:" + instance.size());
        System.out.println("Values: " + instance.toString());
    }
}

//В данном примере мы получили класс объекта map, создали новый объект класса HashMap
// с помощью getConstructor(), newInstance(). Получили поле size с помощью метода
// getDeclaredField("size"), где в качестве аргумента передается имя поля.
// Предоставили доступ к этому полю, вызвав setAccessible(true).
// Данный метод класс Field наследует от класса AccessibleObject.
// Далее установили значение size равное 10. Вывели на экран является ли мапа пустой,
// размер и все значения в мапе.
