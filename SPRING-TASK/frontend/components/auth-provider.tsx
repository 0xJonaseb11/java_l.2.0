"use client"

import type React from "react"

import { createContext, useContext, useEffect, useState } from "react"
import { useRouter } from "next/navigation"

interface Role {
  id: string
  name: string
}

interface User {
  id: string
  email: string
  firstName: string
  lastName: string
  mobile: string
  gender: string
  status: string
  roles: Role[]
}

interface AuthContextType {
  user: User | null
  token: string | null
  login: (token: string, user: User) => void
  logout: () => void
  isLoading: boolean
  hasRole: (roleName: string) => boolean
}

const AuthContext = createContext<AuthContextType | undefined>(undefined)

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [user, setUser] = useState<User | null>(null)
  const [token, setToken] = useState<string | null>(null)
  const [isLoading, setIsLoading] = useState(true)
  const router = useRouter()

  useEffect(() => {
    // Check for stored auth data on mount
    const storedToken = localStorage.getItem("auth-token")
    const storedUser = localStorage.getItem("auth-user")

    if (storedToken && storedUser) {
      try {
        // Verify token is not expired
        const tokenPayload = JSON.parse(atob(storedToken.split(".")[1]))
        const currentTime = Date.now() / 1000

        if (tokenPayload.exp > currentTime) {
          setToken(storedToken)
          setUser(JSON.parse(storedUser))
        } else {
          // Token expired, clear storage
          localStorage.removeItem("auth-token")
          localStorage.removeItem("auth-user")
        }
      } catch (error) {
        // Invalid token, clear storage
        localStorage.removeItem("auth-token")
        localStorage.removeItem("auth-user")
      }
    }
    setIsLoading(false)
  }, [])

  const login = (newToken: string, newUser: User) => {
    setToken(newToken)
    setUser(newUser)
    localStorage.setItem("auth-token", newToken)
    localStorage.setItem("auth-user", JSON.stringify(newUser))
  }

  const logout = () => {
    setToken(null)
    setUser(null)
    localStorage.removeItem("auth-token")
    localStorage.removeItem("auth-user")
    router.push("/auth/signin")
  }

  const hasRole = (roleName: string): boolean => {
    return user?.roles?.some((role) => role.name === roleName) || false
  }

  return (
    <AuthContext.Provider value={{ user, token, login, logout, isLoading, hasRole }}>{children}</AuthContext.Provider>
  )
}

export function useAuth() {
  const context = useContext(AuthContext)
  if (context === undefined) {
    throw new Error("useAuth must be used within an AuthProvider")
  }
  return context
}
