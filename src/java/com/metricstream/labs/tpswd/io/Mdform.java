package com.metricstream.labs.tpswd.io;

import org.aldan3.model.ProcessException;

import com.beegman.webbee.block.Form;
import com.metricstream.labs.tpswd.model.Model;
import com.metricstream.labs.tpswd.model.module;
import com.metricstream.labs.tpswd.model.util.DODU;

public class Mdform extends Form<module, Model> {

	@Override
	protected module getFormModel() {
		return new module(getAppModel());
	}

	@Override
	protected void loadModel(module md) {
		try {
			getAppModel().getDOService().getObjectLike(new DODU<module>(md, "", "id"));
		} catch (ProcessException e) {
			log("", e);
		}
	}

	@Override
	protected Object storeModel(module md) {
		DODU<module> mddo = new DODU<>(md, "", "id");
		try {
			getAppModel().getDOService().addObject(mddo, "id", md.id <= 0 ? null : mddo);
			log("c/u %d", null, md.id);
			navigation = "Software?filter=";
		} catch (ProcessException e) {
			log("", e);
			return e;
		}
		return null;
	}

}
