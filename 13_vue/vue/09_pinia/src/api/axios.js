/* 요청, 응답에 공통적으로 적용 될 부분을 axios 객체로 정의 */
import axios from "axios";
import {useAuthStore} from "@/stores/auth.js";

const api = axios.create({
    baseURL : import.meta.env.VITE_API_BASE_URL,
    headers : { 'Content-Type' : 'application/json'},
    // HttpOnly Cookie 사용할 경우
    withCredentials : true
})

// 해당 객체를 통해 요청을 하면 interceptor에 의해 access token 이 header에 삽입 된다.
api.interceptors.request.use(config => {
    const authStore = useAuthStore();
    if(authStore.accessToken)
        config.headers.Authorization = `Bearer ${authStore.accessToken}`
    return config;
})

export default api;