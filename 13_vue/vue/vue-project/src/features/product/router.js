export const productsRoutes = [
    {
        path: '/products',
        name: 'ProductList',
        component: () => import('@/features/product/views/ProductListView.vue')
    },
    {
        path: '/products/:id',
        name: 'ProductDetail',
        component: () => import('@/features/product/views/ProductDetailView.vue')

    }
]