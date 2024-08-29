import React, { useState } from 'react';

const initialComingSoonMovies = [{
    // Replace these with actual coming soon movie data
    Title: "Game of Thrones",
    Year: "2011–2019",
    imdbID: "tt0944947",
    Type: "series",
    Poster: "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones: The Last Watch",
    Year: "2019",
    imdbID: "tt10090796",
    Type: "movie",
    Poster: "https://m.media-amazon.com/images/M/MV5BZDdlMzQzNDQtNTAxMS00NTMyLTgxYTAtYzQ0OGI1YzZhY2Y3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones: A Telltale Games Series",
    Year: "2014",
    imdbID: "tt3391176",
    Type: "game",
    Poster: "https://m.media-amazon.com/images/M/MV5BODg0YTM4NzEtZDQyNi00M2MzLWE3MDQtNjcxNTkxNWM0NzNhXkEyXkFqcGdeQXVyMjM5NzU3OTM@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones",
    Year: "2012",
    imdbID: "tt2231444",
    Type: "game",
    Poster: "https://m.media-amazon.com/images/M/MV5BMjE5NTk5NDg3OV5BMl5BanBnXkFtZTgwNDExNzg2MDE@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones Conquest & Rebellion: An Animated History of the Seven Kingdoms",
    Year: "2017",
    imdbID: "tt7937220",
    Type: "movie",
    Poster: "https://m.media-amazon.com/images/M/MV5BMGYzNDJiOTgtN2Y1OC00NmM2LTk3MTMtZmFhNmJlMzQzNGNhXkEyXkFqcGdeQXVyNDgyODgxNjE@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones: Season 2 - Character Profiles",
    Year: "2013",
    imdbID: "tt2653342",
    Type: "movie",
    Poster: "https://m.media-amazon.com/images/M/MV5BMTU1MzU2MDE4MV5BMl5BanBnXkFtZTgwNTc3NzA2MDE@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones: The Story So Far",
    Year: "2017",
    imdbID: "tt7136312",
    Type: "movie",
    Poster: "https://m.media-amazon.com/images/M/MV5BZWVjNDJlNzYtMDljNy00Nzc5LTk3YWYtYjNhNGRiZGQ0M2E1XkEyXkFqcGdeQXVyNzY4Njk5MTU@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones: Costumes",
    Year: "2011",
    imdbID: "tt2653350",
    Type: "movie",
    Poster: "https://m.media-amazon.com/images/M/MV5BMTYyODg1MjYzMV5BMl5BanBnXkFtZTgwOTc3NzA2MDE@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones: A Day in the Life",
    Year: "2015",
    imdbID: "tt4437700",
    Type: "movie",
    Poster: "https://m.media-amazon.com/images/M/MV5BMmZhODYxMmMtMjZkNS00YzU0LTlmYzgtNDEzYjgzMTBiNDc0XkEyXkFqcGdeQXVyNDQ5MDYzMTk@._V1_SX300.jpg"
},
{
    Title: "Game of Thrones: Season 2 - Invitation to the Set",
    Year: "2012",
    imdbID: "tt2653340",
    Type: "movie",
    Poster: "https://m.media-amazon.com/images/M/MV5BMTc5MjM4OTkzMV5BMl5BanBnXkFtZTgwMzc3NzA2MDE@._V1_SX300.jpg"
}
];

const MovieCard = ({ movie }) => {
  const [isHovered, setIsHovered] = useState(false);

  return (
    <div 
      className={`relative rounded overflow-hidden shadow-lg cursor-pointer transition-all duration-300 ease-in-out ${isHovered ? 'scale-110 z-10' : ''}`}
      onMouseEnter={() => setIsHovered(true)}
      onMouseLeave={() => setIsHovered(false)}
    >
      <img 
        src={movie.Poster} 
        alt={movie.Title} 
        className="w-full h-full object-cover transition-all duration-300 ease-in-out"
      />
      <div className={`absolute bottom-0 left-0 right-0 bg-black bg-opacity-50 text-white p-2 transition-all duration-300 ease-in-out ${isHovered ? 'bg-opacity-75' : ''}`}>
        <p className={`text-sm font-bold transition-all duration-300 ease-in-out ${isHovered ? 'text-lg' : ''}`}>{movie.Title}</p>
        <p className="text-xs">{movie.Year}</p>
      </div>
    </div>
  );
};

const ComingSoon = () => {
  const [showAll, setShowAll] = useState(false);
  const visibleMovies = showAll ? initialComingSoonMovies : initialComingSoonMovies.slice(0, 6);

  return (
    <div className="p-4">
      <div className="flex justify-between items-center mb-4">
        <h2 className="text-2xl font-bold">Coming Soon</h2>
        <button 
          onClick={() => setShowAll(!showAll)}
          className="text-blue-500 hover:text-blue-700 transition-colors duration-300"
        >
          {showAll ? 'See Less' : 'See More'}
        </button>
      </div>
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-6">
        {visibleMovies.map((movie) => (
          <MovieCard key={movie.imdbID} movie={movie} />
        ))}
      </div>
    </div>
  );
};

export default ComingSoon;