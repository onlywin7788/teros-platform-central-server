package com.teros.central_server.repository.apiservice.plan;

import com.teros.central_server.entity.apiservice.plan.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}
