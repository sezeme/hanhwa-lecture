/* 요청, 응답에 공통적으로 적용 될 부분을 axios 객체로 정의 */
import axios from "axios";

const api = axios.create({
    baseURL : import.meta.env.VITE_API_BASE_URL,
    headers : { 'Content-Type' : 'application/json'},
    // HttpOnly Cookie 사용할 경우
    withCredentials : true
})

export default api;