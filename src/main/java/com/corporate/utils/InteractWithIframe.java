package com.corporate.utils;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public class InteractWithIframe implements Task {

    private Target buttonInIframe = Target.the("button inside iframe").located(By.id("button_id"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SwitchToIframe.byNameOrId("iframe_name_or_id"),  // Cambiar al iframe
                ClickButtonInIframe.on(buttonInIframe),           // Interactuar con el botón dentro del iframe
                SwitchToMainContent.back()                        // Volver al contenido principal
        );
    }

    public static InteractWithIframe perform() {
        return instrumented(InteractWithIframe.class);
    }
}