package com.corporate.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.IOException;

import static com.corporate.UI.UATLoginUI.*;
import static com.corporate.utils.Constantes.rutaExcel;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUAT implements Task {

    Excel excel = new Excel();
    public  <T extends Actor> void performAs(T actor) {
        try {
            CapturaPantalla.capturarPantalla("Imagen_LoginUAT_1");
            actor.attemptsTo(
                    Enter.theValue(excel.leerDatosExcel(rutaExcel, "Hoja2", 1, 0)).into(TXT_COMPANIA_UAT),
                    Enter.theValue(excel.leerDatosExcel(rutaExcel, "Hoja2", 1, 1)).into(TXT_USUARIO_UAT),
                    Enter.theValue(excel.leerDatosExcel(rutaExcel, "Hoja2", 1, 2)).into(TXT_CONTRASENA_UAT),
                    Click.on(TXT_LENGUAJE_UAT),
                    Click.on(By.xpath("//*[@id='model_language_option_es_co']"))
            );
            CapturaPantalla.capturarPantalla("Imagen_LoginUAT_2");
            actor.attemptsTo(
                    Click.on(BTN_ACCESO_UAT)
            );
            actor.attemptsTo(
                    //WaitUntil.the(BTN_LOGIN_EXISTE_UAT, isClickable()).forNoMoreThan(10).seconds(),
                    EsperaImplicita.enSegundos(3),
                    Check.whether(TXT_DASHBOARD.isVisibleFor(actor)).andIfSo().otherwise(Click.on(BTN_LOGIN_EXISTE_UAT))
            );
            CapturaPantalla.capturarPantalla("Imagen_LoginUAT_3");

        } catch (IOException | AWTException e) {
            System.out.println("error" +e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static LoginUAT ProcesoLoginUAT() {
        return instrumented(LoginUAT.class);
    }
}

