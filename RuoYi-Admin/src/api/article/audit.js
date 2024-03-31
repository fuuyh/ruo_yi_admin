import request from '@/utils/request'

// 查询文章审核列表
export function listAudit(query) {
  return request({
    url: '/article/audit/list',
    method: 'get',
    params: query
  })
}

// 查询文章审核详细
export function getAudit(id) {
  return request({
    url: '/article/audit/' + id,
    method: 'get'
  })
}

// 新增文章审核
export function addAudit(data) {
  return request({
    url: '/article/audit',
    method: 'post',
    data: data
  })
}

// 修改文章审核
export function updateAudit(data) {
  return request({
    url: '/article/audit',
    method: 'put',
    data: data
  })
}

// 删除文章审核
export function delAudit(id) {
  return request({
    url: '/article/audit/' + id,
    method: 'delete'
  })
}
