import ApiClient from "./ApiClient"

export const loginApi = (email, password) => {
    return ApiClient.post('/auth/login', {email, password});
};