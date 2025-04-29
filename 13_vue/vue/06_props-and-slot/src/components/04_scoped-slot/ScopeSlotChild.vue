<script setup>
import {ref} from "vue";

const users = ref([
  { id : 1, name : '유관순', age : 16},
  { id : 2, name : '홍길동', age : 20},
  { id : 3, name : '선덕여왕', age : 30},
]);
</script>

<template>
  <ul>
    <li v-for="user in users" :key="user.id">
      <!--
      user 데이터를 slot으로 바인딩 (v-bind:user)
      user라는 이름의 슬롯 프로퍼티를 부모에게 공개한다
      -->
      <slot :user="user">
        <!-- 부모가 아무 값도 주지 않았을 경우의 기본 콘텐츠를 정의한다. -->
        {{ user.name }} ({{ user.age }})
      </slot>
    </li>
  </ul>
</template>

<style scoped>

</style>