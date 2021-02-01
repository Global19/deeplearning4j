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
package org.nd4j.linalg.api.ops.impl.layers.convolution;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.common.base.Preconditions;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.DynamicCustomOp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Upsampling3d operation
 */
@Slf4j
@Getter
@NoArgsConstructor
public class Upsampling3d extends DynamicCustomOp {


    protected boolean ncdhw;
    protected int scaleH;
    protected int scaleW;
    protected int scaleD;

    public Upsampling3d(SameDiff sameDiff, SDVariable input, boolean ncdhw, int scaleD, int scaleH, int scaleW) {
        super("upsampling3d",sameDiff, new SDVariable[]{input});
        this.ncdhw = ncdhw;

        this.scaleD = scaleD;
        this.scaleH = scaleH;
        this.scaleW = scaleW;

        addIArgument(scaleD);
        addIArgument(scaleH);
        addIArgument(scaleW);
        addIArgument(scaleD);
        addIArgument(ncdhw ? 1 : 0);
    }




    public Upsampling3d(INDArray input, boolean ncdhw, int scaleH, int scaleW, int scaleD) {
        super(new INDArray[]{input}, null);
        this.ncdhw = ncdhw;

        this.scaleD = scaleD;
        this.scaleH = scaleH;
        this.scaleW = scaleW;

        addIArgument(scaleD);
        addIArgument(scaleH);
        addIArgument(scaleW);
        addIArgument(scaleD);
        addIArgument(ncdhw ? 0 : 1);
    }



    @Override
    public String opName() {
        return "upsampling3d";
    }



    @Override
    public List<SDVariable> doDiff(List<SDVariable> f1) {
        return Arrays.asList(new Upsampling3dBp(sameDiff, arg(0), f1.get(0), this.ncdhw).outputVariables());
    }

    @Override
    public List<DataType> calculateOutputDataTypes(List<DataType> inputDataTypes){
        Preconditions.checkState(inputDataTypes != null && inputDataTypes.size() == 1, "Expected 1 input data type for %s, got %s", getClass(), inputDataTypes);
        return Collections.singletonList(inputDataTypes.get(0));
    }
}
