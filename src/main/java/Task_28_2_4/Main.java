package Task_28_2_4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //Получаем все классы в пакете
        List<Class> classes = getAllClasses();

        for (Class clazz : classes) {
            //Для каждого класса выполняем следующие действия
            //Получаем все поля в классе
            Field[] allClassFields = clazz.getDeclaredFields();

            //Получаем все методы в классе
            Method[] allClassMethods = clazz.getMethods();
            //Для всех полей класса проверяем, что поле приватное. Если поле
            //не имеет модификатор private, выводим сообщение
            Arrays.asList(allClassFields).forEach(field -> {
                if (!Modifier.isPrivate(field.getModifiers())) {
                    System.out.println("Field with name '" + field.getName() + "' should be private");
                }
                //Проверяем, что в списке методов есть сеттер для данного
                //поля
                boolean hasSetter = Arrays.stream(allClassMethods)
                        .anyMatch(method -> method.getName().equals("set" + capitalize(field.getName())));
                //Проверяем, что в списке методов есть геттер для данного
                //поля
                boolean hasGetter = Arrays.stream(allClassMethods)
                        .anyMatch(method -> method.getName().equals("get" + capitalize(field.getName())));
                //Выводим сообщение, если сеттера нет
                if (!hasSetter) {
                    System.out.println(clazz.getSimpleName() + " has no setter for '" + field.getName() + "'");
                }

                //Выводим сообщение, если нет геттера
                if (!hasGetter) {
                    System.out.println(clazz.getSimpleName() + " has no getter for '" + field.getName() + "'");
                }
            });
        }
    }

    public static List<Class> getAllClasses() throws Exception {
        URL upackage = Main.class.getClassLoader().getResource("");

        BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) upackage.getContent()));
        String line;
        List<Class> classes = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            classes.add(Class.forName(line.replace(".class", "")));
        }

        return classes;
    }

    //Метод переводит первую букву строки в верхний регистр
    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}

