package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;

public class dataTableSteps {
    @Given("^the following animals:$")
    public void given_animals(DataTable inputs) {
        // Convert the input datatable into a list of strings
        List<String> animals = inputs.asList();

        //print all animals list
        System.out.println(animals);

        // List out all the animals
        for(String animal : animals) {
            System.out.println(animal);
        }

        // List a single animal
        System.out.println(animals.get(1));
    }

    @When("the animals make a sound")
    public void theAnimalsMakeASound() {
        System.out.println("End Step");
    }
}
