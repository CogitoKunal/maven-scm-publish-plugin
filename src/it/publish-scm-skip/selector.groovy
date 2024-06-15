/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.nio.file.Files
import java.nio.file.Path

try {
    def proc = "svnadmin".execute()
    proc.consumeProcessOutput()
    proc.waitFor()

    def proc2 = "svn".execute()
    proc2.consumeProcessOutput()
    proc2.waitFor()

    def pom = basedir.toPath().resolve("pom.xml")
    def linkedPom = basedir.toPath().resolve("linked-pom.xml")
    Files.deleteIfExists(linkedPom)
    Files.createSymbolicLink(linkedPom, pom)
} catch (IOException e) {
    return false
}

return true
