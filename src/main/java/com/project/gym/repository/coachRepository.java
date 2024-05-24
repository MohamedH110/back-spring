package com.project.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.gym.model.coach;

@Repository
public interface coachRepository extends JpaRepository<coach, Integer> {

}
