package com.mmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.dto.TicketDto;
import com.mmt.entity.Passenger;
import com.mmt.feigns.FeignService;
import com.mmt.repo.PassengerRepo;
import com.mmt.request.TicketRequest;
import com.mmt.service.PassengerService;



@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private FeignService fservice;
	@Autowired
	private PassengerRepo prepo;
	
	@Override
	public TicketDto bookTicket(TicketRequest request) {
		Passenger p=new Passenger();
		p.setPassengerName(request.getPassengerName());
		p.setPfrom(request.getFrom());
		p.setPto(request.getTo());
		p.setJourneyDate(request.getJourneyDate());
		prepo.save(p);
		TicketDto tdto=fservice.bookTicket(request);
		return tdto;
	}

	@Override
	public TicketDto getTicketById(Integer ticketId) {
		TicketDto tdto=fservice.getTicket(ticketId);
		return tdto;
	}

}
