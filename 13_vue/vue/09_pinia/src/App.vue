<script setup>

import {useAuthStore} from "@/stores/auth.js";
import {logoutUser} from "@/api/user.js";
import {useRouter} from "vue-router";

const authStore = useAuthStore();
const router = useRouter();

const handleLogout = async () => {
  try {
    await logoutUser();
    await router.push('/login');
    authStore.clearAuth();

  } catch (e) {
    console.log('로그아웃 실패', e);
  }
}
</script>

<template>
  <header>
    <nav>
      <div class="nav-links">
        <RouterLink to="/">MAIN</RouterLink>
        <template v-if="authStore.isAuthenticated">
          <RouterLink to="/mypage">MYPAGE</RouterLink>
        </template>
        <template v-else>
          <RouterLink to="/login">LOGIN</RouterLink>
          <RouterLink to="/register">REGISTER</RouterLink>
        </template>
      </div>
      <button
      v-if="authStore.isAuthenticated"
      @click="handleLogout"
      class="nav-button"
      >LOGOUT</button>
    </nav>
  </header>
  <main>
    <RouterView/>
  </main>
</template>

<style scoped>
header {
  background-color: rgba(0, 123, 255, 0.8);
  padding: 10px 20px;
}

nav {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.nav-links {
  display: flex;
  align-items: center;
}

.nav-links a {
  color: white;
  text-decoration: none;
  padding: 10px 15px;
  transition: background-color 0.3s;
}

.nav-links a:hover {
  background-color: rgba(255, 255, 255, 0.2);
  border-radius: 4px;
}

.nav-button {
  background-color: transparent;
  border: 2px solid white;
  color: white;
  padding: 6px 14px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.3s, border-color 0.3s;
}

.nav-button:hover {
  background-color: white;
  color: #007bff;
  border-color: white;
}

main {
  padding: 20px;
  background-color: #f9f9f9;
  min-height: calc(100vh - 60px);
  border-top: 1px solid #ddd;
}
</style>
