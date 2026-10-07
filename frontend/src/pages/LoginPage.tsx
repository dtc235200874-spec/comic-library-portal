import { Input } from '@/components/ui/input'
import { Button } from '@/components/ui/button'

export function LoginPage() {
  return (
    <div className="mx-auto max-w-sm">
      <h1 className="mb-4 text-2xl font-bold">Đăng nhập</h1>
      <form className="flex flex-col gap-3" onSubmit={(e) => e.preventDefault()}>
        <Input placeholder="Tên đăng nhập" />
        <Input type="password" placeholder="Mật khẩu" />
        <Button type="submit">Đăng nhập</Button>
      </form>
    </div>
  )
}
