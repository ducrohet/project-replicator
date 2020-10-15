/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gradle.replicator.model

interface DependenciesInfo {
    val dependency: String
    val type: DependencyType
    val scope: String
}

enum class DependencyType(val jsonValue: String) {
    MODULE("moduleName") {
        override fun getString(value: String, asString: (String) -> String) = "project(${asString(value)})"
    },
    EXTERNAL_LIBRARY("library") {
        override fun getString(value: String, asString: (String) -> String) = asString(value)
    };

    abstract fun getString(value: String, asString: (String) -> String): String
}
