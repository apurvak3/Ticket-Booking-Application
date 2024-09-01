import React, { createContext, useState } from "react";
import { loginApi, signupApi } from "../api/AuthApi";

export const AuthContext = createContext();

export default function AuthProvider({ children }) {

    const [name, setName] = useState(null);
    const [authenticated, setAuthenticated] = useState(false);

    const loginService = async (email, password) => {
        try {
            const response = await loginApi(email, password);
            if (response.status === 200) {
                setName(response.data.name);
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

    const signupService = async (email, password, name, phoneNo) => {
        try {
            const response = await signupApi(email, password, name, phoneNo);
            if(response.status === 200) {
                setName(response.data.name);
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
        <AuthContext.Provider value={{ loginService, authenticated, signupService, name }}>
            {children}
        </AuthContext.Provider>
    );
}
