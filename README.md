   

# Rewards Program API

## Overview
This Spring Boot application calculates reward points based on customer purchases:
- 2 points for every dollar spent over $100.
- 1 point for every dollar spent between $50 and $100.
Example: A $120 purchase earns `90 points`.

## API Endpoints

GET /api/rewards**: Fetch total reward points for all customers.
 
  [
    {
      "customerId": "Jack",
      "totalPoints": 270,
      "transactions": [
        { "date": "2024-01-15", "points": 120 },
        { "date": "2024-02-10", "points": 150 }
      ]
    }
  ]
  ```
GET /api/rewards/{customerId}**: Fetch reward points for a specific customer.
  
  {
    "customerId": "Jack",
    "totalPoints": 270,
    "transactions": [
      { "date": "2024-01-15", "points": 120 },
      { "date": "2024-02-10", "points": 150 }
    ]
  }
  ```
GET /api/rewards/{customerId}/dateRange?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD**: Fetch reward points for a customer within a date range.
 
  {
    "customerId": "Jack",
    "totalPoints": 270,
    "transactions": [
      { "date": "2024-01-15", "points": 120 },
      { "date": "2024-02-10", "points": 150 }
    ]
  }
  ```

## Setup
1. Clone the repo:
   ```bash
   git clone https://github.com/YourUsername/rewardAPI.git
   cd rewardAPI
   ```
2. Build and run the app:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
3. App runs at: `http://localhost:8080`
