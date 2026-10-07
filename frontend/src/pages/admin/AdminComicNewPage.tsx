import { Input } from '@/components/ui/input'
import { Button } from '@/components/ui/button'

export function AdminComicNewPage() {
  return (
    <div className="max-w-lg">
      <h1 className="mb-4 text-2xl font-bold">Thêm truyện mới</h1>
      <form className="flex flex-col gap-3" onSubmit={(e) => e.preventDefault()}>
        <Input placeholder="Tên truyện" />
        <Input placeholder="Tên thay thế" />
        <Input placeholder="Tác giả" />
        <Input placeholder="Ảnh bìa (URL)" />
        <Button type="submit">Lưu truyện</Button>
      </form>
    </div>
  )
}
