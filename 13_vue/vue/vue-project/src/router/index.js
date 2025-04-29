import {createRouter, createWebHistory} from "vue-router";
import {mainRoutes} from "@/features/main/router.js";
import {productsRoutes} from "@/features/product/router.js";


const router = createRouter({
    history: createWebHistory(),
    routes : [
        ...mainRoutes,
        ...productsRoutes,
        // 나중에 다른 기능과 관련 된 routes 들을 추가하면 된다.
    ]
})

export default router;