/* Copyright  2000-2015, MetricStream, Inc. All rights reserved.
 * Author: Dmitriy Rogatkin (mailto:Dmitriy@metricstream.com)
 * Created: 08/26/15
 */
package com.metricstream.labs.tpswd.model;

import java.io.File;
import java.net.URL;
import java.util.Date;

import org.aldan3.annot.DBField;
import org.aldan3.annot.DataRelation;
import org.aldan3.annot.FormField;
import org.aldan3.annot.FormField.FieldType;

import com.beegman.webbee.util.GenericResourceOptions;
import com.beegman.webbee.util.SimpleCoordinator;
import com.metricstream.labs.tpswd.model.util.FileConv;
import com.metricstream.labs.tpswd.model.util.StatusConv;
import com.metricstream.labs.tpswd.model.util.URLConv;

@DataRelation
public class software extends SimpleCoordinator<Model> {

	public enum Status {requested, pending, approved, retired, rejected};
	
	public software(Model model) {
		super(model);		
	}
	
	@DBField(key=true, auto=1)
	@FormField(presentType=FieldType.Hidden)
	public long id;

	@DBField(size=200)
	@FormField
	public String name;
	
	@DBField(size=100)
	@FormField
	public String vendor;
	
	@DBField(size=80)
	@FormField(presentFiller=GenericResourceOptions.class)
	public String license;
	
	@DBField(size=40)
	public String version;
	
	@DBField(size=40)
	public String best_version;
	
	@DBField(type="varchar(200)", size=200, converter=URLConv.class)
	@FormField(presentSize=60, converter=URLConv.class)
	public URL website;
	
	@DBField(size=20,converter=StatusConv.class)
	@FormField(presentFiller=GenericResourceOptions.class, converter=StatusConv.class)
	public Status status;
	
	public String[] modules;
	
	@DBField(type="varchar(256)",converter=FileConv.class)
	@FormField(presentType=FieldType.File,fillQuery = "Attach",converter=FileConv.class)
	public File research_doc;
	
	@DBField(size=120)
	@FormField(presentType=FieldType.Readonly)
	public String  requester_cn;
	
	@DBField
	@FormField(presentType=FieldType.Readonly)
	public Date requested_on;
	
	public Date effective_on;

}
