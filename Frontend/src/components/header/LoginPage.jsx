import React, { useState } from 'react';
import { LogIn } from 'lucide-react';

// Login Modal Component
const LoginModal = ({ isOpen, onClose, onLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    onLogin(username);
    onClose();
  };

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
      <div className="bg-gray-800 p-6 rounded-lg w-full max-w-md">
        <h2 className="text-2xl font-bold mb-4 flex items-center text-white">
          <LogIn className="mr-2" /> Login
        </h2>
        <form onSubmit={handleLogin}>
          <input
            type="text"
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            className="w-full p-2 mb-4 bg-gray-700 rounded text-white"
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="w-full p-2 mb-4 bg-gray-700 rounded text-white"
          />
          <button type="submit" className="w-full bg-red-600 py-2 rounded font-semibold text-white">
            LogIn
          </button>
        </form>
      </div>
    </div>
  );
};

// Main Page Component with Navbar and Login Button
const LoginPage = () => {
  const [user, setUser] = useState(null);
  const [isLoginModalOpen, setIsLoginModalOpen] = useState(false);

  const handleLogin = (username) => {
    setUser(username);
    alert(`Welcome, ${username}!`);
  };

  return (
    <div className="min-h-screen bg-gray-100">
      {/* Navbar */}
      <nav className="bg-gray-800 p-4">
        <div className="max-w-7xl mx-auto flex justify-between items-center">
          
          <div>
            {user ? (
              <span className="text-white">Hello, {user}!</span>
            ) : (
              <button
                onClick={() => setIsLoginModalOpen(true)}
                className="bg-red-600 text-white px-4 py-2 rounded"
              >
                LogIn
              </button>
            )}
          </div>
        </div>
      </nav>

      {/* Render the login modal when isLoginModalOpen is true */}
      <LoginModal
        isOpen={isLoginModalOpen}
        onClose={() => setIsLoginModalOpen(false)}
        onLogin={handleLogin}
      />
    </div>
  );
};

export default LoginPage;
