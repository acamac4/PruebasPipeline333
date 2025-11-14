package com.corporate.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;

public class SwitchToIframe implements Task {
    private String iframeNameOrId;

    public SwitchToIframe(String iframeNameOrId) {
        this.iframeNameOrId = iframeNameOrId;
    }

    public static SwitchToIframe byNameOrId(String iframeNameOrId) {
        return new SwitchToIframe(iframeNameOrId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Switch.toFrame(iframeNameOrId));
    }
}
