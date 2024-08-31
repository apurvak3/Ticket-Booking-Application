import React, { createContext, useState } from "react";
import { loginApi } from "../api/AuthApi";

export const AuthContext = createContext();

export default function AuthProvider({ children }) {

    // const [username, setUsername] = useState(null);
    const [authenticated, setAuthenticated] = useState(false);

    const loginService = async (email, password) => {
        try {
            const response = await loginApi(email, password);
            if (response.status === 200) {
                // setUsername(response.data.username);
                setAuthenticated(true);
                localStorage.setItem('token', "Bearer " + response.data.accessToken);
                return true;
            } else {
                setAuthenticated(false);
                return false;
            }
        } catch (error) {
            console.log(error);
            setAuthenticated(false);
            return false;
        }
    }

    return (
        <AuthContext.Provider value={{ loginService, authenticated }}>
            {children}
        </AuthContext.Provider>
    );
}
