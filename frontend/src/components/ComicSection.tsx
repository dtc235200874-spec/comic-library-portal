import type { Comic } from '@/types'
import { ComicGrid } from '@/components/ComicGrid'

export function ComicSection({ title, comics }: { title: string; comics: Comic[] }) {
  return (
    <section className="mb-8">
      <h2 className="mb-4 text-xl font-bold">{title}</h2>
      <ComicGrid comics={comics} />
    </section>
  )
}
