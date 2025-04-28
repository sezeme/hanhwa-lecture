<script setup>
import {inject} from "vue";

const injectedCount = inject('count');
</script>

<template>
  <h3>Child : {{ injectedCount }}</h3>
  <button @click="injectedCount++">injectedCount++</button>
</template>

<style scoped>

</style>