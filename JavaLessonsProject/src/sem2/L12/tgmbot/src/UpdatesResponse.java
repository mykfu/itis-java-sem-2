import model.Update;

import java.util.Arrays;

public class UpdatesResponse implements Response {
    private boolean ok;
    private Update[] result;

    public UpdatesResponse() {
    }

    public UpdatesResponse(boolean ok, Update[] result) {
        this.ok = ok;
        this.result = result;
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
