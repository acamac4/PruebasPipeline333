package com.corporate.utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickButtonInIframe implements Task {
    private Target button;

    public ClickButtonInIframe(Target button) {
        this.button = button;
    }

    public static ClickButtonInIframe on(Target button) {
        return new ClickButtonInIframe(button);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(button));
    }
}