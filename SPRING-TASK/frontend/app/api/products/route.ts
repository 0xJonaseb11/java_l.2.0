import { type NextRequest, NextResponse } from "next/server";
import { cookies } from "next/headers";

export async function GET() {
  try {
    const cookieStore = await cookies();
    const token = cookieStore.get("auth-token");

    const response = await fetch(`${process.env.BACKEND_URL}/api/v1/products`, {
      headers: {
        Authorization: `Bearer ${token?.value}`,
        "Content-Type": "application/json",
      },
    });

    if (response.ok) {
      const data = await response.json();
      return NextResponse.json(data);
    } else {
      return NextResponse.json(
        { message: "Failed to fetch products" },
        { status: response.status }
      );
    }
  } catch (error) {
    return NextResponse.json(
      { message: "Internal server error" },
      { status: 500 }
    );
  }
}

export async function POST(request: NextRequest) {
  try {
    const cookieStore = await cookies();
    const token = cookieStore.get("auth-token");
    const productDto = await request.json();

    // Ensure the data matches ProductDto structure exactly
    const requestBody = {
      name: productDto.name,
      description: productDto.description,
      price: productDto.price,
      quantity: productDto.quantity,
      category: productDto.category,
      inventory: {
        quantity: productDto.inventory.quantity,
        location: productDto.inventory.location,
      },
    };

    console.log("Sending to backend:", JSON.stringify(requestBody, null, 2));

    const response = await fetch(`${process.env.BACKEND_URL}/api/v1/products`, {
      method: "POST",
      headers: {
        Authorization: `Bearer ${token?.value}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestBody),
    });

    if (response.ok) {
      const data = await response.json();
      return NextResponse.json(data);
    } else {
      const errorData = await response.json();
      return NextResponse.json(
        { message: errorData.message || "Failed to create product" },
        { status: response.status }
      );
    }
  } catch (error) {
    console.error("Product creation error:", error);
    return NextResponse.json(
      { message: "Internal server error" },
      { status: 500 }
    );
  }
}
