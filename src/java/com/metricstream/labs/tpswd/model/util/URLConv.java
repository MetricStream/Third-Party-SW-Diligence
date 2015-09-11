/* Copyright  2000-2015, MetricStream, Inc. All rights reserved.
 * 
 */
package com.metricstream.labs.tpswd.model.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.TimeZone;

import org.aldan3.data.util.FieldConverter;

public class URLConv implements FieldConverter<URL> {

	@Override
	public URL convert(String s, TimeZone tz, Locale l) {
		if (!s.startsWith("http"))
			s = "http://"+s;
		try {
			return new URL(s);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deConvert(URL u, TimeZone tz, Locale l) {
		if (u != null)
			return u.toString();
		return null;
	}

}
