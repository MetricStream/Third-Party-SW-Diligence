/* Copyright  2000-2015, MetricStream, Inc. All rights reserved.
 * 
 */
package com.metricstream.labs.tpswd.io;

import org.aldan3.annot.DataRelation;
import org.aldan3.model.DataObject;

import com.beegman.webbee.block.SqlTabular;
import com.metricstream.labs.tpswd.model.Model;
@DataRelation(query="select ID, NAME, VENDOR, STATUS, REQUESTER_CN, WEBSITE from software where NAME like ':filter%' order by name", keys={"filter"})
public class Software extends SqlTabular<DataObject, Model> {
	@Override
	public boolean isPublic() {
		//return true;
		return super.isPublic();
	}
}
