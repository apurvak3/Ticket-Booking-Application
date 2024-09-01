import React, { useState } from 'react';
import { PlusCircle } from 'lucide-react';

const AdminPage = () => {
  const [movies, setMovies] = useState([]);
  const [theaters, setTheaters] = useState([]);
  const [newMovie, setNewMovie] = useState('');
  const [newTheater, setNewTheater] = useState('');

  const addMovie = () => {
    if (newMovie.trim() !== '') {
      setMovies([...movies, newMovie.trim()]);
      setNewMovie('');
    }
  };

  const addTheater = () => {
    if (newTheater.trim() !== '') {
      setTheaters([...theaters, newTheater.trim()]);
      setNewTheater('');
    }
  };

  return (
    <div className="min-h-screen bg-gray-100"> {/* Added background color */}
      <div className="container mx-auto p-6"> {/* Increased padding */}
        <h1 className="text-3xl font-bold mb-6 text-gray-800">Admin Page</h1> {/* Increased text size and margin */}
        
        <div className="bg-white rounded-lg shadow-md p-6 mb-8"> {/* Added white background and shadow */}
          <h2 className="text-2xl font-semibold mb-4 text-gray-700">Movies</h2>
          <div className="flex items-center mb-4">
            <input
              type="text"
              value={newMovie}
              onChange={(e) => setNewMovie(e.target.value)}
              className="border rounded-l px-4 py-2 w-full focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Enter movie name"
            />
            <button
              onClick={addMovie}
              className="bg-blue-500 text-white px-6 py-2 rounded-r hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 flex items-center"
            >
              <PlusCircle className="mr-2" size={18} />
              Add
            </button>
          </div>
          <ul className="list-disc pl-5 text-gray-700">
            {movies.map((movie, index) => (
              <li key={index} className="mb-1">{movie}</li>
            ))}
          </ul>
        </div>
        
        <div className="bg-white rounded-lg shadow-md p-6"> {/* Added white background and shadow */}
          <h2 className="text-2xl font-semibold mb-4 text-gray-700">Theaters</h2>
          <div className="flex items-center mb-4">
            <input
              type="text"
              value={newTheater}
              onChange={(e) => setNewTheater(e.target.value)}
              className="border rounded-l px-4 py-2 w-full focus:outline-none focus:ring-2 focus:ring-green-500"
              placeholder="Enter theater name"
            />
            <button
              onClick={addTheater}
              className="bg-green-500 text-white px-6 py-2 rounded-r hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-500 flex items-center"
            >
              <PlusCircle className="mr-2" size={18} />
              Add
            </button>
          </div>
          <ul className="list-disc pl-5 text-gray-700">
            {theaters.map((theater, index) => (
              <li key={index} className="mb-1">{theater}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default AdminPage;