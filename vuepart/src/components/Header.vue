<template>
  <div>
    <span>人口数据库</span>
    <el-button type="danger" style="margin-left: 1000px" @click="quit">退出</el-button>
  </div>
</template>

<script>
export default {
  name: "Header",
  methods:{
    quit(){
      this.$router.replace("/")
    }
  }
}
</script>

<style scoped>

</style>
