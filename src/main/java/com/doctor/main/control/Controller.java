package com.doctor.main.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.main.exception.EmptyData;
import com.doctor.main.exception.WrongId;
import com.doctor.main.model.Model;

@RestController
public class Controller {
	
	@Autowired
	private com.doctor.main.service.Service serv;
	
	/*Below data gives out the list of all data for url{doc-data}*/
	@GetMapping("/doc-data")
	public ResponseEntity<Object> getFindAll() throws Exception
	{
		try {
			return new ResponseEntity<>(serv.getAll() ,HttpStatus.FOUND);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	/*Below data gives out one data for url{doc-data/{ID}}*/
	@GetMapping("/doc-data/{Id}")
	public ResponseEntity<Object> getOneData(@PathVariable int Id) throws Exception
	{
		try {
			return new ResponseEntity<>(serv.oneData(Id) ,HttpStatus.FOUND);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	/*Below data gives out sorting data for url{doc-data/ascending}*/
	@GetMapping("/doc-data/ascending")
	public ResponseEntity<Object> getNameWise() throws Exception
	{
		try {
			return new ResponseEntity<>(serv.sortingData() ,HttpStatus.ACCEPTED);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	/*Below data takes in an JSON object and add it into the data base for url{doc-data}*/
	@PutMapping("/doc-data")
	public ResponseEntity<Object> getUpdateModel(@RequestBody Model mdd) throws Exception
	{
		try {
			serv.updateModel(mdd);
			return new ResponseEntity<>(serv.oneData(mdd.getId()) ,HttpStatus.ACCEPTED);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	/*Below data takes 2 input Id and salary  and update the salary of the ID and returns the data for this url{/doc-data/{Id}/{Sal}}*/
	@PutMapping("/doc-data/{Id}/{Sal}")
	public ResponseEntity<Object> getUpdateModel(@PathVariable int Id , @PathVariable int Sal) throws Exception
	{
		try {
			serv.updateModel(Id, Sal);
			return new ResponseEntity<>(serv.oneData(Id) ,HttpStatus.FOUND);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*Below data takes in an JSON object and add it into the data base for url{doc-data}*/
	@PostMapping("/doc-data")
	public ResponseEntity<Object> getOneSaveModel(@RequestBody Model mdd) throws Exception
	{
		try {
			serv.oneSave(mdd);
			return new ResponseEntity<>("Data added into Data Base",HttpStatus.CREATED);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	/*Below data takes in an Id and delete the data from the data base and returns a response for this url{doc-data/{Id}}*/
	@DeleteMapping("/doc-data/{Id}")
	public ResponseEntity<Object> getOneSaveModel(@PathVariable int Id) throws Exception
	{
		try {
			serv.deleteOne(Id);
			return new ResponseEntity<>("Data deleted from Data Base",HttpStatus.ACCEPTED);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
}
