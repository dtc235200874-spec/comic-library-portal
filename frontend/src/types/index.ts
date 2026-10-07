export type ComicStatus = 'ONGOING' | 'COMPLETED' | 'HIATUS'

export interface Genre {
  id: number
  name: string
  slug: string
}

export interface Comic {
  id: number
  title: string
  alternativeTitle?: string
  author: string
  description: string
  coverUrl: string
  status: ComicStatus
  recommended: boolean
  recommendationPriority?: number
  createdAt: string
  updatedAt: string
  genres: Genre[]
}

export interface Chapter {
  id: number
  comicId: number
  chapterNumber: number
  title: string
  publishedAt?: string
  createdAt: string
  updatedAt: string
}

export interface ChapterPage {
  id: number
  pageNumber: number
  imageUrl: string
}

export interface ChapterDetail {
  chapter: Chapter
  pages: ChapterPage[]
}

export type Top10Period = 'day' | 'week' | 'month'
