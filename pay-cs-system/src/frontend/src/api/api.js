import axios from "axios";
axios.defaults.baseURL = "http://localhost:8090/api"
axios.defaults.headers.get['Content-Type'] = 'application/json;charset=utf-8';
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*';



const getUserInfo = (userId, userPw) => {
  const reqData = {
    'user_id': userId,
    'user_pw': userPw
  }

  return axios.post('/auth/login', reqData, {
    headers: {
      'Content-type': 'application/json'
    }
  })

}
export default {
  getInquiries : function() {
    return axios.get('/inquiry/list');
  // },
  // getLogin : async function(id, passwd) {
  //     return await axios.get('/auth/login', {
  //       auth: {
  //         "id": id,
  //         "passwd": passwd
  //       }
  //     });
  },
  save : function(form){
    return axios.post('/inquiry/create',form)
  },
  async doLogin(userId, userPw) {

    console.log("do Login=== userId=>", userId);
    console.log("do Login=== userPw=>", userPw);


    try {
      const getUserInfoPromise = getUserInfo(userId, userPw)
      const [userInfoResponse] = await Promise.all([getUserInfoPromise])
      if (userInfoResponse.data.length === 0) {
        return 'notFound'
      } else {

        console.log("useInfoResponse", userInfoResponse)
        localStorage.setItem('user_token', userInfoResponse.data.access_token)
        localStorage.setItem('user_role', userInfoResponse.data.user_role)




        return userInfoResponse
      }
    } catch (err) {
      console.error(err)
    }
  }

}

