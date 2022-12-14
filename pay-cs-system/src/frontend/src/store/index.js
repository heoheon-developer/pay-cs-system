import Vue from 'vue'
import Vuex from 'vuex'
import mutations from "./mutations";
import getters from "./getters";
import actions from "./actions";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: null,
    isLogin: false,
    loadingStatus: false,
  },
  mutations,
  getters,
  actions
})
