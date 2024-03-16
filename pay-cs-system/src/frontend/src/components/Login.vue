<template>
  <div>
    <div>
      <h2>Please Log In</h2>
      <div id="loginForm">
        <el-form :inLine="true" :model="formIn">
          <el-input v-model="formIn.user_id"></el-input>
          <el-input v-model="formIn.user_pw" type="password"></el-input>
          <el-button type="primary" @click="fnLogin">로그인</el-button>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import router from "../router";

export default {
  data() {
    return {
      formIn: {
        user_id: "",
        user_pw: ""
      }
    };
  },
  methods: {
    ...mapActions(["login"]),

    async fnLogin() {
      if (this.formIn.user_id === "") {
        alert("ID를 입력하세요.");
        return;
      }

      if (this.formIn.user_pw === "") {
        alert("비밀번호를 입력하세요.");
        return;
      }

      //로그인 API 호출
      try {
        let loginResult = await this.login({
          user_id: this.formIn.user_id,
          user_pw: this.formIn.user_pw
        });

        console.log("loginResult====>", loginResult);

        if (loginResult) {
          await router.push("/inquiry/list");
        }
      } catch (err) {
        if (err.message.indexOf("Network Error") > -1) {
          alert("서버에 접속할 수 없습니다. 상태를 확인해주세요.");
        } else {
          alert("로그인 정보를 확인할 수 없습니다.");
        }
      }
    }
  },
  computed: {
    ...mapGetters({
      errorState: "getErrorState"
    })
  }
};
</script>

<style>
#loginForm {
  width: 500px;
  margin: auto;
}
</style>
