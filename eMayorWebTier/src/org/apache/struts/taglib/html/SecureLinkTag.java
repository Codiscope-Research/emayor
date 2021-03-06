/*
 * $Header: /home/xubuntu/berlios_backup/github/tmp-cvs/emayor/Repository/eMayorWebTier/src/org/apache/struts/taglib/html/SecureLinkTag.java,v 1.1 2005/11/16 10:51:48 emayor Exp $
 * $Revision: 1.1 $
 * $Date: 2005/11/16 10:51:48 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Struts", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

/**
 * Defines the link tag of the sslext tag library
 * @author Steve Ditlinger
 */

package org.apache.struts.taglib.html;

import org.apache.struts.taglib.logic.IterateTag;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.SecureRequestUtils;

import javax.servlet.jsp.JspException;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;



public class SecureLinkTag extends LinkTag 
{

  /**
   * Return the complete URL to which this hyperlink will direct the user.
   *
   * @exception JspException if an exception is thrown calculating the value
   */
  protected String calculateURL() throws JspException 
  {
    //System.out.println("SecureLinkTag.calculateURL() starts.");

    TagUtils tagUtils = TagUtils.getInstance();

    // Identify the parameters we will add to the completed URL
    Map params = tagUtils.computeParameters
            (pageContext, paramId, paramName, paramProperty, paramScope,
             name, property, scope, transaction);

    // if "indexed=true", add "index=x" parameter to query string
    // since 1.1
    if (indexed) {

      // look for outer iterate tag
      IterateTag iterateTag =
              (IterateTag) findAncestorWithClass(this, IterateTag.class);
      if (iterateTag == null) {
        // This tag should only be nested in an iterate tag
        // If it's not, throw exception
        JspException e = new JspException
                (messages.getMessage("indexed.noEnclosingIterate"));
        tagUtils.saveException(pageContext, e);
        throw e;
      }

      //calculate index, and add as a parameter
      if (params == null) {
        params = new HashMap();             //create new HashMap if no other params
      }
      if (indexId != null) {
        params.put(indexId, Integer.toString(iterateTag.getIndex()));
      } else {
        params.put("index", Integer.toString(iterateTag.getIndex()));
      }
    }

    
    //System.out.println("SecureLinkTag.calculateURL() calling computeURL...");
   
    
    String url = null;
    try 
    {
      url = SecureRequestUtils.computeURL( pageContext, forward, href,
                                           page, action, module, params, anchor,
                                           false );
    } 
    catch (MalformedURLException e) 
    {
      System.out.println("SecureLinkTag.calculateURL() -> Exception: ");
      e.printStackTrace();
      
      tagUtils.saveException(pageContext, e);
      throw new JspException
              (messages.getMessage("rewrite.url", e.toString()));
    }
    
    //System.out.println("SecureLinkTag.calculateURL() ends.");

    return (url);
  }

}
