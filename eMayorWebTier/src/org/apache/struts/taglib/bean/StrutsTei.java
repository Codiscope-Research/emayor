/*
 * $Id: StrutsTei.java,v 1.1 2005/11/16 10:51:48 emayor Exp $ 
 *
 * Copyright 1999-2004 The Apache Software Foundation.
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


package org.apache.struts.taglib.bean;


import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;


/**
 * Implementation of <code>TagExtraInfo</code> for the <b>struts</b>
 * tag, identifying the scripting object(s) to be made visible.
 *
 * @version $Rev: 54929 $ $Date: 2005/11/16 10:51:48 $
 */

public class StrutsTei extends TagExtraInfo {


    /**
     * Return information about the scripting variables to be created.
     */
    public VariableInfo[] getVariableInfo(TagData data) {

        String type = null;
        if (data.getAttribute("formBean") != null)
            type = "org.apache.struts.action.ActionFormBean";
        else if (data.getAttribute("forward") != null)
            type = "org.apache.struts.action.ActionForward";
        else if (data.getAttribute("mapping") != null)
            type = "org.apache.struts.action.ActionMapping";
        else
            type = "java.lang.Object";

	return new VariableInfo[] {
	  new VariableInfo(data.getAttributeString("id"),
	                   type,
	                   true,
	                   VariableInfo.AT_BEGIN)
	};

    }


}
