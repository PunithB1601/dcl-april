package com.dcl.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClient.CallResponseSpec;
import org.springframework.ai.chat.client.ChatClient.ChatClientRequestSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

	 
	@Autowired
	private ChatClient client;
	
	public String demo(String question) {
		
		//ChatClientRequestSpec reqSpec=client.prompt();
		//reqSpec=reqSpec.user(question);
		//CallResponseSpec respSpec=reqSpec.call();
		//String resp=respSpec.content();
		return client.prompt().user(question).call().content();
	}
}
