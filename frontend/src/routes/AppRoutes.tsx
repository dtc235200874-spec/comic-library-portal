import { Route, Routes } from 'react-router-dom'
import { MainLayout } from '@/layouts/MainLayout'
import { AdminLayout } from '@/layouts/AdminLayout'
import { HomePage } from '@/pages/HomePage'
import { PopularPage } from '@/pages/PopularPage'
import { GenresPage } from '@/pages/GenresPage'
import { HistoryPage } from '@/pages/HistoryPage'
import { ComicDetailPage } from '@/pages/ComicDetailPage'
import { ReaderPage } from '@/pages/ReaderPage'
import { SearchPage } from '@/pages/SearchPage'
import { LoginPage } from '@/pages/LoginPage'
import { AdminDashboardPage } from '@/pages/admin/AdminDashboardPage'
import { AdminComicsPage } from '@/pages/admin/AdminComicsPage'
import { AdminComicNewPage } from '@/pages/admin/AdminComicNewPage'
import { AdminComicDetailPage } from '@/pages/admin/AdminComicDetailPage'
import { AdminChaptersPage } from '@/pages/admin/AdminChaptersPage'

export function AppRoutes() {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        <Route path="/" element={<HomePage />} />
        <Route path="/popular" element={<PopularPage />} />
        <Route path="/genres" element={<GenresPage />} />
        <Route path="/history" element={<HistoryPage />} />
        <Route path="/comic/:id" element={<ComicDetailPage />} />
        <Route path="/comic/:id/chapter/:chapterId" element={<ReaderPage />} />
        <Route path="/search" element={<SearchPage />} />
        <Route path="/login" element={<LoginPage />} />
      </Route>
      <Route path="/admin" element={<AdminLayout />}>
        <Route index element={<AdminDashboardPage />} />
        <Route path="comics" element={<AdminComicsPage />} />
        <Route path="comics/new" element={<AdminComicNewPage />} />
        <Route path="comics/:id" element={<AdminComicDetailPage />} />
        <Route path="comics/:id/chapters" element={<AdminChaptersPage />} />
      </Route>
    </Routes>
  )
}
