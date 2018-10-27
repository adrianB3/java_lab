package prob2;

public class InequalityException extends Exception {
    @Override
    public String toString() {
        return "Primul numar este mai mare sau egal cu al doilea, trebuie sa fie mai mic";
    }
}
