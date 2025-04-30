<script setup>

import {useCounterStore} from "@/stores/counter.js";

/* Pinia 스토어에서 상태와 액션을 가져온다.
* defineStore에서 반환받은 값이 담겨있다. */
const counterStore = useCounterStore();
</script>

<template>
  <div class="counter">
    <h1>Counter Test</h1>
    <p>현재 값 : {{ counterStore.count }}</p>
    <p>두 배의 값 : {{ counterStore.doubleCount }}</p>
    <button @click="counterStore.increment">카운트 증가</button>
<!--
  @click="함수()" 는 **실행되는 시점이 "렌더링"**이야 → 클릭 전에 실행돼버림
  항상 클릭 시 실행되길 원한다면 @click="함수"로만 쓰자
  -->
  </div>
</template>

<style scoped>
.counter {
  max-width: 800px;
  margin: 2rem auto;
  padding: 1rem;
  background: #f7f7f7;
  border-radius: 6px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.counter h1 {
  margin-bottom: 1rem;
}

.counter p {
  margin: 0.5rem 0;
}

.counter button {
  margin-top: 1rem;
  padding: 0.5rem 1rem;
  border: none;
  background-color: #007bff;
  color: white;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.counter button:hover {
  background-color: #0056b3;
}
</style>