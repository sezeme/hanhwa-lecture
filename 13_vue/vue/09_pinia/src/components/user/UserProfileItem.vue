<template>
  <div class="user-profile-item">
    <p><strong>사용자명:</strong> {{ user.username }}</p>
    <p><strong>역할:</strong> {{ user.role }}</p>
  </div>
</template>

<script setup>
defineProps({
  user: {
    type: Object,
    required: true,
    validator: u => 'username' in u && 'role' in u
  }
});
</script>

<style scoped>
.user-profile-item {
  border: 1px solid #ddd;
  padding: 1rem;
  border-radius: 4px;
  margin-bottom: 1rem;
  background: #fff;
}
</style>
