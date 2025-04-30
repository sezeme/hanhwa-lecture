<script setup>

import LoginForm from "@/components/user/LoginForm.vue";
import {loginUser} from "@/api/user.js";
import {useRouter} from "vue-router";
import {useAuthStore} from "@/stores/auth.js";

const router = useRouter();
const authStore = useAuthStore();

const handleLogin = async (formData) => {
  try {
    const resp = await loginUser(formData);
    const at = resp.data.data.accessToken;
    // Pinia의 저장소에 access token 저장
    authStore.setAuth(at);
    await router.push('/mypage')
  } catch (e) {
    console.log('로그인 실패', e);
  }
}
</script>

<template>
  <div class="container">
    <h1>로그인</h1>
    <LoginForm @submit="handleLogin"/>
  </div>
</template>

<style scoped>
.container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}
</style>