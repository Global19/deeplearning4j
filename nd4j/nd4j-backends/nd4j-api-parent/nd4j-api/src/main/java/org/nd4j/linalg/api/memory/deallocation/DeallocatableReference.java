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

package org.nd4j.linalg.api.memory.deallocation;

import lombok.Data;
import org.nd4j.linalg.api.memory.Deallocatable;
import org.nd4j.linalg.api.memory.Deallocator;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * This method implements WeakReference for Deallocatable objects
 * @author raver119@gmail.com
 */
@Data
public class DeallocatableReference extends WeakReference<Deallocatable> {
    private String id;
    private Deallocator deallocator;

    public DeallocatableReference(Deallocatable referent, ReferenceQueue<? super Deallocatable> q) {
        super(referent, q);

        this.id = referent.getUniqueId();
        this.deallocator = referent.deallocator();
    }
}
