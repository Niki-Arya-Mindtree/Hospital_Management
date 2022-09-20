package com.doctor.main.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.doctor.main.docinterface.DocAccSalary;
import com.doctor.main.model.Model;

public class DescSalary implements DocAccSalary , Comparator<Model> {
	

	@Override
	public List<Model> docSortSalary(List<Model> lmd) {
		Collections.sort(lmd,new DescSalary());
		return lmd;
	}

	/* The comparator sorting the data in ascending order for salary and comparing the name if they are same and in ascending order*/
	@Override
	public int compare(Model o1, Model o2) {
		if(o1.getSalary()==o2.getSalary())
			return o1.getName().compareToIgnoreCase(o2.getName());
		else if(o1.getSalary()<o2.getSalary())
			return 1;
		else
			return -1;
	}

}
