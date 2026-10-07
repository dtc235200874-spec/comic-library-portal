import { Link } from 'react-router-dom'
import type { Comic } from '@/types'
import { Card, CardContent } from '@/components/ui/card'
import { GenreBadge } from '@/components/GenreBadge'

export function ComicCard({ comic }: { comic: Comic }) {
  return (
    <Link to={`/comic/${comic.id}`}>
      <Card className="overflow-hidden transition hover:shadow-md">
        <img src={comic.coverUrl} alt={comic.title} className="aspect-[3/4] w-full object-cover" />
        <CardContent className="p-3">
          <h3 className="line-clamp-1 font-semibold">{comic.title}</h3>
          <p className="text-xs text-muted-foreground">{comic.author}</p>
          <div className="mt-2 flex flex-wrap gap-1">
            {comic.genres.slice(0, 2).map((g) => (
              <GenreBadge key={g.id} name={g.name} />
            ))}
          </div>
        </CardContent>
      </Card>
    </Link>
  )
}
