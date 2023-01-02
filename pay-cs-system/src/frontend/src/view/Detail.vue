<template>
  <div class="board-detail">
    <div class="common-buttons">
    </div>
    <div class="board-contents">
      <h3>{{ title }}</h3>
      <div>
        <strong class="w3-large">{{ author }}</strong>
        <br>
        <span>{{ created_at }}</span>
      </div>
    </div>
    <div class="board-contents">
      <v-textarea outlined v-model="contents"></v-textarea>
    </div>
    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnUpdate">수정</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-red" v-on:click="fnDelete">삭제</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
    </div>
  </div>
</template>

<script>

import apiInquiry from '../api/api.js'

export default {
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      title: '',
      author: '',
      contents: '',
      created_at: '',
      data: []
    }
  },
  mounted() {
    this.fnGetView()
  },
  methods: {
    fnGetView() {


      apiInquiry.getDetail(this.idx).then(res => {
        console.log("res====", res)
        this.title = res.data.title;
        this.contents = res.data.contents;
        this.created_at = res.data.regDate;
        this.author = res.data.customerId;


      });
    },
    fnList() {
      delete this.requestBody.idx
      this.$router.push({
        path: '/inquiry/list',
        query: this.requestBody
      })
    },
    fnUpdate() {
      this.$router.push({
        path: './write',
        query: this.requestBody
      })
    },
    fnDelete() {

    }
  }

}
</script>
<style scoped>


</style>
