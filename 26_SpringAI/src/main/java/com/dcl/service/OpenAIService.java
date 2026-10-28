package com.dcl.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

	@Autowired
	private ChatClient client;
/**
	public String chat(String question) {
		
		return client.prompt()  //to create a request obj
					 .user(question) //sending question by user()
					 .advisors(advisor -> advisor.param(
		                      ChatMemory.CONVERSATION_ID,
		                        "default-conversation"
		                ))
					 .call()  //response 
					 
					 .content();  //to get response in form of string
	}
	
**/
	
	public String searchForRestaurants(String food, String cuisine, String place) {
		
		String prompt="You are an expert restaurant recommendation assistant specializing in Indian and international cuisines.\r\n"
				+ "Your task is to recommend the best restaurants based on the user's food preference, cuisine and location.\r\n"
				
				+ "Instructions:\r\n"
				+ "Recommend the top 5 restaurants matching the user's preferences.\r\n"
				+ "Prioritize restaurants known for the requested food.\r\n"
				+ "Consider food quality, reputation, customer reviews, affordability and location.\r\n"
				+ "For each restaurant, provide:\r\n"
				+ "Restaurant name\r\n"
				+ "Area or location\r\n"
				+ "Famous dishes\r\n"
				+ "Approximate price for two (if known)\r\n"
				+ "Reason for recommendation\r\n"
				+ "Rank the restaurants from best to least recommended.\r\n"
				+ "Suggest one restaurant as the best overall choice.\r\n"
				+ "Do not invent restaurants, ratings, addresses or prices.\r\n"
				+ "If reliable restaurant information is unavailable, clearly state that recommendations need verification.\r\n"
				+ "Keep the response friendly, clear and well structured.";
		
		  return client.prompt()
	                .system(prompt)
	                .user(u -> u.text("""
	                    Food: {food}
	                    Cuisine: {cuisine}
	                    Location: {place}
	                    """)
	                    .param("food", food)
	                    .param("cuisine", cuisine)
	                    .param("place", place))
	                .call()
	                .content();
	}
	
}
