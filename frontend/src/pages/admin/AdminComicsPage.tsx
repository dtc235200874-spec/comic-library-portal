import { Link } from 'react-router-dom'
import { comics } from '@/mocks/data'

export function AdminComicsPage() {
  return (
    <div>
      <div className="mb-4 flex items-center justify-between">
        <h1 className="text-2xl font-bold">Quản lý truyện</h1>
        <Link to="/admin/comics/new" className="rounded bg-primary px-3 py-2 text-sm text-primary-foreground">
          Thêm truyện
        </Link>
      </div>
      <table className="w-full text-sm">
        <thead>
          <tr className="border-b text-left">
            <th className="py-2">Tên</th>
            <th>Tác giả</th>
            <th>Trạng thái</th>
          </tr>
        </thead>
        <tbody>
          {comics.map((c) => (
            <tr key={c.id} className="border-b">
              <td className="py-2">
                <Link to={`/admin/comics/${c.id}`} className="hover:underline">{c.title}</Link>
              </td>
              <td>{c.author}</td>
              <td>{c.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}
