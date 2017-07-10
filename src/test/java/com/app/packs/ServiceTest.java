package com.app.packs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.packs.web.soap.prepaidService.jaxbClasses.GetPlanForUserResponse;
import com.app.packs.web.soap.prepaidService.jaxbClasses.UserOperationRequest;
import com.app.packs.web.soap.prepaidService.service.PrepaidService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ServiceTest {
	
	
	@Autowired
	private PrepaidService prepaid;
	
	@Test
	public void test(){
		UserOperationRequest opr = new UserOperationRequest();
		opr.setPhoneNumber(1111);
		GetPlanForUserResponse r = prepaid.getPlanForUser(opr);
		System.out.println(r.getPlan());
	}

}
