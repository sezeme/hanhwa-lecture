import {createRouter, createWebHistory} from "vue-router";
import HomeView from "@/views/01_router/HomeView.vue";
import PathVariableView from "@/views/01_router/PathVariableView.vue";
import QueryStringView from "@/views/01_router/QueryStringView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes : [
    {
      path : '/',
      name : 'home',
      component: HomeView
    },
    {
      /* PathVariable 방식으로 라우팅 할 경우 해당 값을 처리할 변수명을 작성한다. */
      path : '/pathvariable/:id',
      name : 'path-variable',
      component : PathVariableView
    },
    {
      path : '/querystring',
      name : 'query-string',
      component : QueryStringView
    }
  ]
});

export default router;