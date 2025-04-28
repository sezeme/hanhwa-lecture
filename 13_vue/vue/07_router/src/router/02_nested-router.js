import {createRouter, createWebHistory} from "vue-router";

const router = createRouter({
    history: createWebHistory(),
    routes : [
        {
            path : '/nested',
            /* component : HomeView 라고 작성할 경우 시작 시점에 해당 컴포넌트를 로딩한다.
            * component: () => import('') 라고 작성할 경우 Lazy Loading이 수행 되며
            * 코드를 분할 해서 필요 시점에 로딩한다. */
            component: () => import('@/views/02_nested-router/HomeView.vue'),
            children : [
                {
                    path : 'home',
                    name : 'nested-home',
                    component : () => import('@/views/02_nested-router/NestedHome.vue')
                },
                {
                    path : 'other',
                    name : 'nested-other-view',
                    component : () => import('@/views/02_nested-router/NestedOtherView.vue')
                },
            ]
        }
    ],
    linkActiveClass: 'active',   // 모든 <RouterLink> 에 기본 active-class 설정

});

export default router;