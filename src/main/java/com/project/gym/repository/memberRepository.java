package com.project.gym.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.gym.model.member;

@Repository
public interface memberRepository extends JpaRepository<member, Integer> {

	Optional<member> findByEmail(String email);

	
			

		}

