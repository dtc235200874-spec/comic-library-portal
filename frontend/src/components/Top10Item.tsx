import { Link } from 'react-router-dom'
import type { Comic } from '@/types'

export function Top10Item({ comic, rank }: { comic: Comic; rank: number }) {
  return (
    <li className="flex items-center gap-3 py-2">
      <span className="w-6 text-center font-bold text-primary">{rank}</span>
      <img src={comic.coverUrl} alt={comic.title} className="h-12 w-9 rounded object-cover" />
      <Link to={`/comic/${comic.id}`} className="line-clamp-1 text-sm font-medium hover:underline">
        {comic.title}
      </Link>
    </li>
  )
}
