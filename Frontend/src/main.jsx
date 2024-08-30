import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import "./index.css";

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import LoginPage from "./components/header/LoginPage.jsx";
import SignUp from "./components/header/SignUp.jsx";
import SeatBooking from "./components/SeatBooking/SeatBooking.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "/login",
    element: <LoginPage />,
  },
  {
    path:"/signup",
    element:<SignUp/>,
  },
  {
    path: "/Seatbooking",
    element: <SeatBooking />,
  },
]);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
);
