package com.dcl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.dto.TicketDto;
import com.dcl.entity.Ticket;
import com.dcl.repo.TicketRepo;
import com.dcl.request.TicketRequest;
import com.dcl.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepo trepo;
	@Override
	public TicketDto bookTicket(TicketRequest request) {
		Ticket t=new Ticket();
		t.setPassengerName(request.getPassengerName());
		t.setTfrom(request.getFrom());
		t.setTto(request.getTo());
		t.setJourneyDate(request.getJourneyDate());
		t.setTrainNumber("10113");
		t.setTicketStatus("CNFM");
		t=trepo.save(t);
		TicketDto dto=new TicketDto();
		dto.setTicketId(t.getTicketId());
		dto.setPassengerName(t.getPassengerName());
		dto.setFrom(t.getTfrom());
		dto.setTo(t.getTto());
		dto.setJourneyDate(t.getJourneyDate());
		dto.setTrainNumber(t.getTrainNumber());
		dto.setTicketStatus(t.getTicketStatus());
		return dto;
	}

	@Override
	public TicketDto getTicket(Integer ticketId) {
		Ticket t=trepo.findById(ticketId).orElse(null);
		TicketDto dto=new TicketDto();
		dto.setTicketId(t.getTicketId());
		dto.setPassengerName(t.getPassengerName());
		dto.setFrom(t.getTfrom());
		dto.setTo(t.getTto());
		dto.setJourneyDate(t.getJourneyDate());
		dto.setTrainNumber(t.getTrainNumber());
		dto.setTicketStatus(t.getTicketStatus());
		return dto;
	}

}
