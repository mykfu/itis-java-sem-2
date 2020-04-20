public interface Response<T> {
    public boolean isOk();

    public T getResult();
}
