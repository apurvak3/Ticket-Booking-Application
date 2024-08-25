import React from 'react';
import Navbar from './Navbar';
import Header from './Header';
import UpcomingMovies from './UpcomingMovies';
import AboutUs from './AboutUs';
import Footer from './Footer';
import FeaturedMovies from './FeaturedMovie';

import './App.css';

function App() {
  return (
    <div className="App">
      <Navbar />
      <Header />
      <FeaturedMovies/>
      <UpcomingMovies />
      <AboutUs />
      <Footer />
      
      
    </div>
  );
}

export default App;