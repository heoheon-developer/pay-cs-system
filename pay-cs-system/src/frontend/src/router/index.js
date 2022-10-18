import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home.vue'
import Inquiry from '@/components/Inquiry.vue'
import Write from '@/components/Write.vue'
import Login from '@/components/Login.vue'
import TestGrid from '@/components/TestGrid.vue'

Vue.use(Router)

export default new Router({
  mode : 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path : '/inquiry/list',
      name: 'Inquiry',
      component : Inquiry
    },
    {
      path : '/write',
      name : 'Write',
      component : Write
    },
    {
      path:'/login',
      name : 'Login',
      component : Login
    },
    {
      path:'/testGrid',
      name: 'TestGrid',
      component: TestGrid
    }


  ]


})
