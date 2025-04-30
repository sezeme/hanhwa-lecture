
<script setup>
import { reactive, computed } from 'vue';

const emit = defineEmits(['submit']);
const form = reactive({ username: '', password: '' });

const isValid = computed(() => {
  return form.username.trim() !== '' && form.password !== '';
});

function onSubmit() {
  emit('submit', { ...form });
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

    <button
        type="submit"
        :disabled="!isValid"
    >
      로그인
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
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-top: 10px;
}
button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}
</style>
