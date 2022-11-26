package com.example.productivity.repository;

import com.example.productivity.models.GoalActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalActivityRepository extends JpaRepository<GoalActivity, Long> {
}
