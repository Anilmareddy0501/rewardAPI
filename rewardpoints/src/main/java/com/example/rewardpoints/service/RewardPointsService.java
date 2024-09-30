package com.example.rewardpoints.service;

import com.example.rewardpoints.model.RewardPointsSummary;
import com.example.rewardpoints.model.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardPointsService {

    private List<Transaction> transactions = new ArrayList<>();

    @PostConstruct
    public void init() {

        transactions.add(new Transaction("Jack", LocalDate.of(2024, 1, 15), 120));
        transactions.add(new Transaction("Becky", LocalDate.of(2024, 2, 17), 75));
        transactions.add(new Transaction("Jack", LocalDate.of(2024, 2, 10), 150));
        transactions.add(new Transaction("Becky", LocalDate.of(2024, 3, 15), 95));
    }


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionsWithinDateRange(String customerId, LocalDate startDate, LocalDate endDate) {
        return transactions.stream()
                .filter(t -> t.getCustomerId().equalsIgnoreCase(customerId))
                .filter(t -> (t.getDate().isAfter(startDate) || t.getDate().isEqual(startDate)) &&
                        (t.getDate().isBefore(endDate) || t.getDate().isEqual(endDate)))
                .collect(Collectors.toList());
    }


    public RewardPointsSummary calculateRewardsForDateRange(String customerId, LocalDate startDate, LocalDate endDate) {
        List<Transaction> filteredTransactions = getTransactionsWithinDateRange(customerId, startDate, endDate);
        int totalPoints = filteredTransactions.stream().mapToInt(Transaction::getPoints).sum();


        RewardPointsSummary summary = new RewardPointsSummary();
        summary.setCustomerId(customerId);
        summary.setTotalPoints(totalPoints);
        summary.setTransactions(filteredTransactions);

        return summary;
    }


    public List<RewardPointsSummary> calculateRewards() {

        List<RewardPointsSummary> summaries = new ArrayList<>();

        return summaries;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }
}
