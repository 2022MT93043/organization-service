package com.bits.assignment.group7.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DepartmentDTO {
	private Long id;
	private Long organizationId;
	private String name;
	private String code;
	private String address;
}
