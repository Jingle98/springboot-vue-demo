<template>
  <div style="width: 100%; height: 100vh;background-color: darkslateblue;overflow: hidden">
    <div style="width: 400px; margin: 150px auto">
        <div style="color:#cccccc; font-size: 30px; text-align: center;padding: 30px 0; ">欢迎登录</div>
        <el-form ref="form" :model="form" size="normal" >
          <el-form-item >
            <el-input prefix-icon="el-icon-user-solid" v-model="form.username" placeholder="请输入账号"></el-input>
          </el-form-item>
          <el-form-item >
            <el-input prefix-icon="el-icon-lock" v-model="form.password" show-password placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item >
            <el-button style="width: 100%;" type="primary" @click="login">登录</el-button>
          </el-form-item>

        </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Login",
  data() {
    return {
      form:{}
    }
  },
  methods:{
    login() {
      request.post("/api/user/login", this.form).then(res => {
        debugger
        if (res.code === '0') {
          debugger
          this.$message({
            type: "success",
            message: "登录成功"
          })
          // sessionStorage.setItem("user", JSON.stringify(res.data))  // 缓存用户信息
          this.$router.push("/")  //登录成功之后进行页面的跳转，跳转到主页
        } else {
          debugger
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>