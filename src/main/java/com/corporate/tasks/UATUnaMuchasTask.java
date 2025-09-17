package com.corporate.tasks;

import com.corporate.utils.CapturaPantalla;
import com.corporate.utils.EsperaImplicita;
import com.corporate.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static com.corporate.UI.UATUnaMuchasUI.*;
import static com.corporate.utils.Constantes.rutaExcel;
import static com.corporate.utils.Constantes.rutaExcelOperaciones;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class UATUnaMuchasTask implements Task {

    Excel excel = new Excel();
    public static int cantidad_tran;

    @Override
    public <T extends Actor> void performAs(T actor) {
        int i=0;
        i=cantidad_tran;
        try {
            System.out.println("imprimir cantidad3" +cantidad_tran);
            //sacamos la cantidad de las transacciones a realizar
            int cant=excel.CantidadExcel(rutaExcelOperaciones, "Hoja2");
            actor.attemptsTo(
                    Click.on(LINK_TRANSFERENCIAS_UAT),
                    Click.on(LINK_INTER_UNA_MUCHAS_UAT),
                    EsperaImplicita.enSegundos(3)
            );
            CapturaPantalla.capturarPantalla("ImagenUAT 1 caso "+i);
            //Creamos un bucle for para ejecutar la cantidad de transacciones
            String Desde, Programacion, Notransf, Frecuencia, Cuentas, Valores, Festivos;
            //for(int i=1;i<2;i++)
            //for(int i=1;i<cant;i++)
            //{
            Desde=excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 0);
            Frecuencia=excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 2);
            Programacion=excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 6);
            Notransf=excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 7);
            Cuentas=excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 9);
            Valores=excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 10);
            Festivos=excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 11);

            actor.attemptsTo(
                    Click.on(SEL_DESDE_UAT),
                    Click.on(By.xpath("//*[contains(text(), '"+Desde+"')]")),
                    Enter.theValue(excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 1)).into(TXT_FECHA_UAT),
                    Click.on(LABEL_FECHA_UAT));
            if(Frecuencia.equals("Una Sola Vez"))
            {
                actor.attemptsTo(
                        Click.on(RADIO_UNA_SOLA_VEZ_UAT),
                        Check.whether((excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 3)).equals("Si")).andIfSo(Click.on(CHECK_NOTA_UAT), Enter.theValue(excel.leerDatosExcel(rutaExcelOperaciones, "Hoja1",i, 4)).into(TXT_NOTA_UAT)),
                        Check.whether((excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 5)).equals("Si")).andIfSo(Click.on(CHECK_APROBAR_ENVIAR_UAT)),
                        Click.on(BTN_SELECCIONAR_CTAS_UAT)
                );
            }else
            {
                actor.attemptsTo(
                        Click.on(RADIO_RECURRENTE_UAT),
                        Click.on(SEL_PROGRAMACION_UAT),
                        Click.on(By.xpath("//*[contains(text(), '"+Programacion+"')]")),
                        Check.whether(Festivos.equals("Proximo dia")).andIfSo(Click.on(MOVER_PAGO_PROX)).otherwise(Click.on(MOVER_PAGO_ANT)),
                        Check.whether(Notransf.equals("Continuar programación recurrente hasta nuevo aviso")).andIfSo(Click.on(RADIO_CONT_PROGRAMACION_UAT)),
                        Check.whether(Notransf.equals("Enviar")).andIfSo(Click.on(RADIO_ENVIAR_UAT), Enter.theValue(excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 8)).into(TXT_CANT_VECES)),
                        Check.whether(Notransf.equals("Finalizar en esta fecha dd/mm/aaaa")).andIfSo(Click.on(RADIO_FIN_FECHA_UAT), Enter.theValue(excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 8)).into(TXT_FIN_FECHA)),
                        //Scroll.to(CHECK_NOTA_UAT),
                        Check.whether((excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 3)).equals("Si")).andIfSo(Click.on(CHECK_NOTA_UAT),Enter.theValue(excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 4)).into(TXT_NOTA_UAT)),
                        Check.whether((excel.leerDatosExcel(rutaExcelOperaciones, "Hoja2",i, 5)).equals("Si")).andIfSo(Click.on(CHECK_APROBAR_ENVIAR_UAT)),
                        Click.on(BTN_SELECCIONAR_CTAS_UAT)
                );
            }
            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            /*
            actor.attemptsTo(
                    EsperaImplicita.enSegundos(3),
                    SwitchToIframe.byNameOrId("overlayContainerFrame")
            );  */

            //SELECCIONAMOS LAS CUENTAS DONDE VA EL DINERO
            String[] part_Cuentas = Cuentas.split(";");
            String[] part_Valores = Valores.split(";");
            actor.attemptsTo(
                    Click.on(SEL_CRITERIO_CTA),
                    Click.on(By.xpath("//*[@id='accountDestinationfilter_criteriaType_option_object.number']/span"))
            );
            for (int y = 0; y < part_Cuentas.length; y++) {
                actor.attemptsTo(
                        Enter.theValue(part_Cuentas[y]).into(TXT_BUSCAR_CTA),
                        Click.on(BTN_BUSCAR_CTA),
                        Click.on(CHECK_CTA_UAT)
                );
            }
            actor.attemptsTo(
                    Click.on(BTN_LISTO_UAT),
                    EsperaImplicita.enSegundos(3)
            );

            /*
            actor.attemptsTo(

                    SwitchToMainContent.back()
            );    */
            CapturaPantalla.capturarPantalla("ImagenUAT 2 caso "+i);
            //SELECCIONAMOS LOS VALORES DE CADA UNA DE LAS CUENTAS
            for (int k = 0; k < part_Valores.length; k++) {
                actor.attemptsTo(
                        Scroll.to(BTN_CONTINUE_UAT),
                        Enter.theValue(part_Valores[k]).into(By.id("recipientAmount_"+k+"_input"))
                );
            }
            CapturaPantalla.capturarPantalla("ImagenUAT 3 caso "+i);

            actor.attemptsTo(
                    EsperaImplicita.enSegundos(5),
                    Click.on(BTN_CONTINUE_UAT),
                    Click.on(BTN_CONTINUE_UAT),
                    WaitUntil.the(TXT_CONTRASENA3, isClickable()).forNoMoreThan(10).seconds(),
                    Enter.theValue(excel.leerDatosExcel(rutaExcel, "Hoja2", 1, 2)).into(TXT_CONTRASENA3),
                    Click.on(BTN_ENVIAR_TRANS_UAT),
                    EsperaImplicita.enSegundos(2)
            );
            CapturaPantalla.capturarPantalla("ImagenUAT 4 caso "+i);
            //}

        } catch (Exception e) {
            System.out.println("error" +e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static UATUnaMuchasTask UATUnaMuchas_1(int cantidad) {
        cantidad_tran=cantidad;
        System.out.println("imprimir cantidad2" +cantidad);
        return instrumented(UATUnaMuchasTask.class);
    }


}
