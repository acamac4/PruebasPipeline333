package com.corporate.stepDefinitions.dashboard;


import com.corporate.questions.dashboard.ValidaWidgetInicioRapidoUAT;
import com.corporate.tasks.dashboard.UATWidgetInicioRapidoTask;
import com.corporate.tasks.otros.UATLoginTask;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class UATWidgetInicioRapido {

    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor Actor1 = Actor.named("Actor1");

    @Before
    public void configuracion() {
        Actor1.can(BrowseTheWeb.with(navegador));
    }

    @When("el usuario revisa que el widget inicio rapido este activo en el dashboard UAT")
    public void ElUsuarioRevisaQueElWidgetInicioRapidoEsteActivoEnElDashboardUAT() {
        Actor1.attemptsTo(UATWidgetInicioRapidoTask.ElUsuarioRevisaQueElWidgetInicioRapidoEsteActivoEnElDashboardUAT());
    }

    //WidgetInicioRapidoEditaUAT
    @When("el usuario edita el widget de inicio rapido con los atajos")
    public void ElUsuarioEditaElWidgetDeInicioRapidoConLosAtajos() {
        Actor1.attemptsTo(UATWidgetInicioRapidoTask.ElUsuarioEditaElWidgetDeInicioRapidoConLosAtajos());
    }

    @Then("se visualiza el cambio del widget inicio rapido con todos los atajos")
    public void SeVisualizaElCambioDelWidgetInicioRapidoConTodosLosAtajos() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        //ValidaWidgetGraficosSaldosUAT.assertion(),
                        ValidaWidgetInicioRapidoUAT.validaMensajeEdicionInicioRapido(),
                        Matchers.equalTo(true)
                )
        );
    }

    //WidgetInicioRapidoCambioNombreUAT
    @When("el usuario cambia el nombre del widget inicio rapido")
    public void ElUsuarioCambiaElNombreDelWidgetInicioRapido() {
        Actor1.attemptsTo(UATWidgetInicioRapidoTask.ElUsuarioCambiaElNombreDelWidgetInicioRapido());
    }

    @Then("se visualiza que el nombre del widget inicio rapido cambio en el dashboard UAT")
    public void SeVisualizaQueElNombreDelWidgetInicioRapidoCambioEnElDashboardUAT() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        ValidaWidgetInicioRapidoUAT.validaCambioNombreInicioRapido(),
                        Matchers.equalTo(true)
                )
        );
    }

    //WidgetInicioRapidoEliminarUAT
    @When("el usuario elimina el widget inicio rapido")
    public void ElUsuarioEliminaElWidgetInicioRapido() {
        Actor1.attemptsTo(UATWidgetInicioRapidoTask.ElUsuarioEliminaElWidgetDeGraficosSaldos());
    }

    @Then("el widget inicio rapido no aparece en el dashboard UAT")
    public void ElWidgetInicioRapidoNoApareceEnElDashboardUAT() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        ValidaWidgetInicioRapidoUAT.validaElinaWidgetInicioRapido(),
                        Matchers.equalTo(true)
                )
        );
    }

    @After
    public void cloreBrowser() {
        if (navegador != null) {
            navegador.quit();

        }
    }
}