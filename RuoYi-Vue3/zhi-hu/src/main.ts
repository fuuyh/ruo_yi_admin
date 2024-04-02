import { createApp } from 'vue'
import '@/style/style.css'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import App from './App.vue'
import router from './router/index'

createApp(App).use(router).mount('#app')

