import { Link } from 'react-router-dom'
import { Bell } from 'lucide-react'
import { SearchBar } from '@/components/SearchBar'
import { MainNavigation } from '@/components/MainNavigation'
import { Button } from '@/components/ui/button'

export function Header() {
  return (
    <header className="sticky top-0 z-40 border-b bg-background/95 backdrop-blur">
      <div className="mx-auto flex h-16 max-w-7xl items-center gap-4 px-4">
        <Link to="/" className="text-xl font-bold text-primary">
          Comic Portal
        </Link>
        <SearchBar />
        <button className="rounded-md p-2 text-muted-foreground hover:bg-accent" aria-label="Thông báo">
          <Bell className="h-5 w-5" />
        </button>
        <Link to="/login">
          <Button variant="outline">Đăng nhập</Button>
        </Link>
      </div>
      <MainNavigation />
    </header>
  )
}
