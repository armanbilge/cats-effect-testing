/*
 * Copyright 2020 Typelevel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cats.effect.testing.minitest

import cats.effect.IO
import scala.concurrent.duration._
import cats.implicits._

object TestDetSuite extends DeterministicIOTestSuite {
  test("IO values should work") {
    IO(true).flatMap(b => IO(assert(b)))
  }

  test("Using Timer should work") {
    IO.sleep(1.day) >> IO(assert(true)).timeout(1.second)
  }
}
