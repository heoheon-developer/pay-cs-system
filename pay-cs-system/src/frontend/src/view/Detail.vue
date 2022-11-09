<template>
<div class="board-detail">

  <div class="board-contents">
    <h3>{{ title }}</h3>
    <div>
      <span>{{ created_at }}</span>
    </div>
    <div class="board-contents">
    <span>{{contents}}</span>
    </div>
  </div>
</div>
</template>

<script>

import apiInquiry from '../api/api.js'
export default {
  name: "Detail.vue",
  data(){
    return {
      requestBody : this.$route.query,
      idx : this.$route.query.idx,
      title:'',
      contents:'',
      created_at:''
    }
  },
  mounted(){
    this.getView()
  },
  methods:{
    getView(){
      apiInquiry.getDetail(this.idx).then(res=>{
        console.log("getView",res);
      });
    }
  }
}
</script>

<style scoped>

</style>
