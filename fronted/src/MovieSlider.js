import React  from 'react';

const movies = [
  { id: 1, title: 'Kalki', image: 'https://images.hindustantimes.com/img/2024/08/17/1600x900/Kalki_2898_AD_OTT_release_1723868283514_1723868283753.jpg'},
  { id: 2, title: 'Khel Khel Mein', image: 'https://cinenil.com/wp-content/uploads/2024/07/Khel-Khel-Mein.webp' },
  { id: 3, title: 'Stree 2', image: 'https://images.hindustantimes.com/img/2024/08/15/550x309/stree_2_review_shraddha_kapoor_rajkummar_rao_1723692734817_1723692735009.jpg' },
];

function MovieSlider() {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
    pauseOnHover: true
  };

  return (
    <div className="movie-slider-container">
      <MovieSlider {...settings}>
        {movies.map((movie) => (
          <div key={movie.id} className="slider-item">
            <img src={movie.image} alt={movie.title} />
            <h3>{movie.title}</h3>
          </div>
        ))}
      </MovieSlider>
    </div>
  );
}

export default MovieSlider;