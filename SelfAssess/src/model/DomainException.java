package model;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }

    public static class Category extends Category {

        public MainCategory(String name, String description) {
            super(name, description);
        }
    }
}
