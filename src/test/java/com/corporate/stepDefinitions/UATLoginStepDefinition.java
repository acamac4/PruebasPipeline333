package com.corporate.stepDefinitions;

import com.corporate.questions.ValidaLoginUAT;
import com.corporate.tasks.UATLoginTask;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class UATLoginStepDefinition {


    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor Actor1 = Actor.named("Actor1");

    @Before
    public void configuracion() {

        Actor1.can(BrowseTheWeb.with(navegador));
    }

    @Given("el usuario ingresa a la url de corporate UAT")
    public void elUsuarioIngresaALaUrlDeCorporateUAT() {
        Actor1.wasAbleTo(Open.url("https://lokiaslxvp017:9012/rwd-web/logon"));

    }

    @When("el usuario ingresa los datos de login UAT")
    public void elUsuarioIngresaLosDatosDeLoginUAT() {
        Actor1.attemptsTo(UATLoginTask.UATlogin());

    }

    @Then("el usuario ingresa a la pagina principal UAT")
    public void elUsuarioIngresaALaPaginaPrincipalUAT() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        ValidaLoginUAT.assertion(),
                        Matchers.equalTo(true)
                )
        );

    }
    //@AfterAll
    @After
    public void cloreBrowser() {
        if (navegador != null) {
            navegador.quit();

        }
    }
}