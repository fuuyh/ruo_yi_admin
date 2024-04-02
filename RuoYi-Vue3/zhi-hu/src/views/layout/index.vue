<script setup lang="ts">
import { ref } from 'vue';
import globalHeader from '../../components/globalHeader.vue';
import loader from '../../components/Loader.vue';
const isLoading = ref(false)
</script>

<template>
  <!-- <div class="container"> -->
  <div class="container-fluid px-0 flex-shrink-0">
    <globalHeader />
    <loader v-if="isLoading"></loader>
    <main>
      <router-view v-slot="{ Component }">
      <Transition name="slide-fade" mode="out-in">
        <component :is="Component" />
      </Transition>
    </router-view>
    </main>
  </div>
  <footer class="text-center py-4 text-secondary bg-light mt-auto footer">
    <small>
      <ul class="list-inline mb-0">
        <li class="list-inline-item">© 慕课网（imooc.com）版权所有 | 津ICP备20000929号-1</li>
        <li class="list-inline-item">© 2020 者也专栏</li>
        <li class="list-inline-item">课程sss</li>
        <li class="list-inline-item">文档sss</li>
        <li class="list-inline-item">联系ssssss</li>
        <li class="list-inline-item">更多ssss</li>
      </ul>
    </small>
  </footer>
  <!-- </div> -->
</template>

<style scoped lang="scss">
main {
  min-height: 80vh;
  width: 100%;
}

/*
  进入和离开动画可以使用不同
  持续时间和速度曲线。
*/
.slide-fade-enter-active {
  transition: all 0.3s ease-out;
}

.slide-fade-leave-active {
  transition: all 0.3s cubic-bezier(1, 0.5, 0.8, 1);
}

.slide-fade-enter-from,
.slide-fade-leave-to {
  transform: translateX(20px);
  opacity: 0;
}
</style>
