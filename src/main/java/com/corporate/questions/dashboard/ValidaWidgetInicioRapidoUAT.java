package com.corporate.questions.dashboard;

import com.corporate.utils.EsperaImplicita;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.corporate.UI.dashboard.UATWidgetInicioRapidoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidaWidgetInicioRapidoUAT implements Question<Boolean> {

    public enum TipoValidacion {
        MENSAJE_EDICION_INICIO_RAPIDO,
        CAMBIO_NOMBRE_INICIO_RAPIDO,
        ELIMINA_WIDGET_INICIO_RAPIDO
    }
    private ValidaWidgetInicioRapidoUAT.TipoValidacion tipoValidacion;

    public ValidaWidgetInicioRapidoUAT(ValidaWidgetInicioRapidoUAT.TipoValidacion tipoValidacion) {
        this.tipoValidacion = tipoValidacion;
    }

    //@Override
    public Boolean answeredBy(Actor actor) {
        boolean esExitoso;
        EsperaImplicita.enSegundos(5);
        switch (tipoValidacion) {
            case MENSAJE_EDICION_INICIO_RAPIDO:
                esExitoso=!LBL_INTERIOR_INICIO_RAPIDO.resolveFor(actor).isPresent();
                if (esExitoso) {
                    System.out.println("Validación exitosa: se edito el widget inicio rapido");
                } else {
                    System.out.println("Validación fallida: no se edito el widget inicio rapido");
                }
                return esExitoso;
            case CAMBIO_NOMBRE_INICIO_RAPIDO:
                actor.attemptsTo(WaitUntil.the(LBL_NOMBRE_INICIO_RAPIDO, isVisible()).forNoMoreThan(10).seconds());
                WebElementFacade elementGraSalNom = LBL_NOMBRE_INICIO_RAPIDO.resolveFor(actor);
                esExitoso = elementGraSalNom.getText().equals("RENOMBRE_WID_INI_RAP");
                System.out.println("imprime el texto del elemento: " + elementGraSalNom.getText());
                if (esExitoso) {
                    System.out.println("Validación exitosa: se cambio el nombre del widget inicio rapido");
                } else {
                    System.out.println("Validación fallida: no se cambio el nombre del widget inicio rapido");
                }
                return esExitoso;
            case ELIMINA_WIDGET_INICIO_RAPIDO:
                esExitoso=!LBL_ELIMINAR_WIDGET.resolveFor(actor).isPresent();
                if (esExitoso) {
                    System.out.println("Validación exitosa: se elimino el widget inicio rapido");
                } else {
                    System.out.println("Validación fallida: no se elimino el widget inicio rapido");
                }
                return esExitoso;
            default:
                throw new IllegalArgumentException("Tipo de validación no soportado");
        }
    }

    public static ValidaWidgetInicioRapidoUAT validaMensajeEdicionInicioRapido() {
        return new ValidaWidgetInicioRapidoUAT(ValidaWidgetInicioRapidoUAT.TipoValidacion.MENSAJE_EDICION_INICIO_RAPIDO);
    }

    public static ValidaWidgetInicioRapidoUAT validaCambioNombreInicioRapido() {
        return new ValidaWidgetInicioRapidoUAT(ValidaWidgetInicioRapidoUAT.TipoValidacion.CAMBIO_NOMBRE_INICIO_RAPIDO);
    }

    public static ValidaWidgetInicioRapidoUAT validaElinaWidgetInicioRapido() {
        return new ValidaWidgetInicioRapidoUAT(ValidaWidgetInicioRapidoUAT.TipoValidacion.ELIMINA_WIDGET_INICIO_RAPIDO);
    }

}
