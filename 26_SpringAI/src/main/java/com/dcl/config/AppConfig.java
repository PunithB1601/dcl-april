package com.dcl.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public ChatClient getChatClient(ChatClient.Builder builder, ChatMemory memory) {
	//	return builder.defaultAdvisors(getMemory(memory)=).build();
		return builder.build();
	}
	
}
