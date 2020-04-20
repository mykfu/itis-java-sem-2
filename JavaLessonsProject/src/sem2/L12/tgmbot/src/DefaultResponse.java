public class DefaultResponse<T> implements Response<T> {
    private boolean ok;
    private T result;

    public DefaultResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                '}';
    }
}
