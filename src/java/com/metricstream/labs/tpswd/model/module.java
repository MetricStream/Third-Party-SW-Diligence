package com.metricstream.labs.tpswd.model;

import java.util.Date;

import org.aldan3.annot.DBField;
import org.aldan3.annot.DataRelation;
import org.aldan3.annot.FormField;
import org.aldan3.annot.FormField.FieldType;

import com.beegman.webbee.util.SimpleCoordinator;

@DataRelation
public class module extends SimpleCoordinator<Model> {

	public module(Model m) {
		super(m);
	}

	@DBField(key = true, auto = 1)
	@FormField(presentType = FieldType.Hidden)
	public int id;

	@DBField(size = 200)
	@FormField()
	public String name;

	@DBField(size = 4000)
	@FormField(presentSize = 68, presentRows = 6)
	public String description;

	@DBField
	public Date end_date;

}
