/*
 * This file is part of ts2kt-unofficial-gradle-plugin-plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) Kenzie Togami <https://octyl.net>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.octyl.ts2kt.gradle.repository.dependency

import net.octyl.ts2kt.gradle.Ts2ktUnofficialExtension

class ClientDependencyHandlerScope(private val extension: Ts2ktUnofficialExtension) {

    private fun String.addDependency(dependency: ExternalClientDependency) =
            dependency.also { extension.getClientConfiguration(this).dependencies.add(it) }

    operator fun String.invoke(dependencyNotation: Any) =
            addDependency(DependencyFactory.createFromAnyNotation(dependencyNotation))

    operator fun String.invoke(group: String?, name: String, version: String? = null) =
            addDependency(DependencyFactory.createDependency(group, name, version))
}
