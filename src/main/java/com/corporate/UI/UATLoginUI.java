package com.corporate.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UATLoginUI {
    public static final Target TXT_COMPANIA_UAT = Target.the("compania_uat").located(By.id("model_organizationId"));
    public static final Target TXT_USUARIO_UAT = Target.the("usuario_uat").located(By.id("model_userId"));
    public static final Target TXT_CONTRASENA_UAT = Target.the("contrasena_uat").located(By.id("model_password"));
    public static final Target TXT_LENGUAJE_UAT = Target.the("lenguaje_uat").located(By.id("model_language_displayText"));
    public static final Target LBL_LOGIN_EXITOSO_UAT = Target.the("dashboard_uat").located(By.id("Dashboard"));
    //public static final Target BTN_LOGIN_EXISTE_UAT = Target.the("btn_continuar_uat").located(By.xpath("//*[contains(text(),'Continuar')]"));
    public static final Target BTN_LOGIN_EXISTE_UAT = Target.the("btn_continuar_uat").located(By.xpath("//*[@id='btnContinue']"));
    public static final Target BTN_ACCESO_UAT = Target.the("acceso_uat").located(By.id("btnLogin"));
    public static final Target TXT_DASHBOARD = Target.the("txt_dashboard").located(By.xpath("//*[@id='Dashboard']"));
}