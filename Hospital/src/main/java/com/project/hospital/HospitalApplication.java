package com.project.hospital;


import com.project.hospital.models.*;
import com.project.hospital.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.util.Date;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	@Transactional
	CommandLineRunner commandLineRunner(PatientRepo patientRepo, DoctorRepo doctorRepo, AppointmentRepo appointmentRepo, DepartmentRepo departmentRepo, MedicalRepo medicalRepo) {
		return args -> {
			Date date = new Date();
			Time time = new Time(System.currentTimeMillis());
			TimeDate td= new TimeDate(time,date);
			Patient patient = new Patient("Naome","Tuyishime","female",16,"Kigali","0793099772");
			patientRepo.save(patient);

			Doctor doctor=  new Doctor("John","Kabengera","Philosophy","john@gmail.com","0783099772");
			doctorRepo.save(doctor);


			Department department= new Department("Cardiology","heart related issues");
			departmentRepo.save(department);
			doctor.getDepartments().add(department);
			department.getDoctors().add(doctor);

			doctorRepo.save(doctor);
			departmentRepo.save(department);

			MedicalRecords medicalRecords= new MedicalRecords(td,"Hypertension","qwertr","ewfererf",patient);
			medicalRepo.save(medicalRecords);

			Appointment appointment= new Appointment(td,"completed",doctor,patient);
			appointmentRepo.save(appointment);


		};
	}

}
