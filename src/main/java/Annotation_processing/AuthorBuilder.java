package Annotation_processing;

public class AuthorBuilder {

    private Author instance = new Author();

    public Author build() {
        return instance;
    }

    public AuthorBuilder setFirstName(String value) {
        instance.setFirstName(value);
        return this;
    }

    public AuthorBuilder setLastName(String value) {
        instance.setLastName(value);
        return this;
    }

    public AuthorBuilder setBiography(String value) {
        instance.setBiography(value);
        return this;
    }

}