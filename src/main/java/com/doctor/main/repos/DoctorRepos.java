package com.doctor.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.main.model.Model;

public interface DoctorRepos extends JpaRepository<Model, Integer> {

}
