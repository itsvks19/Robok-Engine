package org.robok.engine.feature.editor.languages.java.store.models

import kotlinx.serialization.Serializable

@Serializable
data class ClassItem(
    val className: String, 
    val classPackageName: String 
)
