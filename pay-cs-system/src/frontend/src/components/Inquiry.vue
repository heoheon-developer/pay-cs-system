<template>
  <div>
    <v-data-table :headers="headers" :items="items" loading
                  loading-text="Loading... Please wait">

<!--      <template v-slot:item.status="{item}">-->
<!--        <v-chip :color="setStatus(item.status)" dark></v-chip>-->
<!--      </template>-->

      // 카운셀러 지정
      <template v-slot:header.counselor="{headers}">
            <span v-if="isLogin">상담사지정</span>
      </template>

      <template v-slot:item.title="{item}">
        <a v-on:click="detailView(`${item.id}`)">{{item.title}}</a>
      </template>

      <template v-slot:item.status="{item}">
             <span v-if="item.status == 'WATTING'">답변대기</span>
             <span v-else-if="item.status == 'PROGRESS'">답변중</span>
             <span v-else-if="item.status == 'COMPLETE'">답변완료</span>
      </template>
      <template v-slot:item.regDate="{item}">
        {{ item.regDate | yyyyMMdd  }}
      </template>

    </v-data-table>
  </div>
</template>
<script>

import apiInquiry from '../api/api.js'
import {mapState} from 'vuex'

export default {
  data() {
    return {
      items: [],
      requestBody: {},
      headers: [
        {
          text: '번호',
          value: 'id'
        },
        {
          text: '고객ID',
          value: 'customerId'
        },
        {
          text: '제목',
          value: 'title'
        },
        {
          text: '상태',
          value: 'status'
        },
        {
          text: '등록일',
          value: 'regDate'
        },
        {
          text: '상담사지정',
          value: 'counselor'
        }
      ],


    }
  },
  computed: mapState({
    isLogin: state => state.isLogin
  }),
  mounted() {
    apiInquiry.getInquiries().then(res => {
      this.items = res.data;
    }).catch(function (e) {
      console.log(e);

    });
  },
  filters: {
    // filter로 쓸 filter ID 지정
    yyyyMMdd: function (value) {
      // 들어오는 value 값이 공백이면 그냥 공백으로 돌려줌
      if (value == '') return '';

      // 현재 Date 혹은 DateTime 데이터를 javaScript date 타입화
      var js_date = new Date(value);

      // 연도, 월, 일 추출
      var year = js_date.getFullYear();
      var month = js_date.getMonth() + 1;
      var day = js_date.getDate();

      // 월, 일의 경우 한자리 수 값이 있기 때문에 공백에 0 처리
      if (month < 10) {
        month = '0' + month;
      }

      if (day < 10) {
        day = '0' + day;
      }

      // 최종 포맷 (ex - '2021-10-08')
      return year + '-' + month + '-' + day;
    }
  },
  methods: {
    detailView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: './detail',
        query: this.requestBody
      })
    },
    isStatus (status) {
      console.log("tatus==========", status)
      if ( status == "PROGRESS" ) return '답변대기'

    },
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
