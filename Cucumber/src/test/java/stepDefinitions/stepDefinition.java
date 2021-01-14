package stepDefinitions;


import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {
	
	 @Given("^browser is selected by user$")
	    public void browser_is_selected_by_user() {
	        System.out.println("Chrome is selected by user");
	    }

	    @When("^browser is triggered$")
	    public void browser_is_triggered() {
	       System.out.println("Chrome is triggered!!");
	    }

	    @Then("^check if browser is started$")
	    public void check_if_browser_is_started()  {
	        System.out.println("Chrome has started successfully!!");
	    }

	
	@Given("^User is on landing Page$")
	public void user_is_on_landing_page()
	{
		System.out.println("|| Landing Page ||");
	}
	@When("^User login into the application with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_login_into_the_application_with_username_as_something_and_password_as_something(String strArg1, String strArg2){
        System.out.println("Username: "+strArg1+" Password: "+strArg2);
    }
	 @When("^User sign up with following details$")
	 public void user_sign_up_with_following_details(DataTable data)  {
		 List<List<String>> obj =  data.asLists();
		 for(int i = 0; i<1 ; i++)
		 {
			 System.out.println("User Details:::::");
			 for(int j =0; j<5 ; j++)
			 {			 
				 System.out.println(obj.get(i).get(j));
			 }
		 }
	    }
	 @When("^User login with (.+) and (.+)$")
	    public void user_login_with_and(String username, String password) {
		 System.out.println("Username: "+username+" Password: "+password);
	    }

	@Then("^Home Page is populated$")
	public void checkHomePage()
	{
		System.out.println("Home Page is populated");
	}
    @And("^User is registered for the services$")
    public void user_is_registered_for_the_services()  {
        System.out.println("User has been registered successfully!!");
    }

	@And("^Cards are displayed$")
	public void displayCards()
	{
        System.out.println("redirecting to cards page...............");
		System.out.println("Cards are displayed!!");
	}
	@And("^Cards are not displayed$")
	public void nodisplayCards()
	{
        System.out.println("redirecting to cards page...............");
		System.out.println("XX User Acess Denied XX");
	}

}
