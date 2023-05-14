import { createRouter, createWebHistory } from "vue-router";
import Layout from "../views/Layout.vue";

const routes = [
  {
    path: "/layout",
    name: "layout",
    component: Layout,
    redirect: "/layout/userInfo",
    children: [
      {
        path: "userInfo",
        name: "userInfo",
        component: () => import("@/views/userInfo"),
      },
      {
        path: "song",
        name: "song",
        component: () => import("@/views/song"),
      },
      {
        path: "post",
        name: "post",
        component: () => import("@/views/post"),
      },
      {
        path: "likes",
        name: "likes",
        component: () => import("@/views/likes"),
      },
      {
        path: "comment",
        name: "comment",
        component: () => import("@/views/comment"),
      },
    ],
  },
  {
    path: "/",
    name: "login",
    component: () => import("@/views/login"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
