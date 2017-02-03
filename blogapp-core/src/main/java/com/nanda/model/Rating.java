package com.nanda.model;

import lombok.Data;

@Data
public class Rating {
	private int id;
	private Article articleId;
	private User userId; 
	private int rating;
}
