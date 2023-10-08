<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-container>

      <el-header style="text-align: left; font-size: 20px">
        <Header />
      </el-header>

      <el-main>
        <div style="padding: 10px 0">
          <el-input style="width: 250px" placeholder="请输入名称" v-model="name"></el-input>
          <el-input style="width: 250px;margin-left: 10px" placeholder="请输入身份证号码" v-model="idcard"></el-input>
          <el-input style="width: 250px;margin-left: 10px" placeholder="请输入地址" v-model="address"></el-input>
          <el-button style="margin-left: 10px" @click="load">搜索</el-button>
          <el-button style="margin-left: 10px" type="warning" @click="reset">重置</el-button>
        </div>
        <div style="margin: 10px 0">
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </div>
        <el-table :data="tableData">
          <el-table-column prop="id" label="ID" width="80"></el-table-column>
          <el-table-column prop="name" label="姓名" width="80"></el-table-column>
          <el-table-column prop="sex" label="性别" width="80"></el-table-column>
          <el-table-column prop="birthday" label="出生日期" width="200"></el-table-column>
          <el-table-column prop="idcard" label="身份证号码" width="200"></el-table-column>
          <el-table-column prop="nation" label="民族" width="80"></el-table-column>
          <el-table-column prop="address" label="住址" width="300"></el-table-column>

          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="success" @click="handleEdit(scope.row)">编辑</el-button>

              <el-button type="danger" @click="handleDelete(scope.row.id)" style="margin-left: 10px">删除</el-button>

            </template>
          </el-table-column>

        </el-table>
        <div style="padding: 10px 0">
          <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageNum"
            :page-sizes="[5, 10, 15, 20]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper"
            :total="total">
          </el-pagination>
        </div>

        <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="50%">
          <el-form label-width="100px">
            <el-form-item label="姓名">
              <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-input v-model="form.sex" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="出生日期">
              <el-input v-model="form.birthday" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="身份证号码">
              <el-input v-model="form.idcard" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="民族">
              <el-input v-model="form.nation" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="住址">
              <el-input v-model="form.address" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="save">确 定</el-button>
          </div>
        </el-dialog>
      </el-main>
    </el-container>
  </el-container>
</template>

<style>
.el-header {
  background-color: #66b1ff;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

<script>
import Aside from "@/components/Aside.vue";
import Header from "@/components/Header.vue";

export default {
  name: "Manage",
  components: { Header },
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 5,
      name: "",
      sex: "",
      birthday: "",
      nation: "",
      idcard: "",
      address: "",
      form: {},
      dialogFormVisible: false,
    }
  },
  created() {
    //请求分页查询数据
    this.load()
  },
  comments: {
    Aside
  },
  methods: {
    reset() {
      this.name = ""
      this.idcard = ""
      this.address = ""
      this.load()
    },
    load() {
      this.request.get('/user/page', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          name: this.name,
          idcard: this.idcard,
          address: this.address
        }
      }).then(res => {  /*+'&id_card='+this.id_card+'&address='+this.address*/
        console.log(res)

        this.tableData = res.records
        this.total = res.total
      })
    },
    save() {
      this.request.post('/user', this.form).then(res => {
        if (res) {
          this.$message.success("保存成功")
          this.dialogFormVisible = false
          this.load()
        } else {
          this.$message.error("保存失败")
        }
      })
    },
    handleEdit(row) {
      this.form = row
      this.dialogFormVisible = true
    },
    handleDelete(id) {
      this.request.delete('/user/' + id).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    handleSizeChange(pageSize) {
      console.log(pageSize);
      this.pageSize = pageSize;
      this.load()
    },
    handleCurrentChange(pageNum) {
      console.log(pageNum);
      this.pageNum = pageNum;
      this.load()
    },
    handleAdd() {
      this.dialogFormVisible = true
      this.form = {}
    },
  }
};
</script>
