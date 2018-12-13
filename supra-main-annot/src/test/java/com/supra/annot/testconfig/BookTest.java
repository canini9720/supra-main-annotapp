package com.supra.annot.testconfig;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.supra.annot.common.util.ApplicationProperties;
import com.supra.annot.service.BookService;
import com.supra.supra.service.BookRequest;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonTestConfig.class, BookTestConfig.class})
@Transactional
@DependsOn("ApplicationProperties")
@WebAppConfiguration
public class BookTest {
	
	
	@Autowired
	ApplicationProperties applicationProperties;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
    ServletContext servletContext;
	
	@Test
	public void saveBookTest() throws Exception {
		
		
		System.out.println("bookService="+bookService);
		

		System.out.println(initialze());
		int refid=bookService.saveBookOrder(initialze());
		//TestDTO testDTO = new TestDTO();
		//Long udcont=testService.saveTest(testDTO);
		System.out.println("refid="+refid);
		 
		 Assert.assertNotNull(refid);
		//Assert.assertEquals(true, true);
		
	}
	
	private BookRequest initialze(){
		BookRequest dto=new BookRequest();
		
		dto.setIsbn("232");
		dto.setAuthor("Sruco");
		dto.setTitle("Macjro");
		
		List<BookRequest.Character> ad=new ArrayList<BookRequest.Character>();
		BookRequest.Character cha1=new BookRequest.Character();
		cha1.setName("Raj");
		cha1.setFriendOf("quru");
		cha1.setQualification("BA");
		cha1.setSince("1547");
		
		
		dto.getCharacter().add(cha1);
		return dto;
	}

}

