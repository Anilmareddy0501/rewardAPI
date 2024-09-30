package com.example.rewardpoints.service;

import com.example.rewardpoints.model.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RewardPointsServiceTest {

    @Test
    public void testAddTransaction() {

        RewardPointsService rewardPointsService = new RewardPointsService();


        rewardPointsService.addTransaction(new Transaction("Jack", LocalDate.of(2024, 1, 15), 120));

        assertEquals(1, rewardPointsService.getTransactions().size());
        assertEquals(120, rewardPointsService.getTransactions().get(0).getPoints());
    }
}
