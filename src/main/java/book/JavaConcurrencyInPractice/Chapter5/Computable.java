package book.JavaConcurrencyInPractice.Chapter5;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
