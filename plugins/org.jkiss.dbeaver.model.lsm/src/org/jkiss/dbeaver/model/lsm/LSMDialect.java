/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
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
package org.jkiss.dbeaver.model.lsm;

import org.bouncycastle.pqc.crypto.lms.LMSException;
import org.jkiss.dbeaver.model.lsm.mapping.AbstractSyntaxNode;

import java.util.Collection;
import java.util.concurrent.Future;


public interface LSMDialect {
    
    Collection<LSMAnalysisCase<? extends LSMElement, ? extends AbstractSyntaxNode>> getSupportedCases();

    <T extends LSMElement> LSMAnalysisCase<T, ? extends AbstractSyntaxNode> findAnalysisCase(Class<T> expectedModelType) throws LMSException;
    
    <T extends LSMElement> Future<LSMAnalysis<T>> prepareAnalysis(
        LSMSource source,
        LSMAnalysisCase<T, ? extends AbstractSyntaxNode> analysisCase
    );
    
}