<template>

  <header>
    <div id = nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/write">문의 하기</router-link> |
      <router-link to="/inquiry/list">고객 상담 게시판</router-link> |
      <router-link to="/testGrid">테스트 그리드</router-link> |

      <router-link to="/login" v-if="!this.$store.state.isLogin">로그인</router-link>
      <a v-if="this.$store.state.isLogin" @click="fnLogout">로그아웃</a>
    </div>
  </header>

</template>
<script>
export default {
  methods: {
    fnLogout() {
      localStorage.removeItem("user_token")
      localStorage.removeItem("user_role")
      location.reload()
    }
  }
}
</script>
<style scoped>
header{width:100%; text-align:center; position:relative; height:70px; border-bottom:1px solid #35495e}
header h1{position:absolute; top:0; left:100px;}
header ul.menu:after{display:block; clear:both; content:'';}
header ul.menu{position:absolute; top:20px; right:50px;}
header ul.menu li{float:left; padding:10px 20px; list-style:none;}

a{text-decoration:none; color:#333;}
</style>
