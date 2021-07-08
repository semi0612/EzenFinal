package com.clockOn.web.entity.vacation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Annday {
	private int total_annday;
	private float annday_rest;
	
	public Annday(int total_annday, float annday_rest) {
		this.total_annday = total_annday;
		this.annday_rest = annday_rest;
	}
}
