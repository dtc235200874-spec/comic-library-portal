import { useParams } from 'react-router-dom'
import { comics } from '@/mocks/data'

export function AdminComicDetailPage() {
  const { id } = useParams()
  const comic = comics.find((c) => String(c.id) === id)
  return (
    <div>
      <h1 className="text-2xl font-bold">{comic ? comic.title : `Truyện #${id}`}</h1>
      <p className="text-muted-foreground">Chi tiết chỉnh sửa truyện (sắp phát triển).</p>
    </div>
  )
}
