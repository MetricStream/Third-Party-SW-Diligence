/* Copyright  2000-2015, MetricStream, Inc. All rights reserved.
 * 
 */
package com.metricstream.labs.tpswd.io;

import java.util.Date;

import org.aldan3.model.ProcessException;

import com.beegman.webbee.block.Form;
import com.metricstream.labs.tpswd.model.Model;
import com.metricstream.labs.tpswd.model.software;
import com.metricstream.labs.tpswd.model.util.DODU;

public class Swform extends Form<software, Model> {

	@Override
	protected software getFormModel() {
		return new software(getAppModel());
	}

	@Override
	protected void loadModel(software sw) {
		try {
			log("Load %d", null, sw.id);
			getAppModel().getDOService().getObjectLike(new DODU<software>(sw, "", "id"));
		} catch (ProcessException e) {
			log("", e);
		}
	}

	@Override
	protected Object storeModel(software sw) {
		String excl = "requester_cn,requested_on";
		if (sw.id <= 0) {
			sw.requester_cn = getSessionAttribute("stationary", "unsigend");
			sw.requested_on = new Date();
			excl = "";
		}
		DODU<software> swdo = new DODU<>(sw, excl, "id");
		try {
			getAppModel().getDOService().addObject(swdo, "id", sw.id <= 0 ? null : swdo);
			log("added %d", null, sw.id);
			navigation = "Software?filter=" + sw.name;
		} catch (ProcessException e) {
			log("", e);
			return e;
		}
		return null;
	}

	@Override
	public boolean isPublic() {
		//return true;
		return super.isPublic();
	}

}
