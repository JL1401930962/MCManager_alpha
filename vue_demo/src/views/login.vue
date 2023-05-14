<template>
  <div class="login-container">
    <div class="login">
      <div class="pic">
        <img src="../assets/default_picture.jpg" alt="背景图片" />
      </div>
      <div class="form">
        <h3 style="color: rgb(2, 143, 204)">音乐社区后台数据 欢迎登录</h3>
        <div class="loginItem">
          <div class="txt">账号</div>
          <div class="valueInput">
            <input
              type="text"
              placeholder="请输入账号"
              v-model="loginForm.account"
            />
          </div>
        </div>
        <div class="loginItem">
          <div class="txt">密码</div>
          <div class="valueInput">
            <input
              type="password"
              placeholder="请输入密码"
              v-model="loginForm.password"
            />
          </div>
        </div>
        <!-- <div class="foot">
          <div class="box">
            <router-link to="/register">立即注册</router-link>
          </div>
          <div class="box">
            <router-link to="/resetpassword">忘记密码</router-link>
          </div>
        </div> -->
        <div class="loginBtn">
          <button class="btn" @click="submitLogin"><div>登 录</div></button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ElMessage } from "element-plus";
export default {
  name: "login",
  data() {
    return {
      loginForm: {
        account: "",
        password: "",
      },
    };
  },
  computed: {},
  methods: {
    // 消息提示
    remind(msg, type) {
      ElMessage({
        message: msg,
        type: type,
      });
    },
    //正则表达式判断字符串是否为电话码
    isPhone(tel) {
      var regx = /^[1][3,4,5,7,8,9][0-9]{9}$/;
      return regx.test(tel);
    },

    //提交登录
    submitLogin() {
      // if (this.loginForm.account == "") {
      //   this.remind("手机号码不能为空", "error");
      //   return;
      // }
      // if (!this.isPhone(this.loginForm.account)) {
      //   this.remind("请输入正确的手机号码", "error");
      //   return;
      // }
      // if (this.loginForm.password == "") {
      //   this.remind("密码不能为空", "error");
      //   return;
      // }
      // let url =
      //     "/api/admin/login?adminAccount=" +
      //     this.loginForm.account +
      //     "&adminPwd=" +
      //     this.loginForm.password;
      // this.$http.get(url).then((res) => {
      //   if(res.code!=1){
      //     // 登录成功
      //     this.$router.replace('/layout');
      //   }else{
      //     this.remind(res.msg,"error")
      //   }
      // });
      this.$router.replace('/layout');
    },
  },
};
</script>

<style scoped>
.login-container {
  min-width: 1200px;
  /* border: 5px solid red; */
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgb(235, 238, 239);
}
.login {
  /* border: 2px solid red; */
  width: 50%;
  height: 360px;
  display: flex;
  border-radius: 10px;
  box-shadow: 5px 5px 2px rgba(0, 0, 0, 0.37);
  background-color: rgb(255, 255, 255);
}
.pic {
  /* border: 2px solid red; */
  width: 50%;
  height: 100%;

}
.pic img {
  width: 100%;
  height: 100%;
}
.form {
  /* border: 1px solid red; */
  width: 65%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.loginItem {
  /* border: 1px solid red; */
  margin-top: 2%;
  width: 55%;
  height: 15%;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.loginItem .txt {
  /* border: 1px solid red; */
  width: 20%;
  font-size: 15px;
  text-align: right;
}
.loginItem .valueInput {
  /* border: 1px solid red; */
  width: 74%;
  height: 70%;
  display: flex;
  align-items: center;
  /* border-bottom: 1px solid rgb(175, 172, 172); */
  border-bottom: 1px solid rgb(105, 131, 236);
}
.valueInput input {
  border: none;
  outline: none;
  box-sizing: border-box;
  width: 100%;
}
.foot {
  /* border:  1px solid red; */
  margin-top: 3%;
  margin-left: 14.5%;
  width: 40%;
  height: 10%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  right: 13%;
}
.foot .box {
  font-size: 13px;
}
.loginBtn {
  margin-top: 5%;
  height: 35px;
  width: 20%;
}
.loginBtn .btn {
  /* border: 1px solid red; */
  height: 100%;
  width: 100%;
  border-radius: 20px;
  border: none;
  cursor: pointer;
  background-color: rgb(2, 143, 204);
}
.btn div {
  color: aliceblue;
}
</style>
