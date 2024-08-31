import { Axios } from "axios";

const ApiClient = Axios.create(
    {
        baseURL : "http://localhost:8080"
    }
);

ApiCliconstent.interceptors.request.use((config) => {
    config.headers.Authorization = localStorage.getItem('token');
    return config;
});

export default ApiClient;
