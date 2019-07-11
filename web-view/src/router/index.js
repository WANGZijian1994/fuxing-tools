import Vue from 'vue'
import Router from 'vue-router'
import TagManage from '@/components/TagManage'
import FileGenerate from '@/components/FileGenerate'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/TagManage',
      name: 'TagManage',
      component: TagManage
    },
    {
      path: '/FileGenerate',
      name: 'FileGenerate',
      component: FileGenerate
    }
  ]
})
