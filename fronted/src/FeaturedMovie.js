import React from 'react';
import './FeaturedMovies.css';

const featuredMovies = [
  { id: 1, title: 'Stree 2', image: 'https://images.hindustantimes.com/img/2024/08/15/550x309/stree_2_review_shraddha_kapoor_rajkummar_rao_1723692734817_1723692735009.jpg' },
  { id: 2, title: 'Vedaa', image:'https://cdn.123telugu.com/content/wp-content/uploads/2024/08/vedaa-m.jpg' },
  { id: 3, title: 'Khel khel mein', image: 'https://cinenil.com/wp-content/uploads/2024/07/Khel-Khel-Mein.webp' },
  { id: 3, title: 'Alein:Romulus', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSR9aWtS7Qi2j90FnmtfNr3xJjakAXxvwZulA&s' },
];

function FeaturedMovies() {
  return (
    <section className="featured-movies">
      <h2>Featured Movies</h2>
      <div className="movie-grid">
        {featuredMovies.map((movie) => (
          <div key={movie.id} className="movie-card">
            <img src={movie.image} alt={movie.title} />
            <h3>{movie.title}</h3>
          </div>
        ))}
      </div>
    </section>
  );
}

export default FeaturedMovies;