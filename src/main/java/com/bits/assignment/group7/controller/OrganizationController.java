package com.bits.assignment.group7.controller;

import java.util.List;

import com.bits.assignment.group7.dto.OrganizationDTO;
import com.bits.assignment.group7.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

	@Autowired
	OrganizationService organizationService;

	@PostMapping("/")
	public OrganizationDTO add(@RequestBody OrganizationDTO organizationDTO) {
		LOGGER.info("Organization add: {}", organizationDTO);
		return organizationService.save(organizationDTO);
	}

	@GetMapping("/{id}")
	public OrganizationDTO findById(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		return organizationService.getById(id);
	}

	@GetMapping("/")
	public List<OrganizationDTO> findAll() {
		LOGGER.info("Organization find");
		return organizationService.getAll();
	}

	@GetMapping("/department/{departmentId}")
	public List<OrganizationDTO> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Organization find: departmentId={}", departmentId);
		return organizationService.getByDepartmentId(departmentId);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable (value = "id") Long id) {
		this.organizationService.delete(id);
		return "Successfully deleted organization ID:" + id;
	}

	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return ResponseEntity.ok("Microservice 2: Organization Service is up and running....!");
	}
}