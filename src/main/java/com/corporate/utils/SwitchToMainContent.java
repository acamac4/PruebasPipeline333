package com.corporate.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;

public class SwitchToMainContent implements Task {

    public static SwitchToMainContent back() {
        return new SwitchToMainContent();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Switch.toDefaultContext());
    }
}
