/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
 * Copyright (C) 2017-2018 Alexander Fedorov (alexander.fedorov@jkiss.org)
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

package org.jkiss.dbeaver.debug.core.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.IBreakpointManagerListener;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.jkiss.dbeaver.debug.DBGController;
import org.jkiss.dbeaver.debug.DBGSession;

public interface IDatabaseDebugTarget extends IDebugTarget, IDebugEventSetListener, IBreakpointManagerListener {

    DBGController getController();

    DBGSession getSession();

    void connect(IProgressMonitor monitor) throws CoreException;

    boolean canStepInto();

    boolean canStepOver();

    boolean canStepReturn();

    void stepInto() throws DebugException;

    void stepOver() throws DebugException;

    void stepReturn() throws DebugException;

}
