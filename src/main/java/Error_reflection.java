import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Error_reflection {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException,
            InstantiationException, NoSuchFieldException, InvocationTargetException {
        HashMap map = new HashMap(); //�������� ������ ������ HashMap

        Class<?> clazz = map.getClass(); //������� � ���� �����

        //�������� ����� ������ ������ HashMap
        HashMap instance = (HashMap) clazz.getConstructor().newInstance();

        //������� � ���������� ������� ���� size
        Field field = instance.getClass().getDeclaredField("size");

        //��������� ����������� ����
        field.setAccessible(true);

        //��������� ���� size �������� 10
        field.setInt(instance, 10);

        System.out.println("Map is empty: " + instance.isEmpty());
        System.out.println("Map size:" + instance.size());
        System.out.println("Values: " + instance.toString());
    }
}

//� ������ ������� �� �������� ����� ������� map, ������� ����� ������ ������ HashMap
// � ������� getConstructor(), newInstance(). �������� ���� size � ������� ������
// getDeclaredField("size"), ��� � �������� ��������� ���������� ��� ����.
// ������������ ������ � ����� ����, ������ setAccessible(true).
// ������ ����� ����� Field ��������� �� ������ AccessibleObject.
// ����� ���������� �������� size ������ 10. ������ �� ����� �������� �� ���� ������,
// ������ � ��� �������� � ����.
