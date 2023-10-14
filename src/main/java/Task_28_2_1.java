import java.lang.reflect.Modifier;

public class Task_28_2_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class arrayList = Class.forName("java.util.ArrayList");
        Class abstractList = Class.forName("java.util.AbstractList");
        Class collection = Class.forName("java.util.Collection");

        int arrayListModifiers = arrayList.getModifiers();
        int abstractListModifiers = abstractList.getModifiers();
        int collectionModifiers = collection.getModifiers();

        System.out.println("ArrayList class is public: " + Modifier.isPublic(arrayListModifiers));
        System.out.println("ArrayList class is protected: " + Modifier.isProtected(arrayListModifiers));
        System.out.println("AbstractList class is abstract: " + Modifier.isAbstract(abstractListModifiers));
        System.out.println("AbstractList class is static: " + Modifier.isStatic(abstractListModifiers));
        System.out.println("Collection is interface: " + Modifier.isInterface(collectionModifiers));
    }
}
