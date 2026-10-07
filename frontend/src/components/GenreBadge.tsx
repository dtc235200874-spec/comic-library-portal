import { Badge } from '@/components/ui/badge'

export function GenreBadge({ name }: { name: string }) {
  return <Badge variant="secondary">{name}</Badge>
}
