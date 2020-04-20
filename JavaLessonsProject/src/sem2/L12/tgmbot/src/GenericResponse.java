public class GenericResponse<T> {
    private boolean ok;
    private T result;

    public GenericResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}
