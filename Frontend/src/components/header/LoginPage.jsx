import React, { useState } from 'react';
import { Link, useNavigate, useSearchParams } from 'react-router-dom';  // Import useNavigate
import { loginService } from '../../configs/security/AuthContext';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [name, setName] = useState('');
  const [rememberMe, setRememberMe] = useState(false);
  const [error, setError] = useState('');
  const navigate = useNavigate();  // Initialize navigate
  const [searchPrams] = useSearchParams();

  const login = searchPrams.get('mode') === "login";
  console.log(searchPrams.get('mode'));

  const handleLogin = (e) => {
    e.preventDefault();
    if(loginService(email, password)) {
      navigate('/home');
    } else {
      setError("Invalid Credentials.")
    }
  };

  const handleSignup = (e) => {
    e.preventDefault();
    
  }

  return (
    <div className="min-h-screen flex items-center justify-center bg-black bg-opacity-75">
      <div className="bg-black bg-opacity-70 p-8 rounded-lg w-96">
        <h1 className="text-white text-4xl font-bold">
          {login ? "Welcome Back" : "Sign Up"}
        </h1>
        <p className='text-white mb-8'>
          {login ? "Enter you details to sign in." : "Enter you personal details."}
        </p>
        <form onSubmit={handleLogin}>
          {
            !login && 
          
            <div className="mb-4">
              <input
                type="text"
                placeholder="Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                className="w-full p-3 rounded bg-gray-700 text-white"
              />
            </div>
          }
          <div className="mb-4">
            <input
              type="text"
              placeholder="Email"
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
          {
            login &&
            <Link to="/" className="text-gray-400 hover:underline">Forgot password?</Link>
          }
        </div>
        
        <p className="text-gray-400 mt-6">
          {login ? 
            <>
              New to Fox? <Link to="/auth?mode=signup" className="text-white hover:underline">
                Sign up
              </Link>.
            </> :
            <>
              Already have an account <Link to="/auth?mode=login" className="text-white hover:underline">
                Login
              </Link>.
            </>
          }
        </p>
      </div>
    </div>
  );
};

export default LoginPage;

