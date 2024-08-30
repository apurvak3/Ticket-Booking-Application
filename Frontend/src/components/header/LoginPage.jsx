import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';  // Import useNavigate

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [rememberMe, setRememberMe] = useState(false);
  const [error, setError] = useState('');
  const navigate = useNavigate();  // Initialize navigate

  const handleSubmit = (e) => {
    e.preventDefault();
    if (password.length < 4 || password.length > 60) {
      setError('Your password must contain between 4 and 60 characters.');
    } else {
      // Handle sign in logic here
      console.log('Sign in submitted', { email, password, rememberMe });
      
      // After successful sign in, navigate to SeatBooking page
      navigate('/');
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-black bg-opacity-75">
      <div className="bg-black bg-opacity-70 p-8 rounded-lg w-96">
        <h1 className="text-white text-3xl font-bold mb-6">LogIn</h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <input
              type="text"
              placeholder="Email or mobile number"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="w-full p-3 rounded bg-gray-700 text-white"
            />
          </div>
          <div className="mb-4">
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="w-full p-3 rounded bg-gray-700 text-white"
            />
            {error && <p className="text-red-500 text-sm mt-1">{error}</p>}
          </div>
          <button
            type="submit"
            className="w-full bg-red-600 text-white p-3 rounded font-bold"
          >
            Sign In
          </button>
        </form>
        <div className="flex items-center justify-between mt-4">
          <label className="flex items-center text-gray-400">
            <input
              type="checkbox"
              checked={rememberMe}
              onChange={(e) => setRememberMe(e.target.checked)}
              className="mr-2"
            />
            Remember me
          </label>
          <a href="#" className="text-gray-400 hover:underline">Forgot password?</a>
        </div>
        
        <p className="text-gray-400 mt-6">
          New to Fox? <a href="http://localhost:5173/signup" className="text-white hover:underline">Sign up now</a>.
        </p>
      </div>
    </div>
  );
};

export default LoginPage;

