package com.project.hospital.repository;

import com.project.hospital.models.MedicalRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRepo extends JpaRepository<MedicalRecords,Integer> {
}
