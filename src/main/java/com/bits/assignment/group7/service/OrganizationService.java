package com.bits.assignment.group7.service;

import com.bits.assignment.group7.dto.OrganizationDTO;

import java.util.List;

public interface OrganizationService {
    OrganizationDTO save(OrganizationDTO organization);

    OrganizationDTO getById(Long organizationId);

    void delete(Long id);

    List<OrganizationDTO> getAll();

    List<OrganizationDTO> getByDepartmentId(Long aLong);
}