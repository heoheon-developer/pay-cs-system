<template>
   <table align="center">
     <thead>
         <th>번호</th>
         <th>고객ID</th>
         <th>제목</th>
         <th>상태</th>
         <th>등록일</th>
     </thead>
     <tr v-for="(item, index) in items" :key="index">
       <td>{{item.id}}</td>
       <td>{{item.customerId}}</td>
       <td>{{item.title}}</td>
       <td>
         <span v-if="item.status == 'WATTING'"> 답변대기</span>
         <span v-else-if="item.status == 'PROGRESS'"> 답변중</span>
         <span v-else-if="item.status == 'COMPLETE'"> 답변완료</span>
       </td>
       <td>{{item.regDate}}</td>
     </tr>
   </table>

</template>
<script>

import apiInquiry from '../api/api.js'

export default{
  data(){
    return {
      items : null
    }
  },

  mounted(){
    apiInquiry.getInquiries().then(res => {
          this.items = res.data;
    }).catch(function (e){
      console.log(e);

    });
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
