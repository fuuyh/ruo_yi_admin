<template>
  <nav class="navbar-dark bg-primary justify-content-between mb-4 px-4">
    <div class="w-75 mx-auto navbar">
      <router-link class="router-link-active router-link-exact-active navbar-brand text_color" to="/">者也专栏</router-link>
      <ul v-if="!isLogin" class="list-inline mb-0">
        <li class="list-inline-item"><router-link to="/account?type=login"
            class="btn btn-outline-light my-2">登陆</router-link></li>
        <li class="list-inline-item"><router-link to="/account?type=register"
            class="btn btn-outline-light my-2">注册</router-link></li>
      </ul>
      <ul v-else-if="isLogin && data" class="list-inline mb-0">
        <li class="list-inline-item">
          <dropdown :title="`你好 ${data.nickName}`">
            <dropdown-item><router-link to="/create" class="dropdown-item">新建文章</router-link></dropdown-item>
            <dropdown-item><router-link :to="`/column/${data.column}`"
                class="dropdown-item">我的专栏</router-link></dropdown-item>
            <dropdown-item disabled><a href="#" class="dropdown-item">编辑资料</a></dropdown-item>
            <!-- <dropdown-item><a href="#" class="dropdown-item" @click.prevent="handleLogout">退出登陆</a></dropdown-item> -->
            <dropdown-item><a href="#" class="dropdown-item">退出登陆</a></dropdown-item>
          </dropdown>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script lang="ts" setup>
import { ref } from 'vue';

const data = ref(
  {
    nickName: '张三',
    column: 'test'
  }
)

const isLogin = ref(false)

</script>

<style lang="scss" scoped>
.text_color {
  color: #fff;
}
</style>