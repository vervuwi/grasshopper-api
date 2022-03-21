package be.refleqt.testing.support;


import refleqt_example_api_framework.dto.ApiClient;
import refleqt_example_api_framework.dto.api.PetApi;

public class ApiManager {
    private final ApiClient apiClient;
    private static String basePath = "https://petstore.swagger.io/v2";

    public ApiManager() {
        this.apiClient = getDefaultApiClient();
    }

    //Sets the base path and other default generic parameters.
    public static ApiClient getDefaultApiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(basePath);

        return apiClient;
    }

    //Extension of the default api client with required headers like a access token
//    public ApiClient getAuthorizedApiClient() {
//        return getDefaultApiClient()
//                .addDefaultHeader("Authorization", "Bearer " + store.accessToken)
//                .addDefaultHeader("OtherRequiredHeader", "value");
//    }

    public PetApi getPetApi() {
        return new PetApi(apiClient);
    }
}
