/*
 *  ******************************************************************************
 *  * Copyright (c) 2021 Deeplearning4j Contributors
 *  *
 *  * This program and the accompanying materials are made available under the
 *  * terms of the Apache License, Version 2.0 which is available at
 *  * https://www.apache.org/licenses/LICENSE-2.0.
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  * License for the specific language governing permissions and limitations
 *  * under the License.
 *  *
 *  * SPDX-License-Identifier: Apache-2.0
 *  *****************************************************************************
 */
package org.deeplearning4j.scalnet.layers.recurrent

import org.deeplearning4j.nn.conf.layers.{ OutputLayer => JOutputLayer }
import org.deeplearning4j.nn.layers.BaseOutputLayer
import org.deeplearning4j.scalnet.layers.core.OutputLayer
import org.nd4j.linalg.activations.Activation
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction
import org.scalatest.{ Matchers, WordSpec }

class RnnOutputLayerTest extends WordSpec with Matchers {

  "A RnnOutput layer" should {

    "have an input layer of shape (10, 100)" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX)
      rnnOutputLayer.inputShape shouldBe List(10, 100)
    }

    "have an ouput layer of shape (10, 100)" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX)
      rnnOutputLayer.outputShape shouldBe List(100, 10)
    }

    "compile to a DL4J RnnOutputLayer without loss" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX)
      val compiledLayer = rnnOutputLayer.compile
      compiledLayer.isInstanceOf[org.deeplearning4j.nn.conf.layers.RnnOutputLayer] shouldBe true
    }

    "compile to a DL4J RnnOutputLayer with loss" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX, Option(LossFunction.MCXENT))
      val compiledLayer = rnnOutputLayer.compile
      compiledLayer.isInstanceOf[org.deeplearning4j.nn.conf.layers.RnnOutputLayer] shouldBe true
    }

    "does not become an output layer when instanciated without proper loss" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX)
      rnnOutputLayer.output.isOutput shouldBe false
    }

    "become an output layer when instanciated with proper loss" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX, Option(LossFunction.MCXENT))
      rnnOutputLayer.output.isOutput shouldBe true
    }

    "become an output layer when converted to ouput layer with proper loss" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX)
      val compiledLayer = rnnOutputLayer.toOutputLayer(LossFunction.MCXENT)
      compiledLayer.isInstanceOf[OutputLayer] shouldBe true
    }

  }
}
