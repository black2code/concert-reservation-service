## 콘서트 예약 서비스 ERD 
![img.png](img.png)

<br>

## API 명세

## 1. 유저 대기열 토큰 발급 API
- **URL:** `/api/queue/token`
- **Method:** POST
- **Request Body:**
  ```json
  {
    "userId": "string"
  }
  ```
- **Response:**
  ```json
  {
    "token": "string",
    "queuePosition": "number",
    "estimatedWaitTime": "number"
  }
  ```

## 2. 예약 가능 날짜/좌석 API
### 2.1 예약 가능 날짜 조회
- **URL:** `/api/concerts/available-dates`
- **Method:** GET
- **Response:**
  ```json
  {
    "availableDates": ["YYYY-MM-DD"]
  }
  ```

### 2.2 예약 가능 좌석 조회
- **URL:** `/api/concerts/{date}/available-seats`
- **Method:** GET
- **Response:**
  ```json
  {
    "availableSeats": [
      {
        "seatNumber": "number",
        "status": "string"
      }
    ]
  }
  ```

## 3. 좌석 예약 요청 API
- **URL:** `/api/reservations`
- **Method:** POST
- **Request Headers:**
    - Authorization: Bearer {token}
- **Request Body:**
  ```json
  {
    "concertDate": "YYYY-MM-DD",
    "seatNumber": "number"
  }
  ```
- **Response:**
  ```json
  {
    "reservationId": "string",
    "expirationTime": "timestamp"
  }
  ```

## 4. 잔액 충전/조회 API
### 4.1 잔액 충전
- **URL:** `/api/users/balance/charge`
- **Method:** POST
- **Request Headers:**
    - Authorization: Bearer {token}
- **Request Body:**
  ```json
  {
    "amount": "number"
  }
  ```
- **Response:**
  ```json
  {
    "userId": "string",
    "newBalance": "number"
  }
  ```

### 4.2 잔액 조회
- **URL:** `/api/users/balance`
- **Method:** GET
- **Request Headers:**
    - Authorization: Bearer {token}
- **Response:**
  ```json
  {
    "userId": "string",
    "balance": "number"
  }
  ```

## 5. 결제 API
- **URL:** `/api/payments`
- **Method:** POST
- **Request Headers:**
    - Authorization: Bearer {token}
- **Request Body:**
  ```json
  {
    "reservationId": "string"
  }
  ```
- **Response:**
  ```json
  {
    "paymentId": "string",
    "status": "string",
    "amount": "number"
  }
  ```