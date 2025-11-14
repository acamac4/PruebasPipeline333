package com.corporate.tasks.otros;

import com.corporate.utils.EsperaImplicita;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;

import static com.corporate.UI.otros.UATLoginUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UATLoginTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Enter.theValue("CB000000117").into(TXT_COMPANIA_UAT),
                    Enter.theValue("ACAMAC4").into(TXT_USUARIO_UAT),
                    Enter.theValue("Corporate40*").into(TXT_CONTRASENA_UAT),
                    Click.on(TXT_LENGUAJE_UAT),
                    Click.on(By.xpath("//*[@id='model_language_option_es_co']"))
            );
            actor.attemptsTo(
                    Click.on(BTN_ACCESO_UAT),
                    EsperaImplicita.enSegundos(5)
            );
            if (TXT_DASHBOARD.resolveFor(actor).isPresent()) {
                System.out.println("El dashboard está habilitado");
            } else {
                System.out.println("El dashboard está deshabilitado");
                actor.attemptsTo(
                        Click.on(BTN_LOGIN_EXISTE_UAT),
                        EsperaImplicita.enSegundos(5)
                );
            }

        } catch (Exception e) {
            System.out.println("error" +e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static UATLoginTask UATlogin() {
        return instrumented(UATLoginTask.class);
    }
}
