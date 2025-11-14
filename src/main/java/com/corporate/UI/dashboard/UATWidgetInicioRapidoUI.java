package com.corporate.UI.dashboard;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UATWidgetInicioRapidoUI {
    public static final Target BTN_TODOS_WIDGET_UAT = Target.the("btn_todos_widget_uat").located(By.xpath("//*[@id='add-widget-link']"));
    public static final Target CH_CONSULTA_WIDGET_INICIO_RAPIDO = Target.the("ch_consulta_widget_inicio_rapido").located(By.xpath("/html/body/ol-overlay-holder[2]/ol-overlay-wrapper/div[2]/add-widget/ol-page/div/div/div[2]/ol-overlay-content/form/ol-grid/div/div[2]/table/tbody/tr[7]/td[1]/div/div/div/ol-checkbox/label/div/input"));
    public static final Target CH_WIDGET_INICIO_RAPIDO = Target.the("ch_widget_inicio_rapido").located(By.xpath("//*[@id='input-widgetCheckbox11-checkbox_checkinput-background']"));
    public static final Target LBL_WIDGET_INICIO_RAPIDO = Target.the("lbl_widget_inicio_rapido").located(By.xpath("//*[@id='widgetInput1']"));
    public static final Target BTN_LISTO_TODOS_WIDGET_UAT = Target.the("btn_listo_todos_widget_uat").located(By.xpath("//*[@id='btnSubmitManageWidget']"));
    public static final Target LK_MENU_WIDGET_INICIO_RAPIDO = Target.the("lk_menu_widget_inicio_rapido").located(By.xpath("/html/body/online-app/div[2]/div[1]/div/section/ng-component/ng-component/ol-page/div/div[2]/ol-page-content/div/div/div/div[2]/div/dashboard-widget[2]/div/div/div[1]/div[2]/button/span[2]"));
    public static final Target LK_EDITAR_WIDGET_INICIO_RAPIDO = Target.the("lk_editar_widget_inicio_rapido").located(By.xpath("//*[@id='Drag-list2']/dashboard-widget/div/div/div[1]/div[2]/ol-popover-container/div[2]/ul/li[1]/a"));
    public static final Target CH_CREAR_PAGO_WIDGET_INICIO_RAPIDO = Target.the("ch_crear_pago_widget_inicio_rapido").located(By.xpath("//*[@id='input-groupElementcreate_payment-checkbox_checkinput-label']"));
    public static final Target BTN_ESCOGE_WIDGET_INICIO_RAPIDO = Target.the("btn_escoge_widget_inicio_rapido").located(By.xpath("//*[@id='btnSubmitShortcutSettings']"));
    public static final Target LBL_INTERIOR_INICIO_RAPIDO = Target.the("lbl_interior_inicio_rapido").located(By.xpath("//*[@id='Drag-list2']/dashboard-widget/div/div/div[2]/shortcuts-widget/div/div/div/p"));
    public static final Target LBL_NOMBRE_INICIO_RAPIDO = Target.the("lbl_nombre_inicio_rapido").located(By.xpath("//*[@id='Drag-list2']/dashboard-widget/div/div/div[1]/div[1]/h2"));
    public static final Target LK_RENOMBRAR_WIDGET_INICIO_RAPIDO = Target.the("lk_renombrar_widget_inicio_rapido").located(By.xpath("//*[@id='Drag-list2']/dashboard-widget/div/div/div[1]/div[2]/ol-popover-container/div[2]/ul/li[2]/a"));
    public static final Target TXT_RENOMBRAR_WIDGET_INICIO_RAPIDO = Target.the("txt_renombrar_widget_inicio_rapido").located(By.xpath("//*[@id='renameWidgetName']"));
    public static final Target BTN_LISTO_RENOMBRAR_WIDGET_INICIO_RAPIDO = Target.the("btn_listo_renombrar_widget_inicio_rapido").located(By.xpath("//*[@id='btnRenameWidgetDone']"));
    public static final Target LK_ELIMINAR_WIDGET_INICIO_RAPIDO = Target.the("lk_eliminar_widget_inicio_rapido").located(By.xpath("//*[@id='Drag-list2']/dashboard-widget/div/div/div[1]/div[2]/ol-popover-container/div[2]/ul/li[3]/a"));
    public static final Target LBL_ELIMINAR_WIDGET = Target.the("lbl_eliminar_widget").located(By.xpath("//*[@id='overlay-title']"));
    public static final Target BTN_ELIMINAR_WIDGET = Target.the("btn_eliminar_widget").located(By.xpath("//*[@id='btnRemoveWidgetDelete']"));
    public static final Target LK_MAS_IR_RAPIDO_A = Target.the("lk_mas_ir_rapido_a").located(By.xpath("//*[@id='btnAddWidget_5']/span"));

}
