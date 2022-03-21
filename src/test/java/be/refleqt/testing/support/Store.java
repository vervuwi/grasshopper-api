package be.refleqt.testing.support;

import refleqt_example_api_framework.dto.ApiException;

public class Store {
    private ApiException exception;
    private String authorization;
    private String language = "NL";

    /**
     * ApiException
     */
    public ApiException getLatestApiException() {
        return exception;
    }

    public void setLatestApiException(ApiException exception) {
        this.exception = exception;
    }

}
