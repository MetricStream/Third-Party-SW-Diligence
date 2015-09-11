/* Copyright  2000-2015, MetricStream, Inc. All rights reserved.
 * 
 */
package com.metricstream.labs.tpswd.io;

import com.beegman.webbee.block.Systemsetup;
import com.beegman.webbee.model.Setup;
import com.metricstream.labs.tpswd.model.Model;
import com.metricstream.labs.tpswd.model.software;

public class System extends Systemsetup<Setup, Model> {

	@Override
	protected String getDefaultModelPackage() {
		return software.class.getPackage().getName();
	}

	@Override
	public boolean isPublic() {
		return true;
		//return super.isPublic();
	}

	
}
