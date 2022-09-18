import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home.vue'
import Inquiry from '@/components/Inquiry.vue'

Vue.use(Router)

export default new Router({
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
    }
  ]


})
