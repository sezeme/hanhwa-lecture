import { createRouter, createWebHistory } from 'vue-router'
import MainView from "@/views/main/MainView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path : '/',
      name : 'main',
      component : MainView
    },
    {
      path : '/login',
      name : 'login',
      component : () => import('@/views/user/LoginView.vue')
    },
    {
      path : '/register',
      name : 'register',
      component : () => import('@/views/user/RegisterView.vue')
    },
    {
      path : '/mypage',
      name : 'mypage',
      component : () => import('@/views/user/MyPageView.vue')
    },
  ],
})

export default router
