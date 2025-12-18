public package com.example.scheduler.repository;

import com.example.scheduler.entity.InterviewSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<InterviewSlot, Long> {
}