/* user 관련 api 호출 */
import api from './axios.js'

/* 1. 회원 가입 */
export function registerUser(data) {
    return api.post('/users', data);
}