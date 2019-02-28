package com.org.canteen.vo;

import com.org.canteen.api.common.Gender;

import lombok.Data;

@Data
public class CustomerVO {
	public Integer id;
	String name;
	int age;
	Gender gender;
}
