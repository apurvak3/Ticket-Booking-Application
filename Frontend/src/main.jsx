import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import "./index.css";

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import LoginPage from "./components/header/LoginPage.jsx";
import SeatBooking from "./components/SeatBooking/SeatBooking.jsx";
import AuthProvider from "./configs/security/AuthContext.jsx";
import AdminPage from "./AdminPage.jsx";

const router = createBrowserRouter([
  {
    path: "/home",
    element: <App />,
  },
  {
    path: "/auth",
    element: <LoginPage />,
  },
  {
    path: "/Seatbooking",
    element: <SeatBooking />,
  },
  {
    path:"/AdminPage",
    element:<AdminPage/>
  }
]);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <AuthProvider>
      <RouterProvider router={router} />
    </AuthProvider>
  </StrictMode>
);
