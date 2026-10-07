import { useState } from 'react'
import { useQuery } from '@tanstack/react-query'
import { fetchTop10 } from '@/features/comics/comicService'
import { Top10Item } from '@/components/Top10Item'
import { Tabs, TabsList, TabsTrigger } from '@/components/ui/tabs'
import type { Top10Period } from '@/types'

export function Top10Sidebar() {
  const [period, setPeriod] = useState<Top10Period>('day')
  const { data: comics = [] } = useQuery({
    queryKey: ['top10', period],
    queryFn: () => fetchTop10(period),
  })

  return (
    <aside className="w-full lg:w-80">
      <h2 className="mb-3 text-xl font-bold">Top 10 Truyện Hot</h2>
      <Tabs value={period} onValueChange={(v) => setPeriod(v as Top10Period)}>
        <TabsList className="w-full">
          <TabsTrigger value="day" className="flex-1">Ngày</TabsTrigger>
          <TabsTrigger value="week" className="flex-1">Tuần</TabsTrigger>
          <TabsTrigger value="month" className="flex-1">Tháng</TabsTrigger>
        </TabsList>
      </Tabs>
      <ol className="divide-y">
        {comics.map((comic, i) => (
          <Top10Item key={comic.id} comic={comic} rank={i + 1} />
        ))}
      </ol>
    </aside>
  )
}
