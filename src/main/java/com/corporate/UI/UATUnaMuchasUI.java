package com.corporate.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UATUnaMuchasUI {


    public static final Target LINK_TRANSFERENCIAS_UAT = Target.the("transferencias_uat").located(By.xpath("//*[@id='navigation_transfers']/span[2]/span[2]"));
    public static final Target LINK_INTER_UNA_MUCHAS_UAT = Target.the("una_muchas_uat").located(By.xpath("//*[@id='navigation_transfers_createOneToManyTransfer']/span[2]"));
    public static final Target SEL_DESDE_UAT = Target.the("cta_desde_uat").located(By.xpath("//*[@id='accountNumbercombobox']/span"));
    public static final Target TXT_FECHA_UAT = Target.the("fecha_uat").located(By.xpath("//*[@id='transferDate-datepicker']"));
    public static final Target LABEL_FECHA_UAT = Target.the("fecha1_uat").located(By.id("transferDate-datepicker_label"));
    public static final Target RADIO_UNA_SOLA_VEZ_UAT = Target.the("una_sola_vez_uat").located(By.id("onetime-radio-option-input_radio-outer-circle"));
    public static final Target RADIO_RECURRENTE_UAT = Target.the("recurrente_uat").located(By.id("recurringRadio-radio-option-input_radio-outer-circle"));
    public static final Target CHECK_NOTA_UAT = Target.the("nota_uat").located(By.xpath("//*[@id='input-transferMemoCheckbox-checkbox_checkinput-background']"));
    public static final Target TXT_NOTA_UAT = Target.the("txt_nota_uat").located(By.name("memo"));
    public static final Target CHECK_APROBAR_ENVIAR_UAT = Target.the("aprobar_enviar_uat").located(By.xpath("//*[@id='input-approveOnSubmit-checkbox_checkinput-background']"));
    public static final Target BTN_SELECCIONAR_CTAS_UAT = Target.the("seleccionar_ctas_uat").located(By.id("btnSelectDestinationAccounts"));
    public static final Target SEL_PROGRAMACION_UAT = Target.the("sel_programacion_uat").located(By.xpath("//*[@id='recurringSchedulecombobox']/span"));
    public static final Target MOVER_PAGO_PROX = Target.the("mover_pago_prox").located(By.id("forward-radio-option-input_radio-outer-circle"));
    public static final Target MOVER_PAGO_ANT = Target.the("mover_pago_ant").located(By.id("back-radio-option-input_radio-outer-circle"));
    public static final Target RADIO_CONT_PROGRAMACION_UAT = Target.the("cont_programacion_uat").located(By.xpath("//*[@id='continueUntilFurtherNotice-radio-option-input_radio-outer-circle']"));
    public static final Target RADIO_ENVIAR_UAT = Target.the("enviar_prog_uat").located(By.xpath("//*[@id='numberOfPayments-radio-option-input_radio-outer-circle']"));
    public static final Target RADIO_FIN_FECHA_UAT = Target.the("fin_fecha_uat").located(By.xpath("//*[@id='endDate-radio-option-input_radio-outer-circle']"));
    public static final Target TXT_CANT_VECES = Target.the("cant_veces_aut").located(By.id("numberOfPayments"));
    public static final Target TXT_FIN_FECHA = Target.the("txt_fin_fecha_uat").located(By.id("endDate-datepicker"));
    public static final Target SEL_CRITERIO_CTA = Target.the("sel_criterio_cta").located(By.id("accountDestinationfilter_criteriaType_displayText"));
    public static final Target TXT_BUSCAR_CTA = Target.the("txt_buscar_cta").located(By.id("accountDestinationfilter_criteriaValue"));
    public static final Target BTN_BUSCAR_CTA = Target.the("btn_buscar_cta").located(By.id("search_button_accountDestinationfilter"));
    public static final Target CHECK_CTA_UAT = Target.the("check_cta_uat").located(By.xpath("//*[@id='input-accountDestination-rowSelector-0-checkbox_checkinput-background']"));
    public static final Target BTN_LISTO_UAT = Target.the("btn_listo_uat").located(By.xpath("//*[@id='btnContinue']"));
    public static final Target BTN_CONTINUE_UAT = Target.the("btn_continue_uat").located(By.xpath("//*[@id='btnContinue']"));
    public static final Target TXT_CONTRASENA3 = Target.the("txt_contrasena3").located(By.xpath("//*[@id='signature']"));
    public static final Target BTN_ENVIAR_TRANS_UAT = Target.the("btn_enviar_trans_uat").located(By.xpath("//*[@id='btnSubmit']"));
    public static final Target MENSAJE_PANEL_UAT = Target.the("mensaje_panel_UAT").located(By.xpath("//*[@id='success-block-BULK-TRANSFER-SUCCESS']/div[3]/div[1]/div[2]/div/span"));

    //Transferencia con número de transacción IVZ6BY3TDE, 0DYMV1EEI6 has sido creada exitosamente.
    public static final Target BTN_CENTRO_TRANSFERENCIAS = Target.the("btn_centro_transferencias").located(By.xpath("//*[@id='btnTransferCenter']"));
    public static final Target TXT_TRANSFERENCIA = Target.the("txt_transferencia").located(By.xpath("//*[@id='advancedSearchTemplateNameReference']"));
    public static final Target BTN_BUSCAR_TRANSFERENCIA = Target.the("btn_buscar_transferencia").located(By.xpath("//*[@id='btnSearch']"));
    public static final Target TXT_COMPLETADA = Target.the("txt_completada").located(By.xpath("//*[@id='all-table']/tbody/tr/td[7]"));
    //public static final Target TXT_TRANSFERENCIA = Target.the("txt_transferencia").located(By.xpath("//*[@id='advancedSearchTemplateNameReference']"));
    //public static final Target TXT_TRANSFERENCIA = Target.the("txt_transferencia").located(By.xpath("//*[@id='advancedSearchTemplateNameReference']"));


    //*[@id="btnSearch"]

}
