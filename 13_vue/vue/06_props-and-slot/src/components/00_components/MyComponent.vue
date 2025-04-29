<script setup>

import {onMounted} from "vue";

onMounted(() => {
  console.log('MyComponent 마운트 완료');
});
</script>

<template>
  <div>
    <h1>My Component입니다.</h1>
  </div>
</template>

<style scoped>
h1 {
  color : red;
}
</style>