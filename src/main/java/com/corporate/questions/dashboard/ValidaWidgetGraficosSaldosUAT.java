package com.corporate.questions.dashboard;

import com.corporate.utils.EsperaImplicita;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.corporate.UI.dashboard.UATWidgetGraficosSaldosUI.*;
import static com.corporate.UI.otros.UATLoginUI.TXT_DASHBOARD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ValidaWidgetGraficosSaldosUAT implements Question<Boolean> {
    public enum TipoValidacion {
        MENSAJE_EDICION_GRAFICO_SALDOS,
        CAMBIO_NOMBRE_GRAFICO_SALDOS,
        ELIMINA_WIDGET_GRAFICO_SALDOS
    }
    private TipoValidacion tipoValidacion;

    public ValidaWidgetGraficosSaldosUAT(TipoValidacion tipoValidacion) {
        this.tipoValidacion = tipoValidacion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean esExitoso;
        EsperaImplicita.enSegundos(5);
        switch (tipoValidacion) {
            case MENSAJE_EDICION_GRAFICO_SALDOS:
                esExitoso=!LBL_GRAFICO_SALDOS_VACIO.resolveFor(actor).isPresent();
                if (esExitoso) {
                    System.out.println("Validación exitosa: se edito el widget grafico saldos");
                } else {
                    System.out.println("Validación fallida: no se edito el widget grafico saldos");
                }
                return esExitoso;
            case CAMBIO_NOMBRE_GRAFICO_SALDOS:
                actor.attemptsTo(WaitUntil.the(LBL_NOMBRE_GRAFICO_SALDOS, isVisible()).forNoMoreThan(10).seconds());
                WebElementFacade elementGraSalNom = LBL_NOMBRE_GRAFICO_SALDOS.resolveFor(actor);
                esExitoso = elementGraSalNom.getText().equals("RENOMBRE_WID_GRA_SAL");
                System.out.println("imprime el texto del elemento: " + elementGraSalNom.getText());
                if (esExitoso) {
                    System.out.println("Validación exitosa: se cambio el nombre del widget grafico saldos");
                } else {
                    System.out.println("Validación fallida: no se cambio el nombre del widget grafico saldos");
                }
                return esExitoso;
            case ELIMINA_WIDGET_GRAFICO_SALDOS:
                esExitoso=!LBL_ELIMINAR_WIDGET.resolveFor(actor).isPresent();
                if (esExitoso) {
                    System.out.println("Validación exitosa: se elimino el widget grafico saldos");
                } else {
                    System.out.println("Validación fallida: no se elimino el widget grafico saldos");
                }
                return esExitoso;
            default:
                throw new IllegalArgumentException("Tipo de validación no soportado");
        }
    }

    public static ValidaWidgetGraficosSaldosUAT validaMensajeEdicionGraficosSaldos() {
        return new ValidaWidgetGraficosSaldosUAT(TipoValidacion.MENSAJE_EDICION_GRAFICO_SALDOS);
    }

    public static ValidaWidgetGraficosSaldosUAT validaCambioNombreGraficosSaldos() {
        return new ValidaWidgetGraficosSaldosUAT(TipoValidacion.CAMBIO_NOMBRE_GRAFICO_SALDOS);
    }

    public static ValidaWidgetGraficosSaldosUAT validaEliminaWidgetGraficosSaldos() {
        return new ValidaWidgetGraficosSaldosUAT(TipoValidacion.ELIMINA_WIDGET_GRAFICO_SALDOS);
    }

}
