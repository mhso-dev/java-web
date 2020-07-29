package kr.co.spring.ch06.domain;

import lombok.Data;

@Data
public class Ticket {
	private int bno;
	private String owner;
	private String grade;
}
