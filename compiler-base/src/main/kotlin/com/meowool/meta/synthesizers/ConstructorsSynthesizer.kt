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
package com.meowool.meta.synthesizers

import com.meowool.meta.MetaExtension
import org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.resolve.BindingContext

/**
 * @author 凛 (RinOrz)
 */
interface ConstructorsSynthesizer : MetaExtension {

  fun generate(
    parent: ClassDescriptor,
    binding: BindingContext,
    result: MutableCollection<ClassConstructorDescriptor>
  )

  abstract class Scope(
    override val parent: ClassDescriptor,
    override val binding: BindingContext,
  ) : ClassMemberSynthesizerScope() {
    abstract fun synthesize(descriptor: ClassConstructorDescriptor)
    operator fun ClassConstructorDescriptor.unaryPlus() = synthesize(this)
  }
}