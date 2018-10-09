package com.emailer.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emailer.db.DBQuery;
import com.emailer.domain.User;
import com.emailer.service.MailService;

@Controller
public class EmailController {
	
	@Autowired
	MailService mailService;
	
	@RequestMapping("/")
	public String email(Model model){
		model.addAttribute("title","Multiple Receiptants EMAILER");
		return "email";
	}
	
	@RequestMapping("/email-success")
	public String emailSuccess() {
		//send user email
		/*User user = new User();
		user.setName("jasbin karki");
		user.setEmailAddress("jasbinkarki@gmail.com");
		user.setCourse("java");*/
		
		/*try {
			for (Map.Entry<Integer, String> m : map.entrySet()) {
				User user = new User();
				//System.out.println("id: "+ m.getKey() +" "+"email: "+m.getValue());
				user.setName("jasbin");
				user.setEmailAddress(m.getValue());
				System.out.println("email: "+user.getEmailAddress());
				mailService.SendEmail(user);
			}*/
		HashMap<Integer, User> map = DBQuery.getEmailList();
		try {
				for(Map.Entry<Integer, User>m : map.entrySet()){
					User user = new User();
					user.setName(m.getValue().getName());
					user.setEmailAddress(m.getValue().getEmailAddress());
					user.setCourse(m.getValue().getCourse());
					
		            //check if all details are successfully fetched
					System.out.println("name:"+m.getValue().getName() +" "+"email:"+m.getValue().getEmailAddress()+" "+"course:"+m.getValue().getCourse());
		            
					// send email to all clients
					mailService.SendEmail(user);
				}
			}catch (MailException e) {
			e.printStackTrace();
			}
		return "email_processed";
	}
}