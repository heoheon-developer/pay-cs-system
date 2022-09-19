<template>
  <div class="board-detail">
    <div class="board-contents">
      <input type="text" v-model="title" class="w3-input w3-border" placeholder="제목을 입력해주세요.">
      <input type="text" v-model="name" class="w3-input w3-border" placeholder="작성자를 입력해주세요." v-if="idx === undefined">
    </div>
    <div class="board-contents">
      <textarea id="" cols="30" rows="10" v-model="contents" class="w3-input w3-border" style="resize: none;">
      </textarea>
    </div>
    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnSave">저장</button>&nbsp;
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
      name: '',
      contents: '',
      created_at: ''
    }
  },
  mounted() {
    this.fnGetView()
  },
  methods: {
    fnGetView() {
      if (this.idx !== undefined) {
        this.$axios.get(this.$serverUrl + '/board/' + this.idx, {
          params: this.requestBody
        }).then((res) => {
          this.title = res.data.title
          this.author = res.data.author
          this.contents = res.data.contents
          this.created_at = res.data.created_at
        }).catch((err) => {
          console.log(err)
        })
      }
    },
    fnList() {
      delete this.requestBody.idx
      this.$router.push({
        path: './inquiry/list',
        query: this.requestBody
      })
    },
    fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: './inquiry/list',
        query: this.requestBody
      })
    },
    fnSave() {

      if (this.idx === undefined) {
        //INSERT
        this.form = {
          "title": this.title,
          "contents": this.contents,
          "customerId": this.name
        }
       apiInquiry.save(this.form)
          .then((res) => {
            alert('글이 저장되었습니다.')
            this.fnView(res.data.id)
          }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      } else {
        // TODO
        this.axios.patch(this.form)
          .then((res) => {
            alert('글이 저장되었습니다.')
            this.fnView(res.data.idx)
          }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      }
    }
  }
}
</script>
<style scoped>

</style>
