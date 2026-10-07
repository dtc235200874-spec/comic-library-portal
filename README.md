# Comic Library Portal

Cổng web thư viện truyện tranh online. Dự án đang ở giai đoạn Phase 0 (bootstrap): đã có kiến trúc nền tảng, API skeleton, UI skeleton và build được.

## Tech stack

- Frontend: React 19, TypeScript, Vite, Tailwind CSS, shadcn/ui, Lucide React, React Router, TanStack Query
- Backend: Java 21, Spring Boot 4, Spring Web, Spring Security, Spring Data JPA, Bean Validation, Maven
- Database: MySQL 8.4 (Docker)
- Storage: abstraction `StorageService` (local stub, sẵn sàng thay Cloudflare R2 / AWS S3)

## Folder structure

```text
comic-library-portal/
├── frontend/
├── backend/
├── docs/
├── docker-compose.yml
├── .gitignore
├── README.md
└── .env.example
```

- `frontend/src/components` — UI + domain components (Header, ComicGrid, Top10Sidebar, ...)
- `frontend/src/layouts` — MainLayout, AdminLayout
- `frontend/src/pages` — Home, Search, Login, Reader, Admin pages
- `frontend/src/routes` — route foundation
- `frontend/src/features/comics` — comic data services (mock/API)
- `backend/src/main/java/com/comiclibrary` — config, controller, service, repository, entity, dto, exception, storage

## Prerequisites

- Node.js 20+
- JDK 21
- Docker (cho MySQL)

## Chạy database

```bash
docker compose up -d mysql
```

## Chạy backend

```bash
cd backend
./mvnw spring-boot:run        # Windows: .\mvnw.cmd spring-boot:run
```

Backend mặc định tại http://localhost:8080. Biến môi trường xem trong `.env.example`.

## Chạy frontend

```bash
cd frontend
npm install
npm run dev
```

Frontend mặc định tại http://localhost:5173 (Vite). `VITE_USE_MOCKS` mặc định bật mock data; set `VITE_USE_MOCKS=false` và `VITE_API_BASE_URL` để gọi API thật.

## Environment variables

Xem `.env.example` ở thư mục gốc.

## API overview

Public:

```text
GET /api/v1/comics
GET /api/v1/comics/{id}
GET /api/v1/comics/latest
GET /api/v1/comics/popular
GET /api/v1/comics/recommended
GET /api/v1/comics/top10?period=day|week|month
GET /api/v1/genres
GET /api/v1/comics/{id}/chapters
GET /api/v1/chapters/{id}
POST /api/v1/chapters/{id}/view
```

Admin (chưa bật auth, skeleton):

```text
POST /api/v1/admin/comics
PUT /api/v1/admin/comics/{id}
DELETE /api/v1/admin/comics/{id}
POST /api/v1/admin/comics/{id}/chapters
PUT /api/v1/admin/chapters/{id}
DELETE /api/v1/admin/chapters/{id}
```

Lưu ý: các endpoint trả về dữ liệu thật từ DB; admin endpoints chưa có kiểm soát quyền (đang để permitAll ở Phase 0).

## Roadmap

- Phase 1: auth (User roles), admin CRUD hoàn chỉnh, upload ảnh bìa/chapter
- Phase 2: trang đọc truyện, lịch sử đọc, đánh giá/xếp hạng
- Phase 3: tích hợp R2/S3, tối ưu Top 10 bằng cache/aggregate table
- Phase 4: search, filter theo thể loại/tác giả

## Docs

- docs/architecture.md
- docs/development.md
- docs/database.md
