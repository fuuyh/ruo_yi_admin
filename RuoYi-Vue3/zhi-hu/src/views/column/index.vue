<template>
  <div class="column-detail-page w-690">
    <div class="column-info row mb-4 border-bottom pb-4 align-items-center">
      <div class="col-3 text-center">
        <img
          src="http://vue-maker.oss-cn-hangzhou.aliyuncs.com/vue-marker/5f3e3a17c305b1070f455202.jpg?x-oss-process=image/resize,m_pad,h_100,w_100"
          alt="Vehicle攻城狮" class="rounded-circle border w-100">
      </div>
      <div class="col-9">
        <h4>Vehicle攻城狮</h4>
        <p class="text-muted">半吊子系统和程序狗，沉迷高端理论，日渐消瘦。</p>
      </div>
    </div>
    <postList :list="list" />
    <button class="btn btn-outline-primary mt-2 mb-5 mx-auto btn-block w-25 d-block" @click="loadMorePage"
      v-if="!isLastPage">
      加载更多
    </button>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import postList from '../../components/postList.vue';

const list = ref([
  {
    _id: 1,
    title: 'Vehicle攻城狮',
    excerpt: '半吊子系统和程序狗，沉迷高端理论，日渐消瘦。',
    image: '',
    content: '半吊子系统和程序狗，沉迷高端理论，日渐消瘦。',
    createAt: '2022-01-01',
    author: 'Vehicle',
    column: 'Vehicle',
    isHTML: false,
  },
]);
const isLastPage = ref(false);  // 是否是最后一页
const loadMorePage = () => {
  // 加载更多
}
</script>

<style lang="scss" scoped>
.w-690 {
  width: 690px;
  margin: 0 auto;
}
</style>
