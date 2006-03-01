/**
*Copyright 2005 blueCubs.com
*
*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
*
*************************************************************
* This project supports the blueCubs vision of giving back
* to the community in exchange for free software!
* More information on: http://www.bluecubs.org
*************************************************************
*
* Name:            XincoIndexHTML
*
* Description:     indexing text files 
*
* Original Author: Alexander Manes
* Date:            2005/02/05
*
* Modifications:
* 
* Who?             When?             What?
* -                -                 -
*
*************************************************************
*/

package com.bluecubs.xinco.index.filetypes;

import java.io.File;
import java.io.Reader;
import org.apache.lucene.demo.html.HTMLParser;

public class XincoIndexHTML implements XincoIndexFileType {

	public XincoIndexHTML() {
		super();
	}

	public Reader getFileContentReader(File f) {
		Reader reader = null;
		try {
		    HTMLParser parser = new HTMLParser(f);
			reader = parser.getReader();
		} catch (Exception fe) {
			reader = null;
		}
		return reader;
	}

	public String getFileContentString(File f) {
		return null;
	}

}
