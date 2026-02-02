package reflection.AnnotationReader;

public class AnnotationReader {

    public static void main(String[] args) {

        Class<ProjectInfo> cls = ProjectInfo.class;

        if (cls.isAnnotationPresent(Author.class)) {

            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());

        } else {
            System.out.println("Author annotation not found");
        }
    }
}

