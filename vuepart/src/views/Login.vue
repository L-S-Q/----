<template>
  <el-row class="login">
    <h1><i>登录</i></h1>
    <div>
      <el-input placeholder="请输入用户名" prefix-icon="el-icon-user" style="margin: 30px" v-model="form.username"></el-input>
      <el-input placeholder="请输入密码" prefix-icon="el-icon-lock" style="margin: 30px" show-password
        v-model="form.password"></el-input>
    </div>

    <div>
      <el-button type="primary" @click="login">登录</el-button>
      <el-button type="warning" @click="Register">注册</el-button>
      <el-dialog title="用户信息" :visible.sync="dialogFormVisible" style="margin: 5px">
        <el-form>
          <el-form-item label="用户名">
            <el-input v-model="form.username" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.password" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="register">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </el-row>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      username: '',
      password: '',
      dialogFormVisible: false,
      form: {},
    }
  },
  methods: {
    login() {
      this.request.post("/login", this.form).then(res => {
        if (!res) {
          this.$message.error("用户名或密码错误")
        } else {
          this.$message.success("登陆成功")
          this.$router.push("/user")
        }
      })
    },
    register() {
      this.request.post('/login/register', this.form).then(res => {
        if (res) {
          this.$message.success("保存成功")
          this.dialogFormVisible = false
        } else {
          this.$message.error("保存失败")
        }
      })
    },
    Register() {
      this.dialogFormVisible = true
      this.form = {}
    },
  }
}
</script>

<style scoped>
.login {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  color: black;

  padding: 10vh 10vw;

  background-color: #81D8CF;
  opacity: .8;
  outline: none;
  border: none;
  border-radius: 10px;
  box-shadow: 2px 2px 6px #262626;
}
</style>
