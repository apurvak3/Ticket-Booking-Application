import React from "react";
import Header from "./header/Header";
import CurrentPlaying from "./movies/currentPlaying";
import ComingSoon from "./movies/ComingSoon";
import Footer from "./Footer/Footer";


function Home() {
  return (
    <>
      <Header />
      <CurrentPlaying />
      <ComingSoon />    
      <Footer/>  
    </>
  );
}

export default Home;
