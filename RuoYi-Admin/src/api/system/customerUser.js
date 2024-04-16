import request from '@/utils/request'

// 查询用户信息列表
export function listCustomerUser(query) {
  return request({
    url: '/system/customerUser/list',
    method: 'get',
    params: query
  })
}

// 查询用户信息详细
export function getCustomerUser(userId) {
  return request({
    url: '/system/customerUser/' + userId,
    method: 'get'
  })
}

// 新增用户信息
export function addCustomerUser(data) {
  return request({
    url: '/system/customerUser',
    method: 'post',
    data: data
  })
}

// 修改用户信息
export function updateCustomerUser(data) {
  return request({
    url: '/system/customerUser',
    method: 'put',
    data: data
  })
}

// 删除用户信息
export function delCustomerUser(userId) {
  return request({
    url: '/system/customerUser/' + userId,
    method: 'delete'
  })
}
