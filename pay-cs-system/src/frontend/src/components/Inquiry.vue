<template>
  <div>
   <table align="center">
     <thead>
         <th>번호</th>
         <th>고객ID</th>
         <th>제목</th>
         <th>상태</th>
         <th>등록일</th>
         <th v-if="isLogin">상담사 지정</th>
     </thead>
     <tr v-for="(item, id) in items" :key="id">
       <td>{{item.id}}</td>
       <td>{{item.customerId}}</td>
       <td><a v-on:click="detailView(`${item.id}`)">{{item.title}}</a></td>
       <td>
         <span v-if="item.status == 'WATTING'"> 답변대기</span>
         <span v-else-if="item.status == 'PROGRESS'"> 답변중</span>
         <span v-else-if="item.status == 'COMPLETE'"> 답변완료</span>
       </td>
       <td>{{item.regDate | yyyyMMdd}}</td>
       <td v-if="isLogin"><button >지정</button></td>
     </tr>
   </table>
  </div>
</template>
<script>

import apiInquiry from '../api/api.js'
import {mapState} from 'vuex'

export default{
  data(){
    return {
      items : null,
      requestBody:{} //데이터 전송
    }
  },
  computed:mapState({
    isLogin : state => state.isLogin
  }),
  mounted(){
    apiInquiry.getInquiries().then(res => {
          this.items = res.data;
    }).catch(function (e){
      console.log(e);

    });
  },
  filters : {
    // filter로 쓸 filter ID 지정
    yyyyMMdd : function(value){
      // 들어오는 value 값이 공백이면 그냥 공백으로 돌려줌
      if(value == '') return '';

      // 현재 Date 혹은 DateTime 데이터를 javaScript date 타입화
      var js_date = new Date(value);

      // 연도, 월, 일 추출
      var year = js_date.getFullYear();
      var month = js_date.getMonth() + 1;
      var day = js_date.getDate();

      // 월, 일의 경우 한자리 수 값이 있기 때문에 공백에 0 처리
      if(month < 10){
        month = '0' + month;
      }

      if(day < 10){
        day = '0' + day;
      }

      // 최종 포맷 (ex - '2021-10-08')
      return year + '-' + month + '-' + day;
    }
  },
  methods:{
    detailView(idx){
      this.requestBody.idx = idx
      this.$router.push({
        path:'./detail',
        query:this.requestBody
      })
    }
  }

}

</script>


<style scoped>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: center;
  padding: 8px;
}
</style>
