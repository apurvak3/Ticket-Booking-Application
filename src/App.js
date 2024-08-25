import React from 'react';
import Navbar from './components/Navbar';
import Header from './components/Header';
import FeaturedMovies from './components/FeaturedMovies';
import UpcomingMovies from './components/UpcomingMovies';
import AboutUs from './components/Aboutus';
import Footer from './components/Footer';
import './App.css';

function App() {
  return (
    <div className="App">
      <Navbar />
      <Header />
      <FeaturedMovies />
      <UpcomingMovies />
      <AboutUs />
      <Footer />
    </div>
  );
}

export default App;