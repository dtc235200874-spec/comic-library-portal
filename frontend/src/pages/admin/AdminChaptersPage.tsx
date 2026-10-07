import { useParams } from 'react-router-dom'

export function AdminChaptersPage() {
  const { id } = useParams()
  return (
    <div>
      <h1 className="text-2xl font-bold">Quản lý chapter - Truyện #{id}</h1>
      <p className="text-muted-foreground">Danh sách chapter và upload ảnh (sắp phát triển).</p>
    </div>
  )
}
