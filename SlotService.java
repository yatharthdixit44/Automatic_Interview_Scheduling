public package com.example.scheduler.service;

import com.example.scheduler.entity.InterviewSlot;
import com.example.scheduler.exception.SlotAlreadyBookedException;
import com.example.scheduler.repository.SlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Transactional
    public InterviewSlot bookSlot(Long slotId) {
        InterviewSlot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        if (slot.isBooked()) {
            throw new SlotAlreadyBookedException("Slot already booked");
        }

        slot.setBooked(true);
        return slotRepository.save(slot);
    }
}