import { type NextRequest, NextResponse } from "next/server"
import { cookies } from "next/headers"

export async function POST(request: NextRequest) {
  try {
    const cookieStore = await cookies()
    const token = cookieStore.get("auth-token")
    const formData = await request.formData()

    const response = await fetch(`${process.env.BACKEND_URL}/api/v1/files/upload`, {
      method: "POST",
      headers: {
        Authorization: `Bearer ${token?.value}`,
      },
      body: formData,
    })

    if (response.ok) {
      const data = await response.json()
      return NextResponse.json(data)
    } else {
      const errorData = await response.json()
      return NextResponse.json({ message: errorData.message || "Failed to upload file" }, { status: response.status })
    }
  } catch (error) {
    return NextResponse.json({ message: "Internal server error" }, { status: 500 })
  }
}
