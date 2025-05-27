"use client"

import { useEffect, useState } from "react"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Package, Users, FileText, TrendingUp, AlertTriangle } from "lucide-react"
import { DashboardLayout } from "@/components/dashboard-layout"
import { useAuth } from "@/components/auth-provider"

interface DashboardStats {
  totalProducts: number
  totalUsers: number
  totalFiles: number
  lowStockProducts: number
  recentActivity: Array<{
    id: string
    type: string
    message: string
    timestamp: string
  }>
}

export default function DashboardPage() {
  const [stats, setStats] = useState<DashboardStats | null>(null)
  const [isLoading, setIsLoading] = useState(true)
  const { user } = useAuth()

  useEffect(() => {
    const fetchStats = async () => {
      try {
        // Simulate API calls to get dashboard stats
        const [productsRes, usersRes] = await Promise.all([fetch("/api/products"), fetch("/api/users")])

        const products = await productsRes.json()
        const users = await usersRes.json()

        setStats({
          totalProducts: products.length || 0,
          totalUsers: users.length || 0,
          totalFiles: 12, // Mock data
          lowStockProducts: products.filter((p: any) => p.quantity < 10).length || 0,
          recentActivity: [
            {
              id: "1",
              type: "product",
              message: "New product 'Wireless Headphones' added",
              timestamp: "2 hours ago",
            },
            {
              id: "2",
              type: "user",
              message: "User John Doe registered",
              timestamp: "4 hours ago",
            },
            {
              id: "3",
              type: "inventory",
              message: "Low stock alert for 'Gaming Mouse'",
              timestamp: "6 hours ago",
            },
          ],
        })
      } catch (error) {
        console.error("Failed to fetch dashboard stats:", error)
      } finally {
        setIsLoading(false)
      }
    }

    fetchStats()
  }, [])

  if (isLoading) {
    return (
      <DashboardLayout>
        <div className="flex items-center justify-center h-64">
          <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-primary"></div>
        </div>
      </DashboardLayout>
    )
  }

  return (
    <DashboardLayout>
      <div className="space-y-6">
        <div>
          <h1 className="text-3xl font-bold">Dashboard</h1>
          <p className="text-muted-foreground">
            Welcome back, {user?.firstName}!
            {user?.roles && user.roles.length > 0 && (
              <span className="ml-1">({user.roles.map((role) => role.name).join(", ")})</span>
            )}{" "}
            Here's what's happening with your inventory.
          </p>
        </div>

        <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
          <Card>
            <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
              <CardTitle className="text-sm font-medium">Total Products</CardTitle>
              <Package className="h-4 w-4 text-muted-foreground" />
            </CardHeader>
            <CardContent>
              <div className="text-2xl font-bold">{stats?.totalProducts || 0}</div>
              <p className="text-xs text-muted-foreground">
                <span className="text-green-600">+12%</span> from last month
              </p>
            </CardContent>
          </Card>

          <Card>
            <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
              <CardTitle className="text-sm font-medium">Total Users</CardTitle>
              <Users className="h-4 w-4 text-muted-foreground" />
            </CardHeader>
            <CardContent>
              <div className="text-2xl font-bold">{stats?.totalUsers || 0}</div>
              <p className="text-xs text-muted-foreground">
                <span className="text-green-600">+5%</span> from last month
              </p>
            </CardContent>
          </Card>

          <Card>
            <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
              <CardTitle className="text-sm font-medium">Files Uploaded</CardTitle>
              <FileText className="h-4 w-4 text-muted-foreground" />
            </CardHeader>
            <CardContent>
              <div className="text-2xl font-bold">{stats?.totalFiles || 0}</div>
              <p className="text-xs text-muted-foreground">
                <span className="text-green-600">+8%</span> from last month
              </p>
            </CardContent>
          </Card>

          <Card>
            <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
              <CardTitle className="text-sm font-medium">Low Stock Alerts</CardTitle>
              <AlertTriangle className="h-4 w-4 text-muted-foreground" />
            </CardHeader>
            <CardContent>
              <div className="text-2xl font-bold text-orange-600">{stats?.lowStockProducts || 0}</div>
              <p className="text-xs text-muted-foreground">Items below threshold</p>
            </CardContent>
          </Card>
        </div>

        <div className="grid gap-4 md:grid-cols-2">
          <Card>
            <CardHeader>
              <CardTitle>Recent Activity</CardTitle>
              <CardDescription>Latest updates from your system</CardDescription>
            </CardHeader>
            <CardContent className="space-y-4">
              {stats?.recentActivity.map((activity) => (
                <div key={activity.id} className="flex items-center space-x-4">
                  <div className="flex-shrink-0">
                    {activity.type === "product" && <Package className="h-4 w-4 text-blue-600" />}
                    {activity.type === "user" && <Users className="h-4 w-4 text-green-600" />}
                    {activity.type === "inventory" && <AlertTriangle className="h-4 w-4 text-orange-600" />}
                  </div>
                  <div className="flex-1 min-w-0">
                    <p className="text-sm font-medium">{activity.message}</p>
                    <p className="text-xs text-muted-foreground">{activity.timestamp}</p>
                  </div>
                </div>
              ))}
            </CardContent>
          </Card>

          <Card>
            <CardHeader>
              <CardTitle>Quick Actions</CardTitle>
              <CardDescription>Common tasks you might want to perform</CardDescription>
            </CardHeader>
            <CardContent className="space-y-4">
              <div className="grid gap-2">
                <Badge variant="outline" className="justify-start p-3 cursor-pointer hover:bg-muted">
                  <Package className="h-4 w-4 mr-2" />
                  Add New Product
                </Badge>
                <Badge variant="outline" className="justify-start p-3 cursor-pointer hover:bg-muted">
                  <Users className="h-4 w-4 mr-2" />
                  Manage Users
                </Badge>
                <Badge variant="outline" className="justify-start p-3 cursor-pointer hover:bg-muted">
                  <TrendingUp className="h-4 w-4 mr-2" />
                  View Reports
                </Badge>
                <Badge variant="outline" className="justify-start p-3 cursor-pointer hover:bg-muted">
                  <FileText className="h-4 w-4 mr-2" />
                  Upload Files
                </Badge>
              </div>
            </CardContent>
          </Card>
        </div>
      </div>
    </DashboardLayout>
  )
}
