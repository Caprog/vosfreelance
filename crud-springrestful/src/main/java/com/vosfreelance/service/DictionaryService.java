package com.vosfreelance.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author Caprog
 */
@Service
public class DictionaryService{

	private Map<String,String> dictionary;
	
	public DictionaryService() {
		this.dictionary = new HashMap<>();
	}	
	
	public void add(String key, String value) {
		this.dictionary.put(key, value);
	}

	public void update(String key, String value) {
		this.dictionary.put(key, value);
	}
	
	public String get(String key) {
		return this.dictionary.get(key);
	}
	
	public Map<String,String> getAll() {
		return dictionary;
	}
	
	public void remove(String key) {
		this.dictionary.remove(key);
	}
}
