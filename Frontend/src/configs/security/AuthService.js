import { loginApi } from "../api/AuthApi";

const API_URL = "http://localhost:8080";

const loginService = async (email, password) => {
    try {
        const response  = await loginApi(email, password);
        console.log(response)
        
    } catch (error) {
        console.log(error);
    }
    
}

export {loginService};