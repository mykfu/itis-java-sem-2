package sem2.L12.tgmbot;

import java.util.Arrays;

public class UpdatesResponse implements Response {
    private boolean ok;
    private Update[] result;

    public UpdatesResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public Update[] getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "UpdatesResponse{" +
                "ok=" + ok +
                ", result=" + Arrays.toString(result) +
                '}';
    }
}
