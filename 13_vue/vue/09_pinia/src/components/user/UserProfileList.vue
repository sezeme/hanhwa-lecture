<template>
  <div class="user-profile-list">
    <UserProfileItem
        v-for="user in users"
        :key="user.username"
        :user="user"
    />
  </div>
</template>

<script setup>
import UserProfileItem from './UserProfileItem.vue';

defineProps({
  users: {
    type: Array,
    required: true
  }
});
</script>

<style scoped>
.user-profile-list {
  display: grid;
  gap: 1rem;
}
</style>
