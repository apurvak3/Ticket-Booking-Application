import "./App.css";
import Home from "./components/Home";
import AuthProvider from "./configs/security/AuthContext";

function App() {
  return (
    <AuthProvider>
      <Home />
    </AuthProvider>
  );
}

export default App;
