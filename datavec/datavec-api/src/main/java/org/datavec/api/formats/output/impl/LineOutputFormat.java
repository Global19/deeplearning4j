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

package org.datavec.api.formats.output.impl;


import org.datavec.api.conf.Configuration;
import org.datavec.api.exceptions.DataVecException;
import org.datavec.api.formats.output.OutputFormat;
import org.datavec.api.records.writer.RecordWriter;
import org.datavec.api.records.writer.impl.LineRecordWriter;

/**
 * Line output format
 * @author Adam Gibson
 */
public class LineOutputFormat implements OutputFormat {
    @Override
    public RecordWriter createWriter(Configuration conf) throws DataVecException {
        String outputPath = conf.get(OutputFormat.OUTPUT_PATH, ".");
        return new LineRecordWriter();
    }
}
