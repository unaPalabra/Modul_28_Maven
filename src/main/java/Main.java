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


        //����� �������
        Object str = "574527282";
        Class<?> claz = str.getClass();
        System.out.println(claz.getSimpleName());
        System.out.println(claz.getName());


        //������������ ������
        //���������� ������������ ������� HashMap, AbstractMap � Map � ������� ���������:
        //
        //������� ������� ������ Class ��� ������� ������, ��������� ����� Class.forName().
        //������� ������������ ������� ������, ������ ����� getModifiers().
        //��������, �������� �� ����� HashMap ��������� � �����������, ��������� ������ Modifier.isPublic()
        // � Modifier.isAbstract() ��������������.
        //����� ��������, �������� �� AbstractMap ����������� �������, � Map  � �����������.

        // �������� ����� ��� java.util.HashMap
        Class hashMap = Class.forName("java.util.HashMap");

        // �������� ����� ��� java.util.AbstractMap
        Class abstractMap = Class.forName("java.util.AbstractMap");

        // �������� ����� ��� java.util.Map
        Class map = Class.forName("java.util.Map");


        //�������� ������������ ��� HashMap
        int hashMapModifiers = hashMap.getModifiers();

        //�������� ������������ ��� AbstractMap
        int abstractMapModifiers = abstractMap.getModifiers();

        //�������� ������������ ��� Map
        int mapModifiers = map.getModifiers();

        //�������, ����� �� HashMap public �����������
        System.out.println("HashMap class is public :" + Modifier.isPublic(hashMapModifiers));

        //�������, ����� �� AbstractMap abstract �����������
        System.out.println("AbstractMap class is abstract :" + Modifier.isAbstract(abstractMapModifiers));

        //�������, ����� �� Map interface �����������
        System.out.println("Map is interface :" + Modifier.isInterface(mapModifiers));

        //�������, ����� �� HashMap abstract �����������
        System.out.println("HashMap class is abstract :" + Modifier.isAbstract(hashMapModifiers));


        //���������� � ������
        Object obj = 5;
        Class clazz1 = obj.getClass();
        Package classPackage = clazz1.getPackage();

        System.out.println(classPackage.getName());


        //���������� � ������������ ������
        String str1 = "example";
        Class superClass = str1.getClass().getSuperclass();

        System.out.println(superClass.getSimpleName()); //�� ��������� ����� ����� �������� ����������� ������ Object.


        //���������� �� �����������
        //������� �� ����� ��� ���������� ������ HashMap
        Object map1 = new HashMap<>();
        Class[] interfaces = map1.getClass().getInterfaces();

        Arrays.stream(interfaces).forEach(System.out::println);


        //������������, ������ � ����
        //���������� ����� ���� ������������ � ������ HashMap.
        // �������� ������ ������ HashMap, ������� � ���� ����� � ������� ����� getConstructors().
        Object map2 = new HashMap<>();
        Constructor[] constructors = map2.getClass().getConstructors();

        Arrays.stream(constructors).forEach(System.out::println);

        //��� ���� ������ ����� �������� � ������� ������ getDeclaredFields():
        Field[] fields = map2.getClass().getDeclaredFields();

        Arrays.stream(fields).forEach(System.out::println);


        //�������� �������
        //����� ������� ����� ������ ������, ����� �������� ����������� ������
        // � ������� � ���� ����� newInstance().
        Class<?> mapClass = Class.forName("java.util.HashMap");
        Constructor<?> constructor = mapClass.getConstructor();

        HashMap map3 = (HashMap) constructor.newInstance();

        System.out.println(map3.getClass().getSimpleName());
        System.out.println(map3.isEmpty());
    }


}