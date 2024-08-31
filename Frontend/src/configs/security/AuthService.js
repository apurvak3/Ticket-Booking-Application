import { loginApi } from "../api/AuthApi";

export default AuthProvider({children}) {

    const [username, setUsername] = useState(null);
    const [authenticated, setAuthenticated] = useState(false);



    const loginService = async (email, password) => {
        try {
            const response  = await loginApi(email, password);
            if(response.status === 200) {
                setUsername()
                localStorage.setItem('token', "Bearer " + response.data.accessToken);
                return true;
            } else {
                return false;
            }
        } catch (error) {
            console.log(error);
        }
        
    }

}