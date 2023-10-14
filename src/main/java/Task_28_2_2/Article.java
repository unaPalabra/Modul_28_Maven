package Task_28_2_2;

public class Article implements Deletable {

    @Override
    public void delete(String articleId) {
        System.out.println("Article is deleted");
    }

}
