import axios from "axios"; // Correct import

const ApiClient = axios.create({
    baseURL: "http://localhost:8080"
});

// Fix the typo and properly attach the interceptor
ApiClient.interceptors.request.use((config) => {
    const token = localStorage.getItem('token'); // Get token from localStorage
    if (token) {
        config.headers.Authorization = `Bearer ${token}`; // Set Authorization header
    }
    return config;
}, (error) => {
    return Promise.reject(error);
});

export default ApiClient;

