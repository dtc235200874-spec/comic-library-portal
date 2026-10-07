import { NavLink } from 'react-router-dom'

const navItems = [
  { to: '/', label: 'Trang chủ' },
  { to: '/popular', label: 'Phổ biến' },
  { to: '/genres', label: 'Thể loại' },
  { to: '/history', label: 'Lịch sử' },
]

export function MainNavigation() {
  return (
    <nav className="mx-auto flex max-w-7xl gap-4 overflow-x-auto px-4 pb-2 text-sm">
      {navItems.map((item) => (
        <NavLink
          key={item.to}
          to={item.to}
          className={({ isActive }) =>
            isActive ? 'font-semibold text-primary' : 'text-muted-foreground hover:text-foreground'
          }
        >
          {item.label}
        </NavLink>
      ))}
    </nav>
  )
}
