package com.doctor.main.docinterface;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.doctor.main.exception.EmptyData;
import com.doctor.main.exception.WrongId;
import com.doctor.main.model.Model;

public interface DocMethodInterface {
	public List<Model> getAll() throws EmptyData;
	public Model oneData(int Id) throws EmptyData;
	public void updateModel(Model md) throws WrongId;
	public void oneSave(Model md) throws WrongId;
	public void updateModel(int Id , int Sal) throws WrongId;
	public List<Model> sortingData() throws EmptyData;
	public void deleteOne(@PathVariable int Id) throws WrongId;
}
