package com.metricstream.labs.tpswd.model.util;

import java.util.Locale;
import java.util.TimeZone;

import org.aldan3.data.util.FieldConverter;
import org.aldan3.util.DataConv;

public class ArrayToStrConv implements FieldConverter<String[]> {

	@Override
	public String[] convert(String s, TimeZone tz, Locale l) {
		if (s != null)
			return s.split(",");
		return null;
	}

	@Override
	public String deConvert(String[] a, TimeZone tz, Locale l) {
		if (a != null && a.length > 0)
			return DataConv.arrayToString((Object)a, ',');
		return null;
	}

}
