package kg.megacom.exeption;

public class ProductNotFoundExc extends RuntimeException {
    public ProductNotFoundExc(String message) {
        super(message);
    }
}
