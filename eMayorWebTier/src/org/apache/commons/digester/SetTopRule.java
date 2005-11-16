/* $Id: SetTopRule.java,v 1.1 2005/11/16 10:51:49 emayor Exp $
 *
 * Copyright 2001-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 


package org.apache.commons.digester;


import org.apache.commons.beanutils.MethodUtils;


/**
 * <p>Rule implementation that calls a "set parent" method on the top (child)
 * object, passing the (top-1) (parent) object as an argument.</p>
 *
 * <p>This rule now supports more flexible method matching by default.
 * It is possible that this may break (some) code 
 * written against release 1.1.1 or earlier.
 * See {@link #isExactMatch()} for more details.</p>
 */

public class SetTopRule extends Rule {


    // ----------------------------------------------------------- Constructors


    /**
     * Construct a "set parent" rule with the specified method name.  The
     * "set parent" method's argument type is assumed to be the class of the
     * parent object.
     *
     * @param digester The associated Digester
     * @param methodName Method name of the "set parent" method to call
     *
     * @deprecated The digester instance is now set in the {@link Digester#addRule} method. 
     * Use {@link #SetTopRule(String methodName)} instead.
     */
    public SetTopRule(Digester digester, String methodName) {

        this(methodName);

    }


    /**
     * Construct a "set parent" rule with the specified method name.
     *
     * @param digester The associated Digester
     * @param methodName Method name of the "set parent" method to call
     * @param paramType Java class of the "set parent" method's argument
     *  (if you wish to use a primitive type, specify the corresonding
     *  Java wrapper class instead, such as <code>java.lang.Boolean</code>
     *  for a <code>boolean</code> parameter)
     *
     * @deprecated The digester instance is now set in the {@link Digester#addRule} method. 
     * Use {@link #SetTopRule(String methodName, String paramType)} instead.
     */
    public SetTopRule(Digester digester, String methodName,
                      String paramType) {

        this(methodName, paramType);

    }

    /**
     * Construct a "set parent" rule with the specified method name.  The
     * "set parent" method's argument type is assumed to be the class of the
     * parent object.
     *
     * @param methodName Method name of the "set parent" method to call
     */
    public SetTopRule(String methodName) {

        this(methodName, null);

    }


    /**
     * Construct a "set parent" rule with the specified method name.
     *
     * @param methodName Method name of the "set parent" method to call
     * @param paramType Java class of the "set parent" method's argument
     *  (if you wish to use a primitive type, specify the corresonding
     *  Java wrapper class instead, such as <code>java.lang.Boolean</code>
     *  for a <code>boolean</code> parameter)
     */
    public SetTopRule(String methodName,
                      String paramType) {

        this.methodName = methodName;
        this.paramType = paramType;

    }


    // ----------------------------------------------------- Instance Variables


    /**
     * The method name to call on the child object.
     */
    protected String methodName = null;


    /**
     * The Java class name of the parameter type expected by the method.
     */
    protected String paramType = null;
    
    /**
     * Should we use exact matching. Default is no.
     */
    protected boolean useExactMatch = false;


    // --------------------------------------------------------- Public Methods

    /**
     * <p>Is exact matching being used.</p>
     *
     * <p>This rule uses <code>org.apache.commons.beanutils.MethodUtils</code> 
     * to introspect the relevent objects so that the right method can be called.
     * Originally, <code>MethodUtils.invokeExactMethod</code> was used.
     * This matches methods very strictly 
     * and so may not find a matching method when one exists.
     * This is still the behaviour when exact matching is enabled.</p>
     *
     * <p>When exact matching is disabled, <code>MethodUtils.invokeMethod</code> is used.
     * This method finds more methods but is less precise when there are several methods 
     * with correct signatures.
     * So, if you want to choose an exact signature you might need to enable this property.</p>
     *
     * <p>The default setting is to disable exact matches.</p>
     *
     * @return true iff exact matching is enabled
     * @since Digester Release 1.1.1
     */
    public boolean isExactMatch() {
    
        return useExactMatch;
    }
    
    /**
     * <p>Set whether exact matching is enabled.</p>
     *
     * <p>See {@link #isExactMatch()}.</p>
     *
     * @param useExactMatch should this rule use exact method matching
     * @since Digester Release 1.1.1
     */
    public void setExactMatch(boolean useExactMatch) {

        this.useExactMatch = useExactMatch;
    }
    
    /**
     * Process the end of this element.
     */
    public void end() throws Exception {

        // Identify the objects to be used
        Object child = digester.peek(0);
        Object parent = digester.peek(1);
        
        if (digester.log.isDebugEnabled()) {
            if (child == null) {
                digester.log.debug("[SetTopRule]{" + digester.match +
                        "} Call [NULL CHILD]." +
                        methodName + "(" + parent + ")");
            } else {
                digester.log.debug("[SetTopRule]{" + digester.match +
                        "} Call " + child.getClass().getName() + "." +
                        methodName + "(" + parent + ")");
            }
        }

        // Call the specified method
        Class paramTypes[] = new Class[1];
        if (paramType != null) {
            paramTypes[0] =
                    digester.getClassLoader().loadClass(paramType);
        } else {
            paramTypes[0] = parent.getClass();
        }

        if (useExactMatch) {
        
            MethodUtils.invokeExactMethod(child, methodName,
                new Object[]{ parent }, paramTypes);
                
        } else {
        
            MethodUtils.invokeMethod(child, methodName,
                new Object[]{ parent }, paramTypes);
        
        }
    }


    /**
     * Render a printable version of this Rule.
     */
    public String toString() {

        StringBuffer sb = new StringBuffer("SetTopRule[");
        sb.append("methodName=");
        sb.append(methodName);
        sb.append(", paramType=");
        sb.append(paramType);
        sb.append("]");
        return (sb.toString());

    }


}
