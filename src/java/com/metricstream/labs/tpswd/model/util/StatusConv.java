package com.metricstream.labs.tpswd.model.util;

import java.util.Locale;
import java.util.TimeZone;

import org.aldan3.data.util.FieldConverter;

import com.metricstream.labs.tpswd.model.software;
import com.metricstream.labs.tpswd.model.software.Status;

public class StatusConv implements FieldConverter<software.Status> {

	@Override
	public Status convert(String s, TimeZone tz, Locale l) {
		if (s== null || s.isEmpty())
		return null;
		return Status.valueOf(s);
		}

	@Override
	public String deConvert(Status e, TimeZone tz, Locale l) {
		if (e == null)
			return Status.requested.name();
		return e.name();
	}

}
