import {createApp} from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import store from './store'
const app = createApp(App);

// 封装的请求
import http from "./request.js";
app.config.globalProperties.$http = http;

app.use(store).use(router).use(ElementPlus).mount('#app')


