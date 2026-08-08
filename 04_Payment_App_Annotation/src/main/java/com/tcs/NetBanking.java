package com.tcs;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetBanking {
	
	private Integer accountNumber;
	private String accHolderName;
	private Double balance;
	private String phone;
	private String mail;

	
}
