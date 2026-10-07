import { useQuery } from '@tanstack/react-query'
import { fetchLatest, fetchRecommended } from '@/features/comics/comicService'
import { ComicSection } from '@/components/ComicSection'
import { Top10Sidebar } from '@/components/Top10Sidebar'

export function HomePage() {
  const { data: recommended = [] } = useQuery({ queryKey: ['comics', 'recommended'], queryFn: fetchRecommended })
  const { data: latest = [] } = useQuery({ queryKey: ['comics', 'latest'], queryFn: fetchLatest })

  return (
    <div>
      <section className="mb-8 rounded-xl bg-gradient-to-r from-primary/90 to-primary/60 p-10 text-primary-foreground">
        <h1 className="text-3xl font-bold">Chào mừng đến Comic Library Portal</h1>
        <p className="mt-2 max-w-2xl text-sm opacity-90">
          Khám phá kho truyện tranh phong phú: Solo Leveling, One Piece, Spy x Family và nhiều hơn nữa.
        </p>
      </section>
      <div className="flex flex-col gap-8 lg:flex-row">
        <div className="min-w-0 flex-1">
          <ComicSection title="Truyện đề cử" comics={recommended.slice(0, 4)} />
          <ComicSection title="Truyện mới cập nhật" comics={latest.slice(0, 8)} />
        </div>
        <Top10Sidebar />
      </div>
    </div>
  )
}
