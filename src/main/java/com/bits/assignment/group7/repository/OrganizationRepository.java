package com.bits.assignment.group7.repository;

import java.util.List;

import com.bits.assignment.group7.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	List<Organization> findByDepartmentId(long id);
}
