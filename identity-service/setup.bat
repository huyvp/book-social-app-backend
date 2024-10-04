@echo off
echo ===== set postgres start =====
setx POSTGRES_USERNAME "postgres" /M
setx POSTGRES_PASSWORD "123456" /M
setx POSTGRES_URL "jdbc:postgresql://localhost:5432/postgres" /M
echo ===== set postgres done =====
pause
