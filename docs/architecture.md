# Architecture

## Tổng quan

Monorepo tách biệt frontend (React/Vite) và backend (Spring Boot). Frontend gọi backend qua REST (`/api/v1`). Ở Phase 0 frontend chạy bằng mock data để phát triển UI độc lập với backend.

## Backend packages

- `config` — SecurityConfig (Spring Security skeleton), WebConfig (CORS)
- `controller` — REST endpoints, mỏng, nhận/trả DTO
- `service` — business logic (ComicService, ChapterService, Top10Service, ViewService, GenreService)
- `repository` — Spring Data JPA repositories
- `entity` — JPA entities: Comic, Genre, ComicGenre (many-to-many qua `comic_genres`), Chapter, ChapterPage, ComicView, User
- `dto` — request/response DTOs + validation
- `exception` — ResourceNotFoundException + GlobalExceptionHandler
- `storage` — `StorageService` abstraction; `LocalStorageService` hiện tại, R2/S3 thay sau không ảnh hưởng business logic

## Frontend layers

- `components/ui` — shadcn/ui primitives
- `components` — domain components (ComicCard, ComicGrid, ComicSection, Top10Sidebar, Top10Item, SearchBar, Header, MainNavigation, GenreBadge)
- `layouts` — MainLayout, AdminLayout
- `pages` — Home, Popular, Genres, History, ComicDetail, Reader, Search, Login, Admin pages
- `features/comics` — comic services (mock-first, API khi USE_MOCKS=false)
- `services/api.ts` — axios instance đọc `VITE_API_BASE_URL`
- TanStack Query quản lý server state ở các page cần dữ liệu

## Hướng mở rộng

- Auth: thêm JWT/Spring Security filters, khóa `/api/v1/admin/**` bằng role
- Upload ảnh: controller multipart gọi `StorageService`, lưu URL vào `cover_url`/`chapter_pages`
