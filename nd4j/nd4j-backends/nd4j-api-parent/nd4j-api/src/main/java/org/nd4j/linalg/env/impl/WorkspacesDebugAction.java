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

package org.nd4j.linalg.env.impl;

import org.nd4j.linalg.api.memory.enums.DebugMode;
import org.nd4j.linalg.env.EnvironmentalAction;
import org.nd4j.linalg.factory.Nd4j;

public class WorkspacesDebugAction implements EnvironmentalAction {
    @Override
    public String targetVariable() {
        return "ND4J_WORKSPACES_DEBUG";
    }

    @Override
    public void process(String value) {
        switch (value.toUpperCase()) {
            case "SPILL_EVERYTHING": {
                    Nd4j.getWorkspaceManager().setDebugMode(DebugMode.SPILL_EVERYTHING);
                };
                break;
            case "BYPASS_EVERYTHING": {
                    Nd4j.getWorkspaceManager().setDebugMode(DebugMode.BYPASS_EVERYTHING);
                }
            break;
        }
    }
}
