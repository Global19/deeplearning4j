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

package org.nd4j.linalg.lossfunctions.impl;

import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Negative log likelihood loss function
 * <p>
 * In practice, this is implemented as an alias for {@link LossMCXENT} due to the mathematical equivalence
 */
public class LossNegativeLogLikelihood extends LossMCXENT {

    public LossNegativeLogLikelihood() {}

    public LossNegativeLogLikelihood(INDArray weights) {
        super(weights);
    }

    /**
     * The opName of this function
     *
     * @return
     */
    @Override
    public String name() {
        return toString();
    }

    @Override
    public String toString() {
        return "LossNegativeLogLikelihood()";
    }
}
