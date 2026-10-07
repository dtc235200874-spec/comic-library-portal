import { genres } from '@/mocks/data'
import { GenreBadge } from '@/components/GenreBadge'

export function GenresPage() {
  return (
    <div>
      <h1 className="mb-4 text-2xl font-bold">Thể loại</h1>
      <div className="flex flex-wrap gap-2">
        {genres.map((g) => (
          <GenreBadge key={g.id} name={g.name} />
        ))}
      </div>
    </div>
  )
}
