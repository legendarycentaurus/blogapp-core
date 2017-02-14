package com.nanda.dto;

import lombok.Data;
@Data
public class User {

	private int id;
	private String name,password,emailId;
	Role roleId;
}
