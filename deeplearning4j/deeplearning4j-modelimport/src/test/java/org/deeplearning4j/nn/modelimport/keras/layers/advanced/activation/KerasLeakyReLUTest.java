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

package org.deeplearning4j.nn.modelimport.keras.layers.advanced.activation;

import org.deeplearning4j.nn.conf.layers.ActivationLayer;
import org.deeplearning4j.BaseDL4JTest;
import org.deeplearning4j.nn.modelimport.keras.config.Keras1LayerConfiguration;
import org.deeplearning4j.nn.modelimport.keras.config.Keras2LayerConfiguration;
import org.deeplearning4j.nn.modelimport.keras.config.KerasLayerConfiguration;
import org.deeplearning4j.nn.modelimport.keras.layers.advanced.activations.KerasLeakyReLU;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Max Pumperla
 */
public class KerasLeakyReLUTest extends BaseDL4JTest {

    private Keras1LayerConfiguration conf1 = new Keras1LayerConfiguration();
    private Keras2LayerConfiguration conf2 = new Keras2LayerConfiguration();

    @Test
    public void testLeakyReLULayer() throws Exception {
        Integer keras1 = 1;
        buildLeakyReLULayer(conf1, keras1);
        Integer keras2 = 2;
        buildLeakyReLULayer(conf2, keras2);
    }

    private void buildLeakyReLULayer(KerasLayerConfiguration conf, Integer kerasVersion) throws Exception {
        double alpha = 0.3;

        Map<String, Object> layerConfig = new HashMap<>();
        layerConfig.put(conf.getLAYER_FIELD_CLASS_NAME(), conf.getLAYER_CLASS_NAME_LEAKY_RELU());
        Map<String, Object> config = new HashMap<>();
        String LAYER_FIELD_LEAKY_RELU_ALPHA = "alpha";
        config.put(LAYER_FIELD_LEAKY_RELU_ALPHA, alpha);
        String layerName = "leaky_relu";
        config.put(conf.getLAYER_FIELD_NAME(), layerName);
        layerConfig.put(conf.getLAYER_FIELD_CONFIG(), config);
        layerConfig.put(conf.getLAYER_FIELD_KERAS_VERSION(), kerasVersion);

        ActivationLayer layer = new KerasLeakyReLU(layerConfig).getActivationLayer();
        assertEquals("leakyrelu(a=0.3)", layer.getActivationFn().toString());
        assertEquals(layerName, layer.getLayerName());
    }
}
