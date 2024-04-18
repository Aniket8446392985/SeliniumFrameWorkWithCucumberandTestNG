package StepDefn;

import io.cucumber.java.en.*;

import java.util.List;

public class LoginPageTest {

//   ## This is an example of normal parameterazation of any scenario
    @Given("user is on login page")
    public void user_is_on_login_page()
    {
        System.out.println("User is on landing page printed");
    }
    @When("user enters username {string}")
    public void user_enters_username(String username) {
        System.out.println("user has entered username as " + username);
    }
    @And("user enters password {string}")
    public void user_enters_password(String password) {
        System.out.println("user has entered password as " + password);
    }
    @Then("user lands on home page")
    public void user_lands_on_home_page() {
        System.out.println("User is on home page printed");
        System.out.println("====================================================================");
    }

    //   Scenario Outline: Test login page with multiple input data
    @When("user enters username {string} combination")
    public void user_enters_username_combination(String UserName) {
        System.out.println(UserName);
    }
    @When("user enters password {string} combination")
    public void user_enters_password_combination(String Password) {
        System.out.println(Password);
    }


    // Scenario: Test login page with any ata type of parameters using regex patterns

    @When("^user enters regex username (.+)$")// here opening and closing regex are used
    public void user_enters_username_aniket_fos(String Username)
    {
        System.out.println("Here we have used regex to accept any data type of parameter:" +Username);
    }
    @When("^user enters regex password (.+)$")
    public void user_enters_password_pass(String Password) {
        System.out.println("Here we have used regex to accept any data type of parameter:" +Password);
    }

    //  Scenario: Test sign up page with multiple data inputs

    @Given("user is on sign up page")
    public void user_is_on_sign_up_page()
    {
        System.out.println("User landed on sign up page");
    }
    @When("User enters the multiple details on sign up page")
    public void user_enters_the_multiple_details_on_sign_up_page(List<String> list)
    {
        System.out.println("1st input parameter is : "+list.get(0));
        System.out.println("2nd input parameter is : "+list.get(1));
        System.out.println("3rd input parameter is : "+list.get(2));
        System.out.println("4th input parameter is : "+list.get(3));
    }
    @Then("User lands on successfull sign up page")
    public void user_lands_on_successfull_sign_up_page()
    {
        System.out.println("User lamded on success sign up page");
    }

    // @Background: This is Example of background keyword that executes before every scenario
    @Given ("User is launched browser")
    public void launch_browser()
    {
        System.out.println("**********************************");
        System.out.println("User launched the browser");
    }
    @Then ("User loads website URL")
    public void loadURL()
    {
        System.out.println("User Loaded the required URL");
    }



}
