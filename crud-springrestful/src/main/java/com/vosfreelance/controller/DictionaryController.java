package com.vosfreelance.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vosfreelance.dto.DictionaryDTO;
import com.vosfreelance.service.DictionaryService;

/**
 * @author Caprog
 */
@Controller
public class DictionaryController{
	
	@Resource
	private DictionaryService dictionaryService;
	    
    @RequestMapping(value = "/dictionary/", method = RequestMethod.GET)
    public ResponseEntity<Map<String,String>> getAll() {
    	return new ResponseEntity<Map<String,String>>(this.dictionaryService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/dictionary/{key}", method = RequestMethod.GET)
    public ResponseEntity<String> get(@PathVariable("key") String key){
    	return new ResponseEntity<String>(this.dictionaryService.get(key), HttpStatus.OK);
    }
   
    @RequestMapping(value = "/dictionary/", method = RequestMethod.POST)
    public  ResponseEntity<Void> create(@RequestBody DictionaryDTO dictionaryDTO){
    	this.dictionaryService.add(dictionaryDTO.getKey(), dictionaryDTO.getValue());
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/dictionary/", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody DictionaryDTO dictionaryDTO){
    	this.dictionaryService.update(dictionaryDTO.getKey(), dictionaryDTO.getValue());
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/dictionary/{key}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("key") String key){
    	this.dictionaryService.remove(key);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
}