<template>
  <div class="skeleton-list">
    <div v-for="n in 10" :key="n" class="skeleton-item"></div>
  </div>
</template>

<style scoped>
.skeleton-list { display: flex; flex-direction: column; gap: 1rem; }
.skeleton-item {
  height: 100px;
  background: #eee;
  border-radius: 4px;
  animation: pulse 1.5s infinite;
}
@keyframes pulse {
  0% { background-color: #eee; }
  50% { background-color: #ddd; }
  100% { background-color: #eee; }
}
</style>
