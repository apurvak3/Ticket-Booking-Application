import React from 'react';
import './UpcomingMovies.css';

const upcomingMovies = [
  { id: 1, title: 'The Diary Of West Bengal', image: 'https://m.media-amazon.com/images/M/MV5BMDA0MGEwNzYtOWZlZC00NTRmLTg2MWEtMTliNjg4MjhkMjMyXkEyXkFqcGc@._V1_.jpg', releaseDate: '2024-08-30' },
  { id: 2, title: 'Emergency', image: 'https://upload.wikimedia.org/wikipedia/en/thumb/3/32/Emergency_movie_poster.jpg/220px-Emergency_movie_poster.jpg', releaseDate: '2024-09-06' },
  { id: 3, title: 'Singham Again', image: 'https://www.koimoi.com/wp-content/new-galleries/2024/08/singham-again-001.jpg', releaseDate: '2024-11-01' },
  { id: 4, title: 'Pushpa:The Rule-part2', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQi6JXOkvLD0ttLTKTpq5_uWM_L_lWrH-O8_Q&s', releaseDate: '2024-12-06' },
];

function UpcomingMovies() {
  return (
    <section className="upcoming-movies" id="upcoming">
      <h2>Upcoming Movies</h2>
      <div className="movie-grid">
        {upcomingMovies.map((movie) => (
          <div key={movie.id} className="movie-card">
            <img src={movie.image} alt={movie.title} />
            <div className="movie-info">
              <h3>{movie.title}</h3>
              <p>Release Date: {movie.releaseDate}</p>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}

export default UpcomingMovies;