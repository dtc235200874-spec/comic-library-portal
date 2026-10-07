import { useParams } from 'react-router-dom'
import { comics } from '@/mocks/data'
import { GenreBadge } from '@/components/GenreBadge'

export function ComicDetailPage() {
  const { id } = useParams()
  const comic = comics.find((c) => String(c.id) === id)
  if (!comic) return <p>Không tìm thấy truyện.</p>
  return (
    <div className="flex flex-col gap-6 md:flex-row">
      <img src={comic.coverUrl} alt={comic.title} className="w-64 rounded-lg" />
      <div>
        <h1 className="text-3xl font-bold">{comic.title}</h1>
        <p className="text-muted-foreground">{comic.author}</p>
        <div className="mt-2 flex gap-1">
          {comic.genres.map((g) => (
            <GenreBadge key={g.id} name={g.name} />
          ))}
        </div>
        <p className="mt-4">{comic.description}</p>
      </div>
    </div>
  )
}
