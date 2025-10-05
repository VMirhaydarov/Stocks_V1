package com.example.detektrules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction

class MissingLoadingIndicatorCheckRule : Rule() {
    override val issue = Issue(
        id = "MissingLoadingIndicatorCheck",
        severity = Severity.Defect,
        description = "Тест StocksScreenTest должен проверять наличие индикатора загрузки.",
        debt = Debt.FIVE_MINS
    )

    override fun visitClass(klass: KtClass) {
        if (klass.name == "StocksScreenTest") {
            var found = false
            klass.declarations.filterIsInstance<KtNamedFunction>().forEach { function ->
                function.bodyBlockExpression?.text?.let { body ->
                    if (body.contains("onNodeWithTag(\"loadingIndicator\")")) {
                        found = true
                    }
                }
            }
            if (!found) {
                report(
                    CodeSmell(
                        issue,
                        Entity.atName(klass),
                        "В тесте StocksScreenTest отсутствует проверка индикатора загрузки."
                    )
                )
            }
        }
        super.visitClass(klass)
    }
}

