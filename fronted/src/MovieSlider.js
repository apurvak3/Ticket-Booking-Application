import React, { useState, useEffect } from 'react';

const movies = [
    { id: 1, title: 'Vedaa', image: 'https://cdn.123telugu.com/content/wp-content/uploads/2024/08/vedaa-m.jpg'},
    { id: 2, title: 'Khel Khel Mein', image: 'https://cinenil.com/wp-content/uploads/2024/07/Khel-Khel-Mein.webp' },
    { id: 3, title: 'Stree 2', image: 'https://images.hindustantimes.com/img/2024/08/15/550x309/stree_2_review_shraddha_kapoor_rajkummar_rao_1723692734817_1723692735009.jpg'},
    {id: 4, title: 'Alein: Romulus', image: 'https://www.nwpb.org/wp-content/uploads/2024/08/wiziwiz-alien-romulus-poster-.webp'},
  ];

function MovieSlider() {
  const [currentMovie, setCurrentMovie] = useState(0);
  const [showTrailer, setShowTrailer] = useState(false);
  const [trailerTimer, setTrailerTimer] = useState(null);

  useEffect(() => {
    const timer = setInterval(() => {
      setCurrentMovie((prevMovie) => (prevMovie + 1) % movies.length);
    }, 3000);

    return () => clearInterval(timer);
  }, []);

  const handleMouseEnter = () => {
    setTrailerTimer(setTimeout(() => setShowTrailer(true), 5000));
  };

  const handleMouseLeave = () => {
    clearTimeout(trailerTimer);
    setShowTrailer(false);
  };

  return (
    <div 
      className="movie-slider"
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
    >
      <img src={movies[currentMovie].image} alt={movies[currentMovie].title} />
      {showTrailer && (
        <div className="trailer">
          {/* Here you would typically embed a video player */}
          <p>Trailer for {movies[currentMovie].title}</p>
        </div>
      )}
    </div>
  );
}

export default MovieSlider;