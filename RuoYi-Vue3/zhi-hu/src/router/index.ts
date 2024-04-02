/**
 * createRouter 这个为创建路由的方法
 * createWebHashHistory 这个就是vue2中路由的模式，
 *                      这里的是hash模式，这个还可以是createWebHistory等
 * RouteRecordRaw 这个为要添加的路由记录，也可以说是routes的ts类型
 */
import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';

// 路由记录，跟vue2中用法一致
const routes: Array<RouteRecordRaw> = [
  // 首页
  {
    path: '/',
    name: 'layout',
    component: () => import("@/views/layout/index.vue"),
    children: [
      {
        path: '/',
        name: 'home',
        component: () => import("@/views/home/index.vue")
      },
      {
        path: '/article',
        name: 'article',
        component: () => import("@/views/article/index.vue")
      }
    ]
  },
  // 登录页/注册页
  {
    path: '/account',
    name: 'account',
    component: () => import("@/views/login/index.vue"),
  },
  // 404 页面
  {
    path: '/:pathMatch(.*)*',
    name: 'notFound',
    component: () => import("@/views/error/404.vue")
  },
  // 401 页面
  {
    path: '/401',
    name: '401',
    component: () => import("@/views/error/401.vue")
  }

  // 文章详情页
  // 专栏分类文章列表页
  // 发布文章页
  // 个人中心页
  // 个人中心-我的文章页
  // 个人中心-我的收藏页
  // 个人中心-我的关注页
  // 个人中心-我的粉丝页
  // 个人中心-我的消息页
  // 个人中心-我的评论页
  // 个人中心-我的点赞页
  // 个人中心-我的收藏文章页
  // 个人中心-我的收藏专栏页
  // 个人中心-我的关注专栏页
  // 个人中心-我的关注文章页

];

const router = createRouter({
  history: createWebHistory(),
  routes
});
export default router;