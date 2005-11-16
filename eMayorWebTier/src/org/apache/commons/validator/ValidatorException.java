/*
 * $Header: /home/xubuntu/berlios_backup/github/tmp-cvs/emayor/Repository/eMayorWebTier/src/org/apache/commons/validator/ValidatorException.java,v 1.1 2005/11/16 10:51:48 emayor Exp $
 * $Revision: 1.1 $
 * $Date: 2005/11/16 10:51:48 $
 *
 * ====================================================================
 * Copyright 2001-2004 The Apache Software Foundation
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

package org.apache.commons.validator;

/**
 * The base exception for the Validator Framework.  All other 
 * <code>Exception</code>s thrown during calls to 
 * <code>Validator.validate()</code> are considered errors.
 */
public class ValidatorException extends Exception {

    /**
     * Constructs an Exception with no specified detail message.
     */
    public ValidatorException() {
        super();
    }

    /**
     * Constructs an Exception with the specified detail message.
     *
     * @param    message The error message.
     */
    public ValidatorException(String message) {
        super(message);
    }

}