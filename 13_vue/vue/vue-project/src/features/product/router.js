export const productsRoutes = [
    {
        path: '/products',
        name: 'ProductList',
        component : () => import('@/features/product/views/ProductListView.vue')
    }
]