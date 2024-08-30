import React, { useState } from 'react';
import { Calendar, Clock, Film, LogIn } from 'lucide-react';

// Login Component
const Login = ({ onLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    // In a real app, you'd validate credentials here
    onLogin(username);
  };

  return (
    <div className="max-w-md mx-auto mt-10 p-6 bg-gray-800 rounded-lg">
      <h2 className="text-2xl font-bold mb-4 flex items-center"><LogIn className="mr-2" /> Login</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className="w-full p-2 mb-4 bg-gray-700 rounded"
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="w-full p-2 mb-4 bg-gray-700 rounded"
        />
        <button type="submit" className="w-full bg-red-600 py-2 rounded font-semibold">
          Login
        </button>
      </form>
    </div>
  );
};

// Movie Selection Component
const MovieSelection = ({ onSelectMovie }) => {
  const movies = [
    { id: 1, title: 'Spirited Away', duration: '2h 5m' },
    { id: 2, title: 'My Neighbor Totoro', duration: '1h 26m' },
    { id: 3, title: 'Princess Mononoke', duration: '2h 14m' },
  ];

  return (
    <div className="max-w-2xl mx-auto mt-10 p-6 bg-gray-800 rounded-lg">
      <h2 className="text-2xl font-bold mb-4 flex items-center"><Film className="mr-2" /> Select a Movie</h2>
      <div className="grid grid-cols-1 gap-4">
        {movies.map((movie) => (
          <button
            key={movie.id}
            onClick={() => onSelectMovie(movie)}
            className="bg-gray-700 p-4 rounded-lg text-left hover:bg-gray-600 transition"
          >
            <h3 className="text-xl font-semibold">{movie.title}</h3>
            <p className="text-gray-400">{movie.duration}</p>
          </button>
        ))}
      </div>
    </div>
  );
};

// Movie Booking Component (modified from previous version)
const MovieBooking = ({ movie, onBack }) => {
  // ... (previous state and handlers)

  return (
    <div className="max-w-4xl mx-auto mt-10 bg-gray-900 text-white p-6 rounded-lg">
      <button onClick={onBack} className="mb-4 bg-gray-700 px-4 py-2 rounded">
        Back to Movies
      </button>
      <div className="flex flex-col md:flex-row">
        {/* Movie Poster */}
        <div className="w-full md:w-1/2 relative mb-4 md:mb-0">
          <img src="/api/placeholder/400/600" alt={movie.title} className="w-full h-auto rounded-lg" />
          <div className="absolute bottom-0 left-0 p-4 bg-black bg-opacity-50 w-full rounded-b-lg">
            <h2 className="text-2xl font-bold">{movie.title}</h2>
            <p>{movie.duration}</p>
          </div>
        </div>

        {/* Booking Interface */}
        <div className="w-full md:w-1/2 md:pl-4">
          {/* Date Selection */}
          {/* ... (rest of the booking interface) */}
        </div>
      </div>
    </div>
  );
};

// Main App Component
const MovieBookingApp = () => {
  const [user, setUser] = useState(null);
  const [selectedMovie, setSelectedMovie] = useState(null);

  const handleLogin = (username) => {
    setUser(username);
  };

  const handleSelectMovie = (movie) => {
    setSelectedMovie(movie);
  };

  const handleBackToMovies = () => {
    setSelectedMovie(null);
  };

  if (!user) {
    return <Login onLogin={handleLogin} />;
  }

  if (!selectedMovie) {
    return <MovieSelection onSelectMovie={handleSelectMovie} />;
  }

  return <MovieBooking movie={selectedMovie} onBack={handleBackToMovies} />;
};

export default MovieBookingApp;