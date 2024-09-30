package com.example.rewardpoints.controller;

import com.example.rewardpoints.model.RewardPointsSummary;
import com.example.rewardpoints.service.RewardPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardPointsController {

    @Autowired
    private RewardPointsService rewardPointsService;


    @GetMapping
    public List<RewardPointsSummary> getAllRewardPoints() {
        return rewardPointsService.calculateRewards();
    }


    @GetMapping("/{customerId}")
    public RewardPointsSummary getRewardPointsByCustomer(@PathVariable String customerId) {
        return rewardPointsService.calculateRewards().stream()
                .filter(summary -> summary.getCustomerId().equalsIgnoreCase(customerId))
                .findFirst()
                .orElse(null);
    }


    @GetMapping("/{customerId}/dateRange")
    public RewardPointsSummary getRewardPointsByCustomerAndDateRange(
            @PathVariable String customerId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return rewardPointsService.calculateRewardsForDateRange(customerId, startDate, endDate);
    }
}
