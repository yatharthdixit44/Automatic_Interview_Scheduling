public package com.example.scheduler.controller;

import com.example.scheduler.entity.InterviewSlot;
import com.example.scheduler.service.SlotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping("/{id}/book")
    public InterviewSlot bookSlot(@PathVariable Long id) {
        return slotService.bookSlot(id);
    }
}