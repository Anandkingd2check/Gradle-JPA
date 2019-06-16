package hello.Exception;

import java.util.function.Supplier;

public class DogNotFoundException extends Exception implements Supplier<DogNotFoundException> {
    public DogNotFoundException(String s) {
    }

    @Override
    public DogNotFoundException get() {
        return null;
    }
}
