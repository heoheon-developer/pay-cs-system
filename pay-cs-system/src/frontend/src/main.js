// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/index.js'
import './assets/common.css'
import vuetify from '@/plugins/vuetify' // path to vuetify export
import HighchartsVue from 'highcharts-vue'
Vue.config.productionTip = false
// Global Components
import '@/plugins/global-components.js';

Vue.use(HighchartsVue)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App},
  store,
  vuetify,
  template: '<App/>'
})
