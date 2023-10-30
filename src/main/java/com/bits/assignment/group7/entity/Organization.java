package com.bits.assignment.group7.entity;

import com.bits.assignment.group7.dto.DepartmentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String code;
	private String address;
	private Long departmentId;
}
