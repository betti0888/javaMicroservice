package hu.book.oe;

import java.util.function.Supplier;

@FunctionalInterface
public interface AuthorizationSupplier extends Supplier<String> {

}
