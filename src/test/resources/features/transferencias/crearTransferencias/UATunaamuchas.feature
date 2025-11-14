@UATuna_muchas
Feature: realizar transaccion una a muchas UAT

  Scenario Outline:hacer transaccion exitosa una a muchas en UAT
    Given el usuario ingresa la cuenta de salida del dinero en UAT
    When el usuario escoge el proceso y las cuentas destino en UAT <transaccion>
    Then el usuario revisa el mensaje de resultado de la transaccion y el completado
    Examples:
      | transaccion |
      | 1           |