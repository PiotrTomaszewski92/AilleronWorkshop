package warsztaty.spring.ailleron.model;

import java.util.List;

public class RestResponse {
    private List<String> messages;
    private Result result;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
