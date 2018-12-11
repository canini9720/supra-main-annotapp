package com.supra.annot.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supra.annot.model.ApplicationPropertyEntity;
import com.supra.annot.repository.ApplicationPropertyRepository;



@Component("ApplicationProperties")
public class ApplicationProperties {

	public static Map<String, String> props = new HashMap<String, String>();
	
	@Autowired ApplicationPropertyRepository repository;
	
	@PostConstruct
	public void loadProperties()
	{
		List<ApplicationPropertyEntity> list = repository.findAll();
		if(list!=null && list.size()>0)
		{
			for(int i=0; i<list.size(); i++)
			{
				props.put(list.get(i).getName().trim(), list.get(i).getValue().trim());
			}
		}
	}
}
