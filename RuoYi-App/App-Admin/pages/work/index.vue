<template>
	<view class="work-container">
		<!-- 轮播图 -->
		<uni-swiper-dot class="uni-swiper-dot-box" :info="data" :current="current" field="content">
			<swiper class="swiper-box" :current="swiperDotIndex" @change="changeSwiper">
				<swiper-item v-for="(item, index) in data" :key="index">
					<view class="swiper-item" @click="clickBannerItem(item)">
						<image :src="item.image" mode="aspectFill" :draggable="false" />
					</view>
				</swiper-item>
			</swiper>
		</uni-swiper-dot>

		<template v-for="(item,index) in menuList">
			<template v-if="item.children != null && item.children.length != 0 && item.appVisible == '0'">
				<uni-section :title="item.menuName" type="line" :key="index"></uni-section>
				<view class="grid-body">
					<uni-grid :column="4" :showBorder="false">
						<uni-grid-item v-for="(e,i) in item.children" :key="i">
							<view class="grid-item-box" @click="toPath(e)">
								<uni-icons custom-prefix="iconfont" :type="`icon-${e.appIcon}`" size="20"></uni-icons>
								<text class="text">{{ e.menuName }}</text>
							</view>
						</uni-grid-item>
					</uni-grid>
				</view>
			</template>
		</template>

	</view>
</template>

<script>
	import {
		getMenus
	} from '@/api/menu.js'
	export default {
		data() {
			return {
				current: 0,
				swiperDotIndex: 0,
				menuList: [],
				data: [{
						image: '/static/images/banner/banner01.jpg'
					},
					{
						image: '/static/images/banner/banner02.jpg'
					},
					{
						image: '/static/images/banner/banner03.jpg'
					}
				]
			}
		},
		onLoad() {
			this.getMenu()
		},
		methods: {
			clickBannerItem(item) {
				console.info(item)
			},
			changeSwiper(e) {
				this.current = e.detail.current
			},
			toPath(e) {
				// 路由跳转
				console.log(e)
				this.$modal.showToast('模块建设中~')
			},
			async getMenu() {
				// 获取动态的菜单
				const {
					code,
					data
				} = await getMenus()
				if (code === 200) {
					// 成功
					this.menuList = [...data]
				}

			}
		}
	}
</script>

<style lang="scss">
	@import '../../static/icon/icon.css';
	/* #ifndef APP-NVUE */
	page {
		display: flex;
		flex-direction: column;
		box-sizing: border-box;
		background-color: #fff;
		min-height: 100%;
		height: auto;
	}

	view {
		font-size: 14px;
		line-height: inherit;
	}

	/* #endif */

	.text {
		text-align: center;
		font-size: 26rpx;
		margin-top: 10rpx;
	}

	.grid-item-box {
		flex: 1;
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: column;
		align-items: center;
		justify-content: center;
		padding: 15px 0;
	}

	.uni-margin-wrap {
		width: 690rpx;
		width: 100%;
	}

	.swiper {
		height: 300rpx;
	}

	.swiper-box {
		height: 150px;
	}

	.swiper-item {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: column;
		justify-content: center;
		align-items: center;
		color: #fff;
		height: 300rpx;
		line-height: 300rpx;
	}

	@media screen and (min-width: 500px) {
		.uni-swiper-dot-box {
			width: 400px;
			/* #ifndef APP-NVUE */
			margin: 0 auto;
			/* #endif */
			margin-top: 8px;
		}

		.image {
			width: 100%;
		}
	}
</style>