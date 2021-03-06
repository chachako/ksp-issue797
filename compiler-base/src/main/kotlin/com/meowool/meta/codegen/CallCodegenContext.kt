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
package com.meowool.meta.codegen

import com.meowool.meta.MetaExtension
import com.meowool.meta.internal.MetaReferencedSymbolRemapper
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.symbols.IrSimpleFunctionSymbol

/**
 * @author 凛 (RinOrz)
 */
abstract class CallCodegenContext(
  pluginContext: IrPluginContext,
  moduleFragment: IrModuleFragment,
  metaContext: MetaExtension.Context,
  referencedSymbolRemapper: MetaReferencedSymbolRemapper
) : ElementCodegenContext<IrCall, IrExpression>(pluginContext, moduleFragment, metaContext, referencedSymbolRemapper) {
  abstract val call: IrCall
  inline val callee: IrSimpleFunction get() = call.symbol.owner
  inline val calleeSymbol: IrSimpleFunctionSymbol get() = call.symbol
}
