webpackJsonp([1],{"+flB":function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=n("7+uW"),a={render:function(){var t=this.$createElement,e=this._self._c||t;return e("header",[e("div",{attrs:{id:"nav"}},[e("router-link",{attrs:{to:"/"}},[this._v("Home")]),this._v(" |\n    "),e("router-link",{attrs:{to:"/write"}},[this._v("문의 하기")]),this._v(" |\n    "),e("router-link",{attrs:{to:"/inquiry/list"}},[this._v("고객 상담 게시판")]),this._v(" |\n    "),e("router-link",{attrs:{to:"/login"}},[this._v("상담사 로그인 ")])],1)])},staticRenderFns:[]};var s={name:"App",components:{Header:n("VU/8")(null,a,!1,function(t){n("qMhL")},"data-v-09cba1a2",null).exports}},i={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("Header"),this._v(" "),e("router-view")],1)},staticRenderFns:[]};var o=n("VU/8")(s,i,!1,function(t){n("RKad")},null,null).exports,u=n("/ocq"),c={render:function(){var t=this.$createElement;return(this._self._c||t)("div")},staticRenderFns:[]},l=n("VU/8")(null,c,!1,null,null,null).exports,d=n("//Fk"),p=n.n(d),v=n("d7EF"),f=n.n(v),h=n("Xxa5"),_=n.n(h),m=n("exGp"),w=n.n(m),g=n("mtWM"),x=n.n(g);x.a.defaults.baseURL="http://localhost:8080/api",x.a.defaults.headers.get["Content-Type"]="application/json;charset=utf-8",x.a.defaults.headers.get["Access-Control-Allow-Origin"]="*";var b=function(t,e){var n={user_id:t,user_pw:e};return x.a.post("/auth/login",n,{headers:{"Content-type":"application/json"}})},y={getInquiries:function(){return x.a.get("/inquiry/list")},getLogin:function(){var t=w()(_.a.mark(function t(e,n){return _.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,x.a.get("/login",{auth:{id:e,passwd:n}});case 2:return t.abrupt("return",t.sent);case 3:case"end":return t.stop()}},t,this)}));return function(e,n){return t.apply(this,arguments)}}(),save:function(t){return x.a.post("/inquiry/create",t)},doLogin:function(t,e){var n=this;return w()(_.a.mark(function r(){var a,s,i,o;return _.a.wrap(function(n){for(;;)switch(n.prev=n.next){case 0:return n.prev=0,a=b(t,e),n.next=4,p.a.all([a]);case 4:if(s=n.sent,i=f()(s,1),0!==(o=i[0]).data.length){n.next=11;break}return n.abrupt("return","notFound");case 11:return localStorage.setItem("user_token",o.data.user_token),localStorage.setItem("user_role",o.data.user_role),n.abrupt("return",o);case 14:n.next=19;break;case 16:n.prev=16,n.t0=n.catch(0),console.error(n.t0);case 19:case"end":return n.stop()}},r,n,[[0,16]])}))()}},E={data:function(){return{items:null}},mounted:function(){var t=this;y.getInquiries().then(function(e){t.items=e.data}).catch(function(t){console.log(t)})}},k={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("table",{attrs:{align:"center"}},[t._m(0),t._v(" "),t._l(t.items,function(e,r){return n("tr",{key:r},[n("td",[t._v(t._s(e.id))]),t._v(" "),n("td",[t._v(t._s(e.customerId))]),t._v(" "),n("td",[t._v(t._s(e.title))]),t._v(" "),n("td",["WATTING"==e.status?n("span",[t._v(" 답변대기")]):"PROGRESS"==e.status?n("span",[t._v(" 답변중")]):"COMPLETE"==e.status?n("span",[t._v(" 답변완료")]):t._e()]),t._v(" "),n("td",[t._v(t._s(e.regDate))])])})],2)},staticRenderFns:[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("thead",[n("th",[t._v("번호")]),t._v(" "),n("th",[t._v("고객ID")]),t._v(" "),n("th",[t._v("제목")]),t._v(" "),n("th",[t._v("상태")]),t._v(" "),n("th",[t._v("등록일")])])}]};var I=n("VU/8")(E,k,!1,function(t){n("w4iX")},"data-v-d5f52300",null).exports,S={data:function(){return{requestBody:this.$route.query,idx:this.$route.query.idx,title:"",name:"",contents:"",created_at:""}},mounted:function(){this.fnGetView()},methods:{fnGetView:function(){var t=this;void 0!==this.idx&&this.$axios.get(this.$serverUrl+"/board/"+this.idx,{params:this.requestBody}).then(function(e){t.title=e.data.title,t.author=e.data.author,t.contents=e.data.contents,t.created_at=e.data.created_at}).catch(function(t){console.log(t)})},fnList:function(){delete this.requestBody.idx,this.$router.push({path:"./inquiry/list",query:this.requestBody})},fnView:function(t){this.requestBody.idx=t,this.$router.push({path:"./inquiry/list",query:this.requestBody})},fnSave:function(){var t=this;void 0===this.idx?(this.form={title:this.title,contents:this.contents,customerId:this.name},y.save(this.form).then(function(e){alert("글이 저장되었습니다."),t.fnView(e.data.id)}).catch(function(t){t.message.indexOf("Network Error")>-1&&alert("네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.")})):this.axios.patch(this.form).then(function(e){alert("글이 저장되었습니다."),t.fnView(e.data.idx)}).catch(function(t){t.message.indexOf("Network Error")>-1&&alert("네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.")})}}},q={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"board-detail"},[n("div",{staticClass:"board-contents"},[n("input",{directives:[{name:"model",rawName:"v-model",value:t.title,expression:"title"}],staticClass:"w3-input w3-border",attrs:{type:"text",placeholder:"제목을 입력해주세요."},domProps:{value:t.title},on:{input:function(e){e.target.composing||(t.title=e.target.value)}}}),t._v(" "),void 0===t.idx?n("input",{directives:[{name:"model",rawName:"v-model",value:t.name,expression:"name"}],staticClass:"w3-input w3-border",attrs:{type:"text",placeholder:"작성자를 입력해주세요."},domProps:{value:t.name},on:{input:function(e){e.target.composing||(t.name=e.target.value)}}}):t._e()]),t._v(" "),n("div",{staticClass:"board-contents"},[n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.contents,expression:"contents"}],staticClass:"w3-input w3-border",staticStyle:{resize:"none"},attrs:{id:"",cols:"30",rows:"10"},domProps:{value:t.contents},on:{input:function(e){e.target.composing||(t.contents=e.target.value)}}})]),t._v(" "),n("div",{staticClass:"common-buttons"},[n("button",{staticClass:"w3-button w3-round w3-blue-gray",attrs:{type:"button"},on:{click:t.fnSave}},[t._v("저장")]),t._v(" \n    "),n("button",{staticClass:"w3-button w3-round w3-gray",attrs:{type:"button"},on:{click:t.fnList}},[t._v("목록")])])])},staticRenderFns:[]};var R=n("VU/8")(S,q,!1,function(t){n("c/8N")},"data-v-64517b58",null).exports,C=n("Dd8w"),A=n.n(C),L=n("NYxO"),N={data:function(){return{user_id:"",user_pw:""}},methods:A()({},Object(L.b)(["login"]),{fnLogin:function(){var t=this;return w()(_.a.mark(function e(){var n;return _.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:if(""!==t.user_id){e.next=3;break}return alert("ID를 입력하세요."),e.abrupt("return");case 3:if(""!==t.user_pw){e.next=6;break}return alert("비밀번호를 입력하세요."),e.abrupt("return");case 6:return e.prev=6,e.next=9,t.login({user_id:t.user_id,user_pw:t.user_pw});case 9:(n=e.sent)&&alert("로그인 결과 : "+n),e.next=16;break;case 13:e.prev=13,e.t0=e.catch(6),e.t0.message.indexOf("Network Error")>-1?alert("서버에 접속할 수 없습니다. 상태를 확인해주세요."):alert("로그인 정보를 확인할 수 없습니다.");case 16:case"end":return e.stop()}},e,t,[[6,13]])}))()}}),computed:A()({},Object(L.c)({errorState:"getErrorState"}))},O={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("div",[n("h2",[t._v("Please Log In")]),t._v(" "),n("div",{attrs:{id:"loginForm"}},[n("form",{on:{submit:function(e){return e.preventDefault(),t.fnLogin.apply(null,arguments)}}},[n("p",[n("input",{directives:[{name:"model",rawName:"v-model",value:t.user_id,expression:"user_id"}],staticClass:"w3-input",attrs:{name:"uid",placeholder:"Enter your ID"},domProps:{value:t.user_id},on:{input:function(e){e.target.composing||(t.user_id=e.target.value)}}}),n("br")]),t._v(" "),n("p",[n("input",{directives:[{name:"model",rawName:"v-model",value:t.user_pw,expression:"user_pw"}],staticClass:"w3-input",attrs:{name:"password",placeholder:"Enter your password",type:"password"},domProps:{value:t.user_pw},on:{input:function(e){e.target.composing||(t.user_pw=e.target.value)}}})]),t._v(" "),t._m(0)])])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("p",[e("button",{staticClass:"w3-button w3-green w3-round",attrs:{type:"submit"}},[this._v("Login")])])}]};var U=n("VU/8")(N,O,!1,function(t){n("+flB")},null,null).exports;r.a.use(u.a);var $,T=new u.a({mode:"history",routes:[{path:"/",name:"Home",component:l},{path:"/inquiry/list",name:"Inquiry",component:I},{path:"/write",name:"Write",component:R},{path:"/login",name:"Login",component:U}]}),P=n("bOdI"),F=n.n(P),V=($={},F()($,"USER_ID",function(t,e){t.userId=e}),F()($,"ERROR_STATE",function(t,e){t.errorState=e}),F()($,"IS_AUTH",function(t,e){t.isAuth=e}),F()($,"LOADING_STATUS",function(t,e){t.loadingStatus=e}),$),D=function(t,e){(0,t.commit)("ERROR_STATE",e)},B=function(t,e){(0,t.commit)("IS_AUTH",e)},H=function(t,e){switch(e){case"notFound":D(t,"Wrong ID or Password"),B(t,!1);break;default:n=t,r=e.user_id,(0,n.commit)("USER_ID",r),D(t,""),B(t,!0)}var n,r},G={login:function(t,e){var n=this,r=e.user_id,a=e.user_pw;return w()(_.a.mark(function e(){var s;return _.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,y.doLogin(r,a);case 2:return s=e.sent,H(t,s),e.abrupt("return",t.getters.getIsAuth);case 5:case"end":return e.stop()}},e,n)}))()}};r.a.use(L.a);var j=new L.a.Store({state:{user:null,isLogin:!1,loadingStatus:!1},mutations:V,getters:{getUserId:function(t){return t.userId},getErrorState:function(t){return t.errorState},getIsAuth:function(t){return t.isAuth}},actions:G});n("ZsCP");r.a.config.productionTip=!1,new r.a({el:"#app",router:T,components:{App:o},store:j,template:"<App/>"})},RKad:function(t,e){},ZsCP:function(t,e){},"c/8N":function(t,e){},qMhL:function(t,e){},w4iX:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.824771a1fe08db94929f.js.map