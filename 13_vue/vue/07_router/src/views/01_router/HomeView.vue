<script setup>
import {useRoute, useRouter} from "vue-router";
/* 현재 라우트 객체에 엑세스 할 수 있도록 하는 메소드 */
const currentRoute = useRoute();
/* push 함수를 통해 원하는 라우팅 요청을 보낼 때 사용하는 객체 */
const router = useRouter();
const changeRouter = () => router.push('/pathvariable/2');
</script>

<template>
<div>
  <h1>Home</h1>
  <h2>currentRoute = {{ currentRoute }}</h2>
  <button @click="changeRouter">Router 경로 변경</button>
</div>
</template>

<style scoped>

</style>