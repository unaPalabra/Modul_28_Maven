import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class CallOfMethod {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, InvocationTargetException {
        HashMap map = new HashMap(); //Создаем объект класса HashMap

        //Получаем объект класса Class у созданного объекта
        Class clazz = map.getClass();

        //У класса объекта получим метод put
        Method putMethod = clazz.getDeclaredMethod("put", Object.class, Object.class);
        //Вызовем метод put. В качестве ключа укажем значение “key” и в качестве
        //значения - “value”
        putMethod.invoke(map, "key", "value");

        System.out.println("Values: " + map.toString());
    }
}
