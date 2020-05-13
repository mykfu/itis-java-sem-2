public class DefaultResponse<T> implements Response<T> {
    protected boolean ok;
    protected T result;

    public DefaultResponse() {
    }

    public DefaultResponse(boolean ok, T result) {
        this.ok = ok;
        this.result = result;
    }

    public boolean isOk() {
        return ok;
    }

    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        return result.getClass().getTypeName() + "{" +
                "result=" + result +
                '}';
    }
}
