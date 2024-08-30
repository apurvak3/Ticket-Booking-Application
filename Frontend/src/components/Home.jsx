import React from "react";
import Header from "./header/Header";
import CurrentPlaying from "./movies/currentPlaying";
import ComingSoon from "./movies/ComingSoon";
import SeatBooking from "./SeatBooking/SeatBooking";


function Home() {
  return (
    <>
      <Header />
      <CurrentPlaying />
      <ComingSoon />
      <SeatBooking/>
      
    </>
  );
}

export default Home;
