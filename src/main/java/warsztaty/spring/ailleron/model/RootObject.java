package warsztaty.spring.ailleron.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootObject {
    @JsonProperty("RestResponse") // bez tego body rootResponse w Service zwraca null
    private RestResponse restResponse;

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
