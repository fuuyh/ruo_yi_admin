<template>
  <div class="post-list">
    <article v-for="post in posts" :key="post._id" class="card mb-3 shadow-sm card-box">
      <div class="card-body">
        <h4><router-link :to="`/posts/${post._id}/`">{{ post.title }}</router-link></h4>
        <div class="row my-3 align-items-center">
          <div v-if="post.image && typeof post.image !== 'string'" class="col-4">
            <img :src="post.image.fitUrl" :alt="post.title" class="rounded-lg w-100">
          </div>
          <p :class="{ 'col-8': post.image }" class="text-muted">{{ post.excerpt }}</p>
        </div>
        <span class="text-muted">{{ post.createdAt }}</span>
      </div>
    </article>
  </div>
</template>
<script lang="ts" setup>
import { computed, defineProps, PropType } from 'vue'
import { PostProps, ImageProps } from '../types'
const props = defineProps({
  list: {
    required: true,
    type: Array as PropType<PostProps[]>
  }
})

const generateFitUrl = (data: ImageProps, width: number, height: number, format = ['m_pad']) => {
  if (data && data.url) {
    const formatStr = format.reduce((prev, current) => {
      return current + ',' + prev
    }, '')
    data.fitUrl = data.url + `?x-oss-process=image/resize,${formatStr}h_${height},w_${width}`
  }
}

const posts = computed(() => {
  return props.list.map(post => {
    generateFitUrl(post.image as ImageProps, 200, 110, ['m_fill'])
    return post
  })
})

</script>

<style scoped>
.post-list h4 a {
  text-decoration: none;
  color: #1a1a1a;
}

.post-list h4 a:hover {
  color: #0d6efd;
}
.card-box {
  padding: 0;
  text-align: left;
}
</style>