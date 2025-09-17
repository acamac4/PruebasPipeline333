package com.corporate.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.corporate.UI.UATLoginUI.LBL_LOGIN_EXITOSO_UAT;

public class ValidaLoginUAT implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade elementLogin = LBL_LOGIN_EXITOSO_UAT.resolveFor(actor);
        return elementLogin.isDisplayed();

    }

    public static Question<Boolean> assertion() {
        return new ValidaLoginUAT();
    }

}
