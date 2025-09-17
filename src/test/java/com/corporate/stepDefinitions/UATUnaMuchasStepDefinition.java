package com.corporate.stepDefinitions;

import com.corporate.questions.ValidaUATUnaMuchas1;
import com.corporate.tasks.UATUnaMuchasTask;
import com.corporate.utils.LoginUAT;
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

public class UATUnaMuchasStepDefinition {

    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor Actor1 = Actor.named("Actor1");

    @Before
    public void configuracion() {

    }
    @Given("el usuario ingresa la cuenta de salida del dinero en UAT")
    public void elUsuarioIngresaLaCuentaDeSalidaDelDineroEnUAT() {
        Actor1.can(BrowseTheWeb.with(navegador));
        Actor1.wasAbleTo(Open.url("https://lokiaslxvp017:9012/rwd-web/logon"));
        Actor1.attemptsTo(LoginUAT.ProcesoLoginUAT());
    }
    @When("el usuario escoge el proceso y las cuentas destino en UAT {int}")
    public void elUsuarioEscogeElProcesoYLasCuentasDestinoEnUAT(Integer int1) {
        Actor1.attemptsTo(UATUnaMuchasTask.UATUnaMuchas_1(int1));
    }
    @Then("el usuario revisa el mensaje de resultado de la transaccion y el completado")
    public void elUsuarioRevisaElMensajeDeResultadoDeLaTransaccionYElCompletado() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        ValidaUATUnaMuchas1.assertion(),
                        Matchers.equalTo(true)
                )

        );
    }
}
