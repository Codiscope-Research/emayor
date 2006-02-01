/*
 * $Id: IterateTei.java,v 1.1 2006/02/01 15:32:58 emayor Exp $ 
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
package org.apache.struts.taglib.logic;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * Implementation of <code>TagExtraInfo</code> for the <b>iterate</b>
 * tag, identifying the scripting object(s) to be made visible.
 *
 * @version $Rev: 54929 $ $Date: 2006/02/01 15:32:58 $
 */
public class IterateTei extends TagExtraInfo {

  /**
   * Return information about the scripting variables to be created.
   */
  public VariableInfo[] getVariableInfo(TagData data) {

    // prime this array with the maximum potential variables.
    // will be arraycopy'd out to the final array based on results.
    VariableInfo[] variables = new VariableInfo[2];

    // counter for matched results.
    int counter = 0;

    /* id : object of the current iteration */
    String id = data.getAttributeString("id");
    String type = data.getAttributeString("type");
    if (id != null) {
      if (type == null) {
        type = "java.lang.Object";
      }
      variables[counter++] = new VariableInfo(data.getAttributeString("id"),
                                              type, true,
                                              VariableInfo.NESTED);
    }

    /* indexId : number value of the current iteration */
    String indexId = data.getAttributeString("indexId");
    if (indexId != null) {
      variables[counter++] = new VariableInfo(indexId, "java.lang.Integer",
                                              true, VariableInfo.NESTED);
    }

    /* create returning array, and copy results */
    VariableInfo[] result;
    if (counter > 0) {
      result = new VariableInfo[counter];
      System.arraycopy(variables, 0, result, 0, counter);
    } else {
      result = new VariableInfo[0];
    }
    return result;
  }
}
