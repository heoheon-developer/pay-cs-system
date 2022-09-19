import axios from "axios";
axios.defaults.baseURL = "http://localhost:8080/api"
axios.defaults.headers.get['Content-Type'] = 'application/json;charset=utf-8';
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*';

export default {

  getInquiries : function() {
    return axios.get('/inquiry/list');
  },
  getLogin : async function(id, passwd) {
      return await axios.get('/login', {
        auth: {
          "id": id,
          "passwd": passwd
        }
      });
  },
  save : function(form){
    return axios.post('/inquiry/create',form)
  }

}
