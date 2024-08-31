import ApiClient from "./ApiClient"

export const loginApi = (email, password) => {
    return ApiClient.post('/login', {email, password});
};