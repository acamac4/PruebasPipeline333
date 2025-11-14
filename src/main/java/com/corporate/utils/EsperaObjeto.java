package com.corporate.utils;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

public class EsperaObjeto implements Interaction {


    private Target Objeto;
    public EsperaObjeto(Target Objeto) {
        this.Objeto = Objeto;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            int r=0;
            boolean confirma;
            System.out.println("paso primero");
            while(r<10)
            {
                System.out.println("entro");
                actor.attemptsTo(
                        Check.whether(Objeto.isVisibleFor(actor)).andIfSo(EsperaImplicita.enSegundos(3))
                );
                r++;
                System.out.println("paso ");
            }

        } catch (Exception e) {
            System.out.println("error" +e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public static Performable Esperar(Target Objeto){
        return Instrumented.instanceOf(EsperaObjeto.class).withProperties(Objeto);
    }
}
