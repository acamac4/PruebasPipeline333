@WidgetGraficosSaldosUAT
Feature: Probar el Widget de graficos saldos en corporate UAT

  Background:
    Given el usuario ingresa a la url de corporate UAT
    When el usuario ingresa los datos de login UAT
    When el usuario revisa que el widget graficos saldos este activo en el dashboard UAT

  @WidgetGraficosSaldosEditaActualUAT
  Scenario:Edita de manera exitosa el widget graficos saldos actual en el dashboard UAT
    When el usuario edita el widget de graficos saldos actual
    Then se visualiza el cambio del widget graficos saldos actual en el dashboard UAT

  @WidgetGraficosSaldosEditaAnteriorUAT
  Scenario:Edita de manera exitosa el widget graficos saldos anterior en el dashboard UAT
    When el usuario edita el widget de graficos saldos anterior
    Then se visualiza el cambio del widget graficos saldos anterior en el dashboard UAT

  @WidgetGraficosSaldosCambioNombreUAT
  Scenario:Cambia nombre de manera exitosa el widget graficos saldos en el dashboard UAT
    When el usuario cambia el nombre del widget graficos saldos
    Then se visualiza que el nombre del widget graficos saldos cambio en el dashboard UAT

  @WidgetGraficosSaldosEliminarUAT
  Scenario:Elimina de manera exitosa el widget graficos saldos en el dashboard UAT
    When el usuario elimina el widget de graficos saldos
    Then el widget graficos saldos no aparece en el dashboard UAT

  @WidgetGraficosSaldosValidacionSaldosUAT
  Scenario:Validacion  saldos en el widget graficos saldos en el dashboard UAT
    When el usuario selecciona la cuenta para validar el saldo final
    Then el widget graficos saldos muestra el valor de la cuenta seleccionada UAT


