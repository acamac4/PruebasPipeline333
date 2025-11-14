package com.corporate.tasks.dashboard;

import com.corporate.utils.EsperaImplicita;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.corporate.UI.dashboard.UATWidgetInicioRapidoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UATWidgetInicioRapidoTask {

    public static Task ElUsuarioRevisaQueElWidgetInicioRapidoEsteActivoEnElDashboardUAT(){
        return new Task() {
            public <T extends Actor> void performAs(T actor) {
                actor.attemptsTo(
                        Click.on(BTN_TODOS_WIDGET_UAT),
                        EsperaImplicita.enSegundos(5)
                );

                boolean habilitado = CH_CONSULTA_WIDGET_INICIO_RAPIDO.resolveFor(actor).isPresent();
                if (habilitado) {
                    System.out.println("El elemento está presente");
                    boolean checkbox = CH_CONSULTA_WIDGET_INICIO_RAPIDO.resolveFor(actor).isSelected();
                    if (checkbox) {
                        System.out.println("ya esta seleccionado");
                    } else {
                        System.out.println("no estaba seleccionado");
                        actor.attemptsTo(Click.on(CH_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(1));
                    }
                } else {
                    System.out.println("El elemento no está presente");
                    actor.attemptsTo(Click.on(LK_MAS_IR_RAPIDO_A));
                }
                actor.attemptsTo(Click.on(BTN_LISTO_TODOS_WIDGET_UAT),EsperaImplicita.enSegundos(3));

            }
        };

    }

    public static Task ElUsuarioEditaElWidgetDeInicioRapidoConLosAtajos(){
        return Task.where("{usuario} el usuario edita el widget de graficos saldos actual",
                new Performable() {
                    public <T extends Actor> void performAs(T actor) {
                        //JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
                        //js.executeScript("arguments[0].click();", LK_MENU_WIDGET_GRAFICO_SALDOS.resolveFor(actor));

                        actor.attemptsTo(
                                MoveMouse.to(LK_MENU_WIDGET_INICIO_RAPIDO),
                                Click.on(LK_MENU_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(3),
                                Click.on(LK_EDITAR_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(1),
                                //VOY A SELECCIONAR LA OPCION DE UNA POR AHORA
                                Click.on(CH_CREAR_PAGO_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(1));

                        /*boolean checkbox = CH_CREAR_PAGO_WIDGET_INICIO_RAPIDO.resolveFor(actor).isSelected();
                        if (checkbox) {
                            System.out.println("ya estaba seleccionada");
                        } else {
                            System.out.println("se selecciona la primera cuenta");
                            actor.attemptsTo(Click.on(CH_CREAR_PAGO_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(1));
                        }*/
                        actor.attemptsTo(Click.on(BTN_ESCOGE_WIDGET_INICIO_RAPIDO));

                        System.out.println("Edito widget inicio rapido");
                    }
                }
        );
    }

    public static Task ElUsuarioCambiaElNombreDelWidgetInicioRapido(){
        return Task.where("{usuario} el usuario cambia el nombre del widget graficos saldos",
                new Performable() {
                    public <T extends Actor> void performAs(T actor) {
                        actor.attemptsTo(
                                Scroll.to(LK_MENU_WIDGET_INICIO_RAPIDO),
                                Click.on(LK_MENU_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(3),
                                Click.on(LK_RENOMBRAR_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(1),
                                Enter.theValue("RENOMBRE_WID_INI_RAP").into(TXT_RENOMBRAR_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(1),
                                Click.on(BTN_LISTO_RENOMBRAR_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(1));

                        System.out.println("Renombro widget inicio rapido");
                    }
                }
        );
    }

    public static Task ElUsuarioEliminaElWidgetDeGraficosSaldos(){
        return Task.where("{usuario} el usuario elimina el widget de graficos saldos",
                new Performable() {
                    public <T extends Actor> void performAs(T actor) {
                        actor.attemptsTo(
                                Scroll.to(LK_MENU_WIDGET_INICIO_RAPIDO),
                                Click.on(LK_MENU_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(3),
                                Click.on(LK_ELIMINAR_WIDGET_INICIO_RAPIDO),EsperaImplicita.enSegundos(1),
                                WaitUntil.the(LBL_ELIMINAR_WIDGET, isVisible()).forNoMoreThan(10).seconds(),
                                EsperaImplicita.enSegundos(3),
                                Click.on(BTN_ELIMINAR_WIDGET),EsperaImplicita.enSegundos(1));

                        System.out.println("Se elimino el widget inicio rapido");
                    }
                }
        );
    }

}
