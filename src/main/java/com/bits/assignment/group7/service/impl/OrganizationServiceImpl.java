package com.bits.assignment.group7.service.impl;

import com.bits.assignment.group7.dto.DepartmentDTO;
import com.bits.assignment.group7.dto.OrganizationDTO;
import com.bits.assignment.group7.entity.Organization;
import com.bits.assignment.group7.repository.OrganizationRepository;
import com.bits.assignment.group7.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {
    static String DEPARTMENT_URL = "http://localhost:8070/api/departments";

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO save(OrganizationDTO dto) {
        Organization organization = new Organization();
        BeanUtils.copyProperties(dto, organization);
        organization = organizationRepository.save(organization);
        BeanUtils.copyProperties(organization, dto);
        return dto;
    }

    @Override
    public OrganizationDTO getById(Long organizationId) {
        Organization organization = organizationRepository.findById(organizationId).get();
        OrganizationDTO dto = new OrganizationDTO();
        BeanUtils.copyProperties(organization, dto);
        dto.setDepartments(getDepartmentsById(dto.getId()));
        return dto;
    }

    @Override
    public List<OrganizationDTO> getAll() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizations.stream()
                .map(e -> new OrganizationDTO(e.getId(), e.getName(), e.getCode(), e.getAddress(), e.getDepartmentId(), getDepartmentsById(e.getDepartmentId())))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }

    @Override
    public List<OrganizationDTO> getByDepartmentId(Long departmentId) {
        List<Organization> organizations = organizationRepository.findByDepartmentId(departmentId);
        return organizations.stream()
                .map(e -> new OrganizationDTO(e.getId(), e.getName(), e.getCode(), e.getAddress(), e.getDepartmentId(), getDepartmentsById(e.getDepartmentId())))
                .collect(Collectors.toList());
    }

    private List<DepartmentDTO> getDepartmentsById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DepartmentDTO[]> response = restTemplate.getForEntity(DEPARTMENT_URL + "/organization/" + id, DepartmentDTO[].class);
        return Arrays.asList(response.getBody());
    }
}
