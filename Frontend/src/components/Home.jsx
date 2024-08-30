import React from "react";
import Header from "./header/Header";
import CurrentPlaying from "./movies/currentPlaying";
import ComingSoon from "./movies/ComingSoon";
import LoginPage from "./header/LoginPage";
import SeatBooking from "./SeatBooking/SeatBooking";

function Home() {
  return (
    <>
      <Header />
      <LoginPage/>
      <SeatBooking/>
      <CurrentPlaying/>
      <ComingSoon/>
      
    </>
  );
}

export default Home;
