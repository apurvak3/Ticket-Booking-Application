import React from "react";
import Header from "./header/Header";
import CurrentPlaying from "./movies/currentPlaying";
import ComingSoon from "./movies/ComingSoon";
import LoginPage from "./header/LoginPage";

function Home() {
  return (
    <>
      <Header />
      <LoginPage/>
      <CurrentPlaying/>
      <ComingSoon/>
      
    </>
  );
}

export default Home;
