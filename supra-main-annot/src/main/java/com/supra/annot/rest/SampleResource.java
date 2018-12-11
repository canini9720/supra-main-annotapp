package com.supra.annot.rest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;



@RestController
@RequestMapping("/sample")
public class SampleResource {

    private static final Logger logger = Logger.getLogger(SampleResource.class);

    @RequestMapping(method = RequestMethod.GET ,produces = {MediaType.APPLICATION_JSON_VALUE+";charset=" + "UTF-8"} )
    public String getSampleReq(@RequestParam("param1") long param1,@RequestParam("param2") String param2) throws Exception{
        logger.info("Method invoked " + "SampleResource.getSampleReq" + ","); 
        return new Gson().toJson("Rest working"); 
    }
	
}
