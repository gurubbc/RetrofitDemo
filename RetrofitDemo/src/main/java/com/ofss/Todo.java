package com.ofss;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Todo {
	int userId;
	int id;
	String title;
	boolean completed;
	
}
