import React from "react";
import { createContext } from "react";
import { loginApi } from "../api/AuthApi";

export const AuthContext = createContext();

export default function AuthProvider( {children} ) {

    const [username, setUsername] = useState(null);
    const [authenticated, setAuthenticated] = useState(false);

    const loginService = async (email, password) => {
        try {
            const response  = await loginApi(email, password);
            if(response.status === 200) {
                // setUsername(response.data.username);
                localStorage.setItem('token', "Bearer " + response.data.accessToken);
                return true;
            } else {
                return false;
            }
        } catch (error) {
            console.log(error);
        }
        
    }

    return (
        <AuthContext.Provider value={{loginService}}>
            {children}
        </AuthContext.Provider>
    );

}