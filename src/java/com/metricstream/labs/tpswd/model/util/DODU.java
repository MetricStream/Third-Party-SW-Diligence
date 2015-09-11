/* Copyright  2000-2015, MetricStream, Inc. All rights reserved.
 * 
 */
package com.metricstream.labs.tpswd.model.util;

import org.aldan3.data.DODelegator;

public class DODU<T> extends DODelegator<T> {

	public DODU(T obj, String excl, String keys) {
		super(obj, null, excl, keys);
	}
	
	@Override
	protected String normilizeFieldName(String fieldName) {
		return fieldName.toUpperCase();
	}
}
