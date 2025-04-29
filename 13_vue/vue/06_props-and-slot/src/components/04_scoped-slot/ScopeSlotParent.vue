<script setup>

import ScopeSlotChild from "@/components/04_scoped-slot/ScopeSlotChild.vue";
</script>

<template>
<div class="container">
  <ScopeSlotChild>
    <!--
      #default : v-slot:default의 축약형으로 자식에서 <slot>에 name을 별도로 지정하지 않으면
      default slot이다.
      { user } : 구조 분해 할당 문법으로 slotProps.user로 자식이 전달한 user에 접근한다.
    -->
    <template #default="{ user }">
      <strong>{{ user.name }}</strong> - <em>{{ user.age }}세</em>
    </template>
  </ScopeSlotChild>
</div>
</template>

<style scoped>

</style>