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
plugins { kotlin }

dependencies {
  apiOf(
    Libs.KotlinCompileTesting,
    Libs.Kotlin.Reflect,
    Libs.Kotlin.Test.Junit5,
    Libs.Kotlin.Stdlib.Common,
    Libs.Kotlin.Compiler.Embeddable,
    Libs.Kotest.Assertions.Core,
  )
  // Don't use 'implementation', because it will be passed in all runtime classpath,
  //   in case of embedded compiler, we need to relocate full compiler APIs in this project.
  compileOnlyProject(Projects.Compiler.Base)
}

publication.data.artifactId = "common-compiler-testing"