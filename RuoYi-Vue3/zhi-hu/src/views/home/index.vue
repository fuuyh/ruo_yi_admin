<template>
  <div class="home-page container-md">
    <section class="text-center container">
      <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
          <img src="../../assets/add_article.svg" alt="callout" class="w-50">
          <h2 class="font-weight-light">随心写作，自由表达</h2>
          <p>
            <a href="/article" class="btn btn-primary my-2">开始写文章</a>
          </p>
        </div>
      </div>
    </section>
    <h4 class="font-weight-bold text-center mb-4">发现精彩</h4>
    <div class="row">
      <div class="col-4 mb-4" v-for="item in 6" :key="item">
        <div class="card h-100 shadow-sm">
          <div class="card-body text-center">
            <img src="http://vue-maker.oss-cn-hangzhou.aliyuncs.com/vue-marker/5f3e41a8b7d9c60b68cdd1ec.jpg?x-oss-process=image/resize,m_pad,h_50,w_50" alt="铺先生" class="rounded-circle border border-light my-3">
            <h5 class="card-title text-truncate">铺先生</h5>
            <p class="card-text text-left description text-secondary">酒店售货机，酒店经营，共享经济，新零售，共享数据线，关注灵趣科技，了解更多</p>
            <a href="#" class="btn btn-outline-primary">进入专栏</a>
          </div>
        </div>
      </div>
    </div>
    <button class="btn btn-outline-primary mt-2 mb-5 mx-auto btn-block w-25 d-block">加载更多</button>
  </div>
</template>

<script lang="ts" setup>
</script>

<style>

</style>