# Database

MySQL 8.4 chạy qua docker-compose. Backend kết nối qua các biến `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USERNAME`, `DB_PASSWORD`.

## Tables (JPA entities)

### comics
`id, title, alternative_title, author, description, cover_url, status, is_recommended, recommendation_priority, created_at, updated_at`

### genres
`id, name, slug`

### comic_genres
Many-to-many: `comic_id, genre_id`

### chapters
`id, comic_id, chapter_number, title, published_at, created_at, updated_at`

### chapter_pages
`id, chapter_id, page_number, image_url`

### comic_views
`id, comic_id, user_id (nullable), chapter_id (nullable), viewed_at`
Dùng cho bảng Top 10 theo ngày/tuần/tháng.

### users
`id, username, email, password_hash, role, created_at`

## Migrations

Phase 0 dùng `spring.jpa.hibernate.ddl-auto=update` cho local dev. Phase sau nên chuyển sang Flyway/Liquibase và đặt `ddl-auto=validate`.
