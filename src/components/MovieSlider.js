import React, { useState, useEffect } from 'react';

const movies = [
  { id: 1, title: 'Kalki', image: 'https://images.hindustantimes.com/img/2024/08/17/1600x900/Kalki_2898_AD_OTT_release_1723868283514_1723868283753.jpg', trailer: 'https://www.youtube.com/watch?v=y1-w1kUGuz8' },
  { id: 2, title: 'Khel Khel Mein', image: 'https://cinenil.com/wp-content/uploads/2024/07/Khel-Khel-Mein.webp', trailer: 'https://www.youtube.com/watch?v=RKZJtoFoaQg&t=39s' },
  { id: 3, title: 'Stree 2', image: 'https://images.hindustantimes.com/img/2024/08/15/550x309/stree_2_review_shraddha_kapoor_rajkummar_rao_1723692734817_1723692735009.jpg', trailer: 'https://www.youtube.com/watch?v=KVnheXywIbY' },
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