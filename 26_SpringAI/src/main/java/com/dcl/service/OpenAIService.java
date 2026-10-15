package com.dcl.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

	
	
	@Autowired
	private ChatClient client;

	public String chat(String question) {
		
		return client.prompt()  //to create a request obj
					 .user(question) //sending question by user()
					// .advisors(advisor -> advisor.param(
		            //          ChatMemory.CONVERSATION_ID,
		            //            "default-conversation"
		            //    ))
					 .call()  //response 
					 
					 .content();  //to get response in form of string
	}
	
}
