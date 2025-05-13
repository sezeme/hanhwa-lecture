import {createApp} from 'vue';
import {createPinia} from 'pinia';
import App from './App.vue';
import router from "./router";
import {useAuthStore} from "@/stores/auth.js";
import {refreshUserToken} from "@/api/user.js";

async function bootstrap() {
    const app = createApp(App);
    app.use(createPinia())
    /* 새로고침 했을 때 로그인 상태가 유지 될 수 있도록 refresh token을 전달해서
    * 다시 access token 을 응답 받음 */
    const authStore = useAuthStore();
    try {
        const resp = await refreshUserToken();
        authStore.setAuth(resp.data.data.accessToken)
        console.log('초기화 : 로그인 상태 유지')
    } catch (e) {
        console.log('초기화 : 로그아웃 상태 유지')
    }
}

const app = createApp(App);
const pinia = createPinia();

app.use(pinia);
app.use(router);
app.mount('#app');
