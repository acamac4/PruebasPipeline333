package com.corporate.stepDefinitions.dashboard;

import com.corporate.questions.dashboard.ValidaWidgetGraficosSaldosUAT;
import com.corporate.questions.otros.ValidaLoginUAT;
import com.corporate.tasks.dashboard.UATWidgetGraficosSaldosTask;
import com.corporate.tasks.otros.UATLoginTask;
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

public class UATWidgetGraficosSaldos {


    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor Actor1 = Actor.named("Actor1");

    @Before
    public void configuracion() {
        Actor1.can(BrowseTheWeb.with(navegador));
    }

    @When("el usuario revisa que el widget graficos saldos este activo en el dashboard UAT")
    public void ElUsuarioRevisaQueElWidgetGraficosSaldosEsteActivoEnElDashboardUAT() {
        Actor1.attemptsTo(UATWidgetGraficosSaldosTask.ElUsuarioRevisaQueElWidgetGraficosSaldosEsteActivoEnElDashboardUAT());
    }

    //WidgetGraficosSaldosEditaActualUAT
    @When("el usuario edita el widget de graficos saldos actual")
    public void ElUsuarioEditaElWidgetDeGraficosSaldosActual() {
        Actor1.attemptsTo(UATWidgetGraficosSaldosTask.ElUsuarioEditaElWidgetDeGraficosSaldosActual());
    }

    @Then("se visualiza el cambio del widget graficos saldos actual en el dashboard UAT")
    public void SeVisualizaElCambioDelWidgetGraficosSaldosActualEnElDashboardUAT() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        //ValidaWidgetGraficosSaldosUAT.assertion(),
                        ValidaWidgetGraficosSaldosUAT.validaMensajeEdicionGraficosSaldos(),
                        Matchers.equalTo(true)
                )
        );
    }

    //WidgetGraficosSaldosEditaAnteriorUAT
    @When("el usuario edita el widget de graficos saldos anterior")
    public void ElUsuarioEditaElWidgetDeGraficosSaldosAnterior() {
        Actor1.attemptsTo(UATWidgetGraficosSaldosTask.ElUsuarioEditaElWidgetDeGraficosSaldosAnterior());
    }

    @Then("se visualiza el cambio del widget graficos saldos anterior en el dashboard UAT")
    public void SeVisualizaElCambioDelWidgetGraficosSaldosAnteriorEnElDashboardUAT() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        ValidaWidgetGraficosSaldosUAT.validaMensajeEdicionGraficosSaldos(),
                        Matchers.equalTo(true)
                )
        );
    }

    //WidgetGraficosSaldosCambioNombreUAT
    @When("el usuario cambia el nombre del widget graficos saldos")
    public void ElUsuarioCambiaElNombreDelWidgetGraficosSaldos() {
        Actor1.attemptsTo(UATWidgetGraficosSaldosTask.ElUsuarioCambiaElNombreDelWidgetGraficosSaldos());
    }

    @Then("se visualiza que el nombre del widget graficos saldos cambio en el dashboard UAT")
    public void SeVisualizaQueElNombreDelWidgetGraficosSaldosCambioEnElDashboardUAT() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        ValidaWidgetGraficosSaldosUAT.validaCambioNombreGraficosSaldos(),
                        Matchers.equalTo(true)
                )
        );
    }

    //WidgetGraficosSaldosEliminarUAT
    @When("el usuario elimina el widget de graficos saldos")
    public void ElUsuarioEliminaElWidgetGraficosSaldos() {
        Actor1.attemptsTo(UATWidgetGraficosSaldosTask.ElUsuarioEliminaElWidgetDeGraficosSaldos());
    }

    @Then("el widget graficos saldos no aparece en el dashboard UAT")
    public void ElWidgetGraficosSaldosNoApareceEnElDashboardUAT() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        ValidaWidgetGraficosSaldosUAT.validaEliminaWidgetGraficosSaldos(),
                        Matchers.equalTo(true)
                )
        );
    }

    /*
    //WidgetGraficosSaldosValidacionSaldosUAT
    @When("el usuario selecciona la cuenta para validar el saldo final")
    public void ElUsuarioSeleccionaLaCuentaParaValidarElSaldoFinal() {
        Actor1.attemptsTo(UATLoginTask.UATlogin());
    }

    @Then("el widget graficos saldos muestra el valor de la cuenta seleccionada UAT")
    public void ElWidgetGraficosSaldosMuestraElValorDeLaCuentaSeleccionadaUAT() {
        Actor1.should(
                seeThat(
                        "La respuesta fue: ",
                        ValidaWidgetGraficosSaldosUAT.validaCambioNombreGraficosSaldos(),
                        Matchers.equalTo(true)
                )
        );
    }
    */

    @After
    public void cloreBrowser() {
        if (navegador != null) {
            navegador.quit();

        }
    }
}