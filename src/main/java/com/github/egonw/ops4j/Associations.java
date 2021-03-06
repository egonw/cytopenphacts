/* Copyright (C) 2014  Egon Willighagen <egonw@users.sf.net>
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * All we ask is that proper credit is given for our work, which includes
 * - but is not limited to - adding the above copyright notice to the beginning
 * of your source code files, and to any copyright notice that you may distribute
 * with programs based on this work.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package com.github.egonw.ops4j;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class Associations extends AbstractOPS4JClient {

	private Associations(String server, String appID, String appKey) throws MalformedURLException {
		super(server, appID, appKey);
	}

	public static Associations getInstance(String server, String apiID, String appKey) throws MalformedURLException {
		return new Associations(server, apiID, appKey);
	}

	public static Associations getInstance(Server server) throws MalformedURLException {
		return new Associations(server.getServer(), server.getAppID(), server.getAppKey());
	}

	public String forTargetCount(String uri, Object... objects) throws IOException {
		Map<String,String> params = new HashMap<String,String>();
		params.put("uri", uri);
		return runRequest(server + "disease/assoc/byTarget/count", params, objects);
	}

	public String forTargetList(String uri, int page, int pageSize, Object... objects) throws IOException {
		Map<String,String> params = new HashMap<String,String>();
		params.put("uri", uri);
		params.put("_page", Integer.toString(page));
		params.put("_pageSize", Integer.toString(pageSize));
		return runRequest(server + "disease/assoc/byTarget", params, objects);
	}

	public String forDiseaseCount(String uri, Object... objects) throws IOException {
		Map<String,String> params = new HashMap<String,String>();
		params.put("uri", uri);
		return runRequest(server + "disease/assoc/byDisease/count", params, objects);
	}

	public String forDiseaseList(String uri, int page, int pageSize, Object... objects) throws IOException {
		Map<String,String> params = new HashMap<String,String>();
		params.put("uri", uri);
		params.put("_page", Integer.toString(page));
		params.put("_pageSize", Integer.toString(pageSize));
		return runRequest(server + "disease/assoc/byDisease", params, objects);
	}
}
