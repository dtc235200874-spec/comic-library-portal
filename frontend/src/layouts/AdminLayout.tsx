import { Link, Outlet } from 'react-router-dom'

const adminNav = [
  { to: '/admin', label: 'Dashboard' },
  { to: '/admin/comics', label: 'Quản lý truyện' },
  { to: '/admin/comics', label: 'Quản lý chapter' },
  { to: '/genres', label: 'Quản lý thể loại' },
]

export function AdminLayout() {
  return (
    <div className="flex min-h-screen">
      <aside className="w-60 border-r bg-muted/40 p-4">
        <Link to="/" className="mb-4 block text-lg font-bold text-primary">
          Comic Portal Admin
        </Link>
        <nav className="flex flex-col gap-2 text-sm">
          {adminNav.map((item, i) => (
            <Link key={i} to={item.to} className="rounded px-2 py-1 hover:bg-accent">
              {item.label}
            </Link>
          ))}
        </nav>
      </aside>
      <main className="flex-1 p-6">
        <Outlet />
      </main>
    </div>
  )
}
