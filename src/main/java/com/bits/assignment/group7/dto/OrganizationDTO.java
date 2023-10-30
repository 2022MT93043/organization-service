package com.bits.assignment.group7.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrganizationDTO {
	private Long id;
	private String name;
	private String code;
	private String address;
	private Long departmentId;
	private List<DepartmentDTO> departments = new ArrayList<>();
}
