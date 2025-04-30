<script setup>

import RegisterForm from "@/components/user/RegisterForm.vue";
import {registerUser} from "@/api/user.js";
import router from "@/router/index.js";

const handleRegister = async (formData) => {
  // 회원 가입 api 호출
  try {
    await registerUser(formData);
    await router.push('/login');
  } catch (e) {
    console.log('회원 가입 실패', e);
  }
}
</script>

<template>
  <div class="container">
    <h1>회원 가입</h1>
    <RegisterForm @submit="handleRegister"/>
  </div>
</template>

<style scoped>

</style>