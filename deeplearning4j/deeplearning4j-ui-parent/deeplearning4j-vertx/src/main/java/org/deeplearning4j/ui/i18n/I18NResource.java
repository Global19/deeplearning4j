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

package org.deeplearning4j.ui.i18n;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.nd4j.common.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
@Data
public class I18NResource {
    private final String resource;

    public InputStream getInputStream() throws IOException {
        return new ClassPathResource(resource).getInputStream();
    }
}
