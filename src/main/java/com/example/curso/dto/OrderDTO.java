package com.example.curso.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.curso.entities.Order;
import com.example.curso.entities.User;
import com.example.curso.entities.enums.OrderStatus;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant moment;
	private OrderStatus orderStatus;
	private Long clientId;
	private String clientName;
	private String clientEmail;
	
	public OrderDTO() {
	}

	public OrderDTO(Long id, Instant moment, OrderStatus orderStatus, Long clientId, String clientName,
			String clientEmail) {
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
	}

	public OrderDTO(Order entity) {
		if (entity.getClient() == null) {
			throw new IllegalArgumentException("Error Instantiating OrderDTO: client was null");
		}
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.orderStatus = entity.getOrderStatus();
		this.clientId = entity.getClient().getId();
		this.clientName = entity.getClient().getName();
		this.clientEmail = entity.getClient().getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	
	public Order toEntity() {
		User client = new User(clientId, clientName, clientEmail, null, null);
		return new Order(id, moment, orderStatus, client);
	}
	
	
}
