/* $Id: WithDefaultsRulesWrapper.java,v 1.1 2005/11/16 10:51:49 emayor Exp $
 *
 * Copyright 2003-2004 The Apache Software Foundation.
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p><code>Rules</code> <em>Decorator</em> that returns default rules 
 * when no matches are returned by the wrapped implementation.</p>
 *
 * <p>This allows default <code>Rule</code> instances to be added to any 
 * existing <code>Rules</code> implementation. These default <code>Rule</code> 
 * instances will be returned for any match for which the wrapped 
 * implementation does not return any matches.</p>
 * <p> For example,
 * <pre>
 *   Rule alpha;
 *   ...
 *   WithDefaultsRulesWrapper rules = new WithDefaultsRulesWrapper(new BaseRules());
 *   rules.addDefault(alpha);
 *   ...
 *   digester.setRules(rules);
 *   ...
 * </pre>
 * when a pattern does not match any other rule, then rule alpha will be called.
 * </p>
 * <p><code>WithDefaultsRulesWrapper</code> follows the <em>Decorator</em> pattern.</p>
 *
 * @since 1.6
 */

public class WithDefaultsRulesWrapper implements Rules {

    // --------------------------------------------------------- Fields
    
    /** The Rules implementation that this class wraps. */
    private Rules wrappedRules;
    /** Rules to be fired when the wrapped implementations returns none. */
    private List defaultRules = new ArrayList();
    /** All rules (preserves order in which they were originally added) */
    private List allRules = new ArrayList();
    
    // --------------------------------------------------------- Constructor
    
    /** 
     * Base constructor.
     *
     * @param wrappedRules the wrapped <code>Rules</code> implementation, not null
     * @throws IllegalArgumentException when <code>wrappedRules</code> is null
     */
    public WithDefaultsRulesWrapper(Rules wrappedRules) {
        if (wrappedRules == null) {
            throw new IllegalArgumentException("Wrapped rules must not be null");
        }
        this.wrappedRules = wrappedRules;
    }

    // --------------------------------------------------------- Properties
    
    /** Gets digester using these Rules */
    public Digester getDigester() {
        return wrappedRules.getDigester();
    }
    
    /** Sets digeseter using these Rules */
    public void setDigester(Digester digester) {
        wrappedRules.setDigester(digester);
        Iterator it = defaultRules.iterator();
        while (it.hasNext()) {
            Rule rule = (Rule) it.next();
            rule.setDigester(digester);
        }
    }
    
    /** Gets namespace to apply to Rule's added */
    public String getNamespaceURI() {
        return wrappedRules.getNamespaceURI();
    }
    
    /** Sets namespace to apply to Rule's added subsequently */
    public void setNamespaceURI(String namespaceURI) {
        wrappedRules.setNamespaceURI(namespaceURI);
    }
    
    /** Gets Rule's which will be fired when the wrapped implementation returns no matches */
    public List getDefaults() {
        return defaultRules;
    }
    
    // --------------------------------------------------------- Public Methods
    
    public List match(String pattern) {
        return match("", pattern);
    }
    
    /**
     * Return list of rules matching given pattern.
     * If wrapped implementation returns any matches return those.
     * Otherwise, return default matches.
     */
    public List match(String namespaceURI, String pattern) {
        List matches = wrappedRules.match(namespaceURI, pattern);
        if (matches ==  null || matches.isEmpty()) {
            // a little bit of defensive programming
            return new ArrayList(defaultRules);
        }
        // otherwise
        return matches;
    }
    
    /** Adds a rule to be fired when wrapped implementation returns no matches */
    public void addDefault(Rule rule) {
        // set up rule
        if (wrappedRules.getDigester() != null) {
            rule.setDigester(wrappedRules.getDigester());
        }
        
        if (wrappedRules.getNamespaceURI() != null) {
            rule.setNamespaceURI(wrappedRules.getNamespaceURI());
        }
        
        defaultRules.add(rule);
        allRules.add(rule);
    }
    
    /** Gets all rules */
    public List rules() {
        return allRules;
    }
    
    /** Clears all Rule's */
    public void clear() {
        wrappedRules.clear();
        allRules.clear();
        defaultRules.clear();
    }
    
    /** 
     * Adds a Rule to be fired on given pattern.
     * Pattern matching is delegated to wrapped implementation.
     */
    public void add(String pattern, Rule rule) {
        wrappedRules.add(pattern, rule);
        allRules.add(rule);
    }
}
