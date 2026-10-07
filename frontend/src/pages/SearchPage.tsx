import { useSearchParams } from 'react-router-dom'
import { comics } from '@/mocks/data'
import { ComicGrid } from '@/components/ComicGrid'

export function SearchPage() {
  const [params] = useSearchParams()
  const q = (params.get('q') ?? '').toLowerCase()
  const results = comics.filter((c) => c.title.toLowerCase().includes(q))
  return (
    <div>
      <h1 className="mb-4 text-2xl font-bold">Kết quả tìm kiếm: {q || '(tất cả)'}</h1>
      <ComicGrid comics={results} />
    </div>
  )
}
