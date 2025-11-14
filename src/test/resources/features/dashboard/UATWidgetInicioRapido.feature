@WidgetInicioRapidoUAT
Feature: Probar el Widget de inicio rapido en corporate UAT

  Background:
    Given el usuario ingresa a la url de corporate UAT
    When el usuario ingresa los datos de login UAT
    When el usuario revisa que el widget inicio rapido este activo en el dashboard UAT

  @WidgetInicioRapidoEditaUAT
  Scenario:Edita de manera exitosa el widget inicio rapido en el dashboard UAT
    When el usuario edita el widget de inicio rapido con los atajos
    Then se visualiza el cambio del widget inicio rapido con todos los atajos

  @WidgetInicioRapidoCambioNombreUAT
  Scenario:Cambia nombre de manera exitosa el widget inicio rapido en el dashboard UAT
    When el usuario cambia el nombre del widget inicio rapido
    Then se visualiza que el nombre del widget inicio rapido cambio en el dashboard UAT

  @WidgetInicioRapidoEliminarUAT
  Scenario:Elimina de manera exitosa el widget inicio rapido en el dashboard UAT
    When el usuario elimina el widget inicio rapido
    Then el widget inicio rapido no aparece en el dashboard UAT