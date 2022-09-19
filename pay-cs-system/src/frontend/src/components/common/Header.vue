<template>

  <header>
    <div id = nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/write">문의 하기</router-link> |
      <router-link to="/inquiry/list">고객 상담 게시판</router-link> |
      <router-link to="/login">상담사 로그인 </router-link>
    </div>
  </header>

</template>

<style scoped>
header{width:100%; text-align:center; position:relative; height:70px; border-bottom:1px solid #35495e}
header h1{position:absolute; top:0; left:100px;}
header ul.menu:after{display:block; clear:both; content:'';}
header ul.menu{position:absolute; top:20px; right:50px;}
header ul.menu li{float:left; padding:10px 20px; list-style:none;}

a{text-decoration:none; color:#333;}
</style>
