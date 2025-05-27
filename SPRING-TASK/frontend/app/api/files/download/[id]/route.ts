import { type NextRequest, NextResponse } from "next/server"
import { cookies } from "next/headers"

export async function GET(request: NextRequest, { params }: { params: Promise<{ id: string }> }) {
  try {
    const { id } = await params
    const cookieStore = await cookies()
    const token = cookieStore.get("auth-token")

    const response = await fetch(`${process.env.BACKEND_URL}/api/v1/files/download/${id}`, {
      headers: {
        Authorization: `Bearer ${token?.value}`,
      },
    })

    if (response.ok) {
      const blob = await response.blob()
      return new NextResponse(blob, {
        headers: {
          "Content-Type": response.headers.get("Content-Type") || "application/octet-stream",
          "Content-Disposition": response.headers.get("Content-Disposition") || "attachment",
        },
      })
    } else {
      return NextResponse.json({ message: "File not found" }, { status: response.status })
    }
  } catch (error) {
    return NextResponse.json({ message: "Internal server error" }, { status: 500 })
  }
}
