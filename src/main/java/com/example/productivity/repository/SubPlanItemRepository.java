package com.example.productivity.repository;

import com.example.productivity.models.SubPlanItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubPlanItemRepository extends JpaRepository<SubPlanItem, Long> {
}
