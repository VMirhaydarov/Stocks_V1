package com.example.detektrules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class MissingLoadingIndicatorCheckProvider : RuleSetProvider {
    override val ruleSetId: String = "custom"
    override fun instance(config: Config): RuleSet =
        RuleSet(ruleSetId, listOf(MissingLoadingIndicatorCheckRule()))
}
