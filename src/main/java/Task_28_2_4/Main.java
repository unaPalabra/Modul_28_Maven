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
        //�������� ��� ������ � ������
        List<Class> classes = getAllClasses();

        for (Class clazz : classes) {
            //��� ������� ������ ��������� ��������� ��������
            //�������� ��� ���� � ������
            Field[] allClassFields = clazz.getDeclaredFields();

            //�������� ��� ������ � ������
            Method[] allClassMethods = clazz.getMethods();
            //��� ���� ����� ������ ���������, ��� ���� ���������. ���� ����
            //�� ����� ����������� private, ������� ���������
            Arrays.asList(allClassFields).forEach(field -> {
                if (!Modifier.isPrivate(field.getModifiers())) {
                    System.out.println("Field with name '" + field.getName() + "' should be private");
                }
                //���������, ��� � ������ ������� ���� ������ ��� �������
                //����
                boolean hasSetter = Arrays.stream(allClassMethods)
                        .anyMatch(method -> method.getName().equals("set" + capitalize(field.getName())));
                //���������, ��� � ������ ������� ���� ������ ��� �������
                //����
                boolean hasGetter = Arrays.stream(allClassMethods)
                        .anyMatch(method -> method.getName().equals("get" + capitalize(field.getName())));
                //������� ���������, ���� ������� ���
                if (!hasSetter) {
                    System.out.println(clazz.getSimpleName() + " has no setter for '" + field.getName() + "'");
                }

                //������� ���������, ���� ��� �������
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

    //����� ��������� ������ ����� ������ � ������� �������
    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}

