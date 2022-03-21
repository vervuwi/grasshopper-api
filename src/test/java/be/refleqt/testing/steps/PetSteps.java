package be.refleqt.testing.steps;


import be.refleqt.testing.support.ApiManager;
import be.refleqt.testing.support.Store;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import refleqt_example_api_framework.dto.ApiException;
import refleqt_example_api_framework.dto.ApiResponse;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PetSteps {
    final static Logger logger = LoggerFactory.getLogger(PetSteps.class);

    private Store store = new Store();
    private ApiResponse petsByStatusResponse;
    private ApiResponse petByIdResponse;

    @Given("I find pet by status available")
    public void iFindPetByStatusAvailable() {
        List<String> statuses = Arrays.asList("available");
        try {
            petsByStatusResponse = new ApiManager().getPetApi().findPetsByStatusWithHttpInfo(statuses);
        } catch (ApiException e) {
            store.setLatestApiException(e);
        }
    }

    @Given("I find pet by id - failure")
    public void iFindPetById() {
        try {
            petByIdResponse = new ApiManager().getPetApi().getPetByIdWithHttpInfo(000000L);
        } catch (ApiException e) {
            store.setLatestApiException(e);
        }
    }

    @Then("I check the response")
    public void iCheckResponse() {
        assertThat(petsByStatusResponse.getStatusCode()).isEqualTo(200);
    }

    @Then("I check response for failure")
    public void iCheckResponseFailure() {
        assertThat(store.getLatestApiException().getCode()).isEqualTo(404);
    }
}

