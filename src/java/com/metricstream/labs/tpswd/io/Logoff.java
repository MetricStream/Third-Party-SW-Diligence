package com.metricstream.labs.tpswd.io;

import com.beegman.webbee.block.Signoff;

public class Logoff extends Signoff {

	@Override
	protected String autoRedirect() {
		return req.getContextPath();
	}
	
	

}
