import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchFieldException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {


        //Имена классов
        Object str = "574527282";
        Class<?> claz = str.getClass();
        System.out.println(claz.getSimpleName());
        System.out.println(claz.getName());


        //Модификаторы класса
        //Рассмотрим модификаторы классов HashMap, AbstractMap и Map с помощью рефлексии:
        //
        //Получим объекты класса Class для каждого класса, используя метод Class.forName().
        //Получим модификаторы каждого класса, вызвав метод getModifiers().
        //Проверим, является ли класс HashMap публичным и абстрактным, используя методы Modifier.isPublic()
        // и Modifier.isAbstract() соответственно.
        //Также проверим, является ли AbstractMap абстрактным классом, а Map  — интерфейсом.

        // Получаем класс для java.util.HashMap
        Class hashMap = Class.forName("java.util.HashMap");

        // Получаем класс для java.util.AbstractMap
        Class abstractMap = Class.forName("java.util.AbstractMap");

        // Получаем класс для java.util.Map
        Class map = Class.forName("java.util.Map");


        //Получаем модификаторы для HashMap
        int hashMapModifiers = hashMap.getModifiers();

        //Получаем модификаторы для AbstractMap
        int abstractMapModifiers = abstractMap.getModifiers();

        //Получаем модификаторы для Map
        int mapModifiers = map.getModifiers();

        //Выводим, имеет ли HashMap public модификатор
        System.out.println("HashMap class is public :" + Modifier.isPublic(hashMapModifiers));

        //Выводим, имеет ли AbstractMap abstract модификатор
        System.out.println("AbstractMap class is abstract :" + Modifier.isAbstract(abstractMapModifiers));

        //Выводим, имеет ли Map interface модификатор
        System.out.println("Map is interface :" + Modifier.isInterface(mapModifiers));

        //Выводим, имеет ли HashMap abstract модификатор
        System.out.println("HashMap class is abstract :" + Modifier.isAbstract(hashMapModifiers));


        //Информация о пакете
        Object obj = 5;
        Class clazz1 = obj.getClass();
        Package classPackage = clazz1.getPackage();

        System.out.println(classPackage.getName());


        //Информация о родительском классе
        String str1 = "example";
        Class superClass = str1.getClass().getSuperclass();

        System.out.println(superClass.getSimpleName()); //по умолчанию любой класс является наследником класса Object.


        //Информация об интерфейсах
        //Выведем на экран все интерфейсы класса HashMap
        Object map1 = new HashMap<>();
        Class[] interfaces = map1.getClass().getInterfaces();

        Arrays.stream(interfaces).forEach(System.out::println);


        //Конструкторы, методы и поля
        //Рассмотрим какие есть конструкторы у класса HashMap.
        // Создадим объект класса HashMap, получим у него класс и вызовем метод getConstructors().
        Object map2 = new HashMap<>();
        Constructor[] constructors = map2.getClass().getConstructors();

        Arrays.stream(constructors).forEach(System.out::println);

        //Все поля класса можем получить с помощью метода getDeclaredFields():
        Field[] fields = map2.getClass().getDeclaredFields();

        Arrays.stream(fields).forEach(System.out::println);


        //Создание объекта
        //Чтобы создать новый объект класса, нужно получить конструктор класса
        // и вызвать у него метод newInstance().
        Class<?> mapClass = Class.forName("java.util.HashMap");
        Constructor<?> constructor = mapClass.getConstructor();

        HashMap map3 = (HashMap) constructor.newInstance();

        System.out.println(map3.getClass().getSimpleName());
        System.out.println(map3.isEmpty());
    }


}