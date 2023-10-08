import Vue from 'vue'
import VueRouter from 'vue-router'
import Manage from "@/views/Manage.vue";
import Aside from "@/components/Aside.vue";
import Login from "@/views/Login.vue";

Vue.use(VueRouter)

const routes = [
    // {
    //   path: '/',
    //   name: 'Header',
    //   component: Header
    // },
    {
        path: '/',
        name: 'Login',
        component: Login,
    },
    {
        path: '/user',
        component: Manage,
        children: [
            {
                path: '/user',
                component: Aside
            }
        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
