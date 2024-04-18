import request from '@/utils/request'

// 用户密码重置
export function getMenus() {
  return request({
    url: '/getRouters',
	method: 'get'
  })
}