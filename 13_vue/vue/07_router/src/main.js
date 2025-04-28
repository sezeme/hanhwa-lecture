import { createApp } from 'vue'
import App from './App.vue'
import router from './router/01_router.js'
// import router from './router/02_nested-router.js'

const app = createApp(App)

app.use(router)

app.mount('#app')
