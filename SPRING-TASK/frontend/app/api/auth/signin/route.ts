import { type NextRequest, NextResponse } from "next/server"

export async function POST(request: NextRequest) {
  try {
    const { email, password } = await request.json()

    // Make request to your backend API
    const response = await fetch(`${process.env.BACKEND_URL}/api/v1/auth/signin`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email, password }),
    })

    if (response.ok) {
      const data = await response.json()

      // Decode JWT to extract user information
      const tokenPayload = JSON.parse(atob(data.accessToken.split(".")[1]))
      const user = tokenPayload.user

      // Return the token and user data in the expected format
      const responseData = {
        token: data.accessToken,
        tokenType: data.tokenType,
        user: user,
      }

      // Set HTTP-only cookie for security
      const responseObj = NextResponse.json(responseData)
      responseObj.cookies.set("auth-token", data.accessToken, {
        httpOnly: true,
        secure: process.env.NODE_ENV === "production",
        sameSite: "strict",
        maxAge: 60 * 60 * 24 * 7, // 7 days
      })

      return responseObj
    } else {
      const errorData = await response.json()
      return NextResponse.json({ message: errorData.message || "Authentication failed" }, { status: response.status })
    }
  } catch (error) {
    console.error("Authentication error:", error)
    return NextResponse.json({ message: "Internal server error" }, { status: 500 })
  }
}
