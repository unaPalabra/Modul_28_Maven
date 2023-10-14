import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class CallOfMethod {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, InvocationTargetException {
        HashMap map = new HashMap(); //������� ������ ������ HashMap

        //�������� ������ ������ Class � ���������� �������
        Class clazz = map.getClass();

        //� ������ ������� ������� ����� put
        Method putMethod = clazz.getDeclaredMethod("put", Object.class, Object.class);
        //������� ����� put. � �������� ����� ������ �������� �key� � � ��������
        //�������� - �value�
        putMethod.invoke(map, "key", "value");

        System.out.println("Values: " + map.toString());
    }
}
