package models;

public class OperationResult<T> {

    public boolean success;
    public String message;
    public T data;

    public OperationResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> OperationResult<T> ok(T data) {
        return new OperationResult<>(true, "Operación exitosa", data);
    }

    public static <T> OperationResult<T> fail(String message) {
        return new OperationResult<>(false, message, null);
    }

}
