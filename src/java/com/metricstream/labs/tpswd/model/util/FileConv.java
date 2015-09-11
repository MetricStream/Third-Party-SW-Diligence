package com.metricstream.labs.tpswd.model.util;

import java.io.File;
import java.util.Locale;
import java.util.TimeZone;

import org.aldan3.data.util.FieldConverter;

public class FileConv implements FieldConverter<File> {

	public FileConv() {
		this(null);
	}
	
	public FileConv(Object m) {
		System.err.printf("Initialized with %s%n", m);
	}

	@Override
	public File convert(String s, TimeZone tz, Locale l) {
		if (s == null)
			return null;
		return new File(s);
	}

	@Override
	public String deConvert(File f, TimeZone tz, Locale l) {
		if (f == null)
			return null;
		return f.getName();
	}

}
