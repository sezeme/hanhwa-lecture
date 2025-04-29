<script setup>
const props = defineProps({
  readValue : String
})
</script>

<template>
  <h1>{{ props.readValue }}</h1>
  자식의 readValue : <input type="text" v-model="props.readValue">
</template>

<style scoped>

</style>