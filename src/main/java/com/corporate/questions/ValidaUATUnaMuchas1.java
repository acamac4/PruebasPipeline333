package com.corporate.questions;

import com.corporate.utils.CapturaPantalla;
import com.corporate.utils.EsperaImplicita;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;

import java.awt.*;
import java.io.IOException;

import static com.corporate.UI.UATUnaMuchasUI.*;
import static com.corporate.tasks.UATUnaMuchasTask.cantidad_tran;

public class ValidaUATUnaMuchas1 implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        int h=0;
        h=cantidad_tran;
        String transaccion;
        WebElementFacade elementUATUnaMuchas = MENSAJE_PANEL_UAT.resolveFor(actor);
        String cadena= Text.of(MENSAJE_PANEL_UAT).answeredBy(actor).toString();
        try {
            transaccion=com.corporate.utils.Varios_Metodos.NumerosTransacciones(cadena);

        actor.attemptsTo(
                EsperaImplicita.enSegundos(5),
                Click.on(BTN_CENTRO_TRANSFERENCIAS)
                );
        String[] partes = transaccion.split(";");
        String completado=""; boolean terminado=true;
        for(int i=0;i<partes.length;i++)
            {
                System.out.println("=>ultimo " + partes[i]);
                actor.attemptsTo(
                        EsperaImplicita.enSegundos(2),
                        Enter.theValue(partes[i]).into(TXT_TRANSFERENCIA),
                        Click.on(BTN_BUSCAR_TRANSFERENCIA),
                        EsperaImplicita.enSegundos(2)
                );
                completado = Text.of(TXT_COMPLETADA).answeredBy(actor).toString();
                if (!completado.equals("Completado")){terminado=false;System.out.println("error en parecido a Completado variable = "+completado);}
                CapturaPantalla.capturarPantalla("ImagenUAT_Validacion_Completado "+partes[i]+" caso "+h);
            }

        return (terminado=true && cadena.contains("creada exitosamente"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

    public static Question<Boolean> assertion() {
        return new ValidaUATUnaMuchas1();
    }

}
