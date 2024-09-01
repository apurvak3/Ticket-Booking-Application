import ApiClient from "./ApiClient"

export const loginApi = (email, password) => {
    return ApiClient.post('/auth/login', {email, password});
};

export const signupApi = (email, password, name, phoneNo) => {
    return ApiClient.post('auth/user/signup', {email, password, name, phoneNo});
}