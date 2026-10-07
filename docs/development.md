# Development

## Chạy local

1. `docker compose up -d mysql`
2. Backend: `cd backend && ./mvnw spring-boot:run` (hoặc `.\mvnw.cmd ...` trên Windows)
3. Frontend: `cd frontend && npm install && npm run dev`

## Kiểm tra

Frontend:

```bash
cd frontend
npm run build
npm run lint
```

Backend:

```bash
cd backend
./mvnw test
./mvnw package
```

## Mock data

Frontend mặc định dùng mock data trong `src/mocks/data.ts` (`VITE_USE_MOCKS` không phải `false`). Đặt `VITE_USE_MOCKS=false` và `VITE_API_BASE_URL=http://localhost:8080` để frontend gọi API thật.

## Quy ước

- Không đặt business logic trong UI component.
- Backend: Controller chỉ điều phối; logic ở Service; truy cập DB ở Repository.
- Secrets/password qua biến môi trường, không commit `.env`.
