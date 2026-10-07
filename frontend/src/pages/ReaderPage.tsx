import { useParams } from 'react-router-dom'

export function ReaderPage() {
  const { id, chapterId } = useParams()
  return (
    <div>
      <h1 className="text-xl font-bold">Đọc truyện #{id} - Chapter {chapterId}</h1>
      <p className="text-muted-foreground">Trang đọc truyện đang được phát triển.</p>
    </div>
  )
}
