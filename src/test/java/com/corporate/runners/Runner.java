package com.corporate.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        //tags = "@loginUAT",
        //tags = "@UATuna_muchas",
        //tags = "@loginUAT,@WidgetGraficosSaldosUAT,@WidgetGraficosSaldosEditaActualUAT",
        //tags = "@WidgetGraficosSaldosEliminarUAT",
        //tags = "@WidgetGraficosSaldosEditaActualUAT or @WidgetGraficosSaldosEditaAnteriorUAT or @WidgetGraficosSaldosCambioNombreUAT or @WidgetGraficosSaldosEliminarUAT",
        tags = "@WidgetInicioRapidoEditaUAT",
        //tags = "@WidgetInicioRapidoEditaUAT or @WidgetInicioRapidoCambioNombreUAT or @WidgetInicioRapidoEliminarUAT",
        glue = "com.corporate.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class Runner {
}
