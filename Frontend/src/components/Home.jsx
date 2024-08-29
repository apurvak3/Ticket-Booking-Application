import React from "react";
import Header from "./header/Header";
import CurrentPlaying from "./movies/currentPlaying";
import ComingSoon from "./movies/ComingSoon";

function Home() {
  return (
    <>
      <Header />
      <CurrentPlaying/>
      <ComingSoon/>
      
    </>
  );
}

export default Home;
