## Installation and running

```bash
docker-compose up -d postgres

# Запуск приложения
./gradlew bootRun
```

## Testing

### 1. Регистрация пользователя
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123",
    "role": "USER",
    "email": "test@example.com",
    "phoneNumber": "+79991234567"
  }'
```

### 2. Вход в систему
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123"
  }'
```

### 3. Отправка OTP
```bash
curl -X POST http://localhost:8080/otp \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "operationId": 123
  }'
```

### 4. Верификация OTP
```bash
curl -X POST http://localhost:8080/otp/validate \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "code": "123456",
    "operationId": 123
  }'
```

