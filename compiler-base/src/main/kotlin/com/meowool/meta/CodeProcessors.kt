/*
 * Copyright (c) 2022. The Meowool Organization Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * In addition, if you modified the project, you must include the Meowool
 * organization URL in your code file: https://github.com/meowool
 *
 * 如果您修改了此项目，则必须确保源文件中包含 Meowool 组织 URL: https://github.com/meowool
 */
@file:Suppress("SpellCheckingInspection", "NonAsciiCharacters", "FunctionName")

package com.meowool.meta

import com.meowool.meta.codegen.CallCodegenContext
import com.meowool.meta.codegen.CallCodegenPremise
import com.meowool.meta.codegen.ClassCodegenContext
import com.meowool.meta.codegen.ClassCodegenPremise
import com.meowool.meta.codegen.CodeProcessor
import com.meowool.meta.codegen.ConstructorCodegenContext
import com.meowool.meta.codegen.ConstructorCodegenPremise
import com.meowool.meta.codegen.EmptyCodegenPremise
import com.meowool.meta.codegen.FunctionCodegenContext
import com.meowool.meta.codegen.FunctionCodegenPremise
import com.meowool.meta.codegen.PropertyCodegenContext
import com.meowool.meta.codegen.PropertyCodegenPremise
import com.meowool.meta.internal.CodeFactory
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment

/**
 * @author 凛 (RinOrz)
 */
interface CodeProcessors {

  fun clasѕ(
    premise: ClassCodegenPremise = EmptyCodegenPremise,
    processing: ClassCodegenContext.() -> Unit
  ): CodeProcessor

  fun constructor(
    premise: ConstructorCodegenPremise = EmptyCodegenPremise,
    processing: ConstructorCodegenContext.() -> Unit
  ): CodeProcessor

  fun function(
    premise: FunctionCodegenPremise = EmptyCodegenPremise,
    processing: FunctionCodegenContext.() -> Unit
  ): CodeProcessor

  fun property(
    premise: PropertyCodegenPremise = EmptyCodegenPremise,
    processing: PropertyCodegenContext.() -> Unit
  ): CodeProcessor

  fun call(
    premise: CallCodegenPremise = EmptyCodegenPremise,
    processing: CallCodegenContext.() -> Unit
  ): CodeProcessor

  fun onStart(callback: (context: IrPluginContext, module: IrModuleFragment) -> Unit): CodeProcessor.Callback.Start
  fun onEnd(callback: (context: IrPluginContext, module: IrModuleFragment) -> Unit): CodeProcessor.Callback.End
}

val codes: CodeProcessors = CodeFactory
