<script setup>
import {useRoute} from "vue-router";

const currentRoute = useRoute();
</script>

<template>
<div>
  <h1>QueryString</h1>
  <h2>넘어온 query string 값 : {{ currentRoute.query }}</h2>
  <h2>name : {{ currentRoute.query.name }}</h2>
  <h2>age : {{ currentRoute.query.age }}</h2>
</div>
</template>

<style scoped>

</style>