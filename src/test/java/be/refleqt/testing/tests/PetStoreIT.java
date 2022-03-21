package be.refleqt.testing.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "@PetStoreDemo",
        glue = "be.refleqt.testing",
        plugin = {"json:target/cucumber/json/PetStore.json", "html:target/cucumber/html/PetStore.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class PetStoreIT {
}
