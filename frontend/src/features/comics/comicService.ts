import { apiClient } from '@/services/api'
import { comics } from '@/mocks/data'
import type { Comic, Top10Period } from '@/types'

const USE_MOCKS = import.meta.env.VITE_USE_MOCKS !== 'false'

export async function fetchComics(): Promise<Comic[]> {
  if (USE_MOCKS) return Promise.resolve(comics)
  const { data } = await apiClient.get<Comic[]>('/api/v1/comics')
  return data
}

export async function fetchLatest(): Promise<Comic[]> {
  if (USE_MOCKS) {
    return Promise.resolve([...comics].sort((a, b) => b.updatedAt.localeCompare(a.updatedAt)))
  }
  const { data } = await apiClient.get<Comic[]>('/api/v1/comics/latest')
  return data
}

export async function fetchRecommended(): Promise<Comic[]> {
  if (USE_MOCKS) return Promise.resolve(comics.filter((c) => c.recommended))
  const { data } = await apiClient.get<Comic[]>('/api/v1/comics/recommended')
  return data
}

export async function fetchTop10(period: Top10Period): Promise<Comic[]> {
  if (USE_MOCKS) return Promise.resolve(comics.slice(0, 10))
  const { data } = await apiClient.get<Comic[]>(`/api/v1/comics/top10?period=${period}`)
  return data
}
