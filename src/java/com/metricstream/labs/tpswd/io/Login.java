package com.metricstream.labs.tpswd.io;

import javax.servlet.http.HttpSession;

import com.beegman.webbee.block.Signon;
import com.beegman.webbee.model.Auth;
import com.metricstream.labs.tpswd.model.Model;

public class Login extends Signon<Model> {
	@Override
	protected boolean initSession(Auth auth) {
		boolean result = super.initSession(auth);
		if (result) {
			HttpSession session = req.getSession(false);
			if (session != null) {
				session.setAttribute("stationary", auth.get(auth.getFullUserNameFieldName()));
				session.setAttribute("email", auth.get("mail"));
			}
		}
		return result;
	}
	
	@Override
	protected String getSubmitPage() {
		return "Software";
	}


}
