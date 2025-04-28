<script setup>
import {useRoute} from "vue-router";

const currentRoute = useRoute();
</script>

<template>
<div>
  <h1>PathVariable</h1>
  <h2>넘어온 id 값 : {{ currentRoute.params.id }}</h2>
</div>
</template>

<style scoped>

</style>