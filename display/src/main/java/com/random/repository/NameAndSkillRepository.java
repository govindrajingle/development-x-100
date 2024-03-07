package com.random.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.random.entity.NameAndSkill;

@Repository
public interface NameAndSkillRepository extends JpaRepository<NameAndSkill, Long>{

}
