<script setup>
import { reactive, computed } from 'vue';

const emit = defineEmits(['submit']);

const form = reactive({
  username: '',
  password: '',
  pwdConfirm: ''
});

// 모든 필드가 채워지고, 비밀번호와 확인란이 일치해야 true
const isValid = computed(() => {
  return (
      form.username.trim() !== '' &&
      form.password !== '' &&
      form.pwdConfirm !== '' &&
      form.password === form.pwdConfirm
  );
});

function onSubmit() {
    emit('submit', {
      username: form.username,
      password: form.password
    });
}
</script>

<template>
  <form @submit.prevent="onSubmit">

    <div>
      <label for="userId">사용자 ID</label>
      <input
          id="userId"
          v-model.trim="form.username"
          type="text"
          required
      />
    </div>

    <div>
      <label for="pwd">비밀번호</label>
      <input
          id="pwd"
          v-model="form.password"
          type="password"
          required
      />
    </div>

    <div>
      <label for="pwdConfirm">비밀번호 확인</label>
      <input
          id="pwdConfirm"
          v-model="form.pwdConfirm"
          type="password"
          required
      />
      <p v-if="form.pwdConfirm && form.password !== form.pwdConfirm" class="error-message">
        비밀번호가 일치하지 않습니다.
      </p>
    </div>

    <button
        type="submit"
        :disabled="!isValid"
    >
      회원가입
    </button>
  </form>
</template>

<style scoped>
input {
  width: 95%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  margin-top: 4px;
}
button {
  width: 95%;
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin: 10px;
}
button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}
.error-message {
  color: #dc3545;
  margin-bottom: 1rem;
}
</style>
