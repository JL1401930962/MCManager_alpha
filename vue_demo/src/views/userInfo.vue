<template>
  <div class="container">
    <el-table :data="filterTableData" :key="row => row.userid" style="width: 100%" height="100%">
      <el-table-column type="index" />
      <el-table-column label="用户ID" prop="userid" width="100px"/>
      <el-table-column label="头像" width="120px" >
        <template #default="scope">
          <el-image
            style="width: 60px; height: 60px"
            :src="scope.row.head"
            :preview-src-list="[scope.row.head]"
            hide-on-click-modal="true"
            preview-teleported="true"
          >
          </el-image>
        </template>
      </el-table-column>
      <el-table-column label="用户名" prop="username" width="150px"/>
      <el-table-column label="个性签名" prop="signature" />
      <el-table-column label="性别" width="80px">
        <template #default="{ row }">
          <div v-if="row.sex === 1">男</div>
          <div v-else-if="row.sex === 2">女</div>
          <div v-else>未知</div>
        </template>
      </el-table-column>
      <el-table-column label="年龄" prop="age" width="80px" />
      <el-table-column align="center" width="150">
        <template #header>
          <el-input
            v-model="search"
            size="small"
            placeholder="搜索用户名或ID"
          />
        </template>
        <template #default="scope">
          <el-button size="small" type="success" @click="edit(scope.row)"
          >修改</el-button
          >
          <el-button size="small" type="danger" @click="deleteUserById(scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- 编辑/ -->
    <el-dialog v-model="editUserVisi" title="修改用户" draggable>
      <el-form :model="form">
        <el-form-item label="用户ID" label-width="140px">
          <el-input v-model="form.userid" disabled style="width: 350px" />
        </el-form-item>
        <el-form-item label="用户密码" label-width="140px">
          <el-input v-model="form.password" style="width: 350px" />
        </el-form-item>
        <el-form-item label="用户名" label-width="140px">
          <el-input
            v-model="form.username"
            autocomplete="off"
            style="width: 350px"
          />
        </el-form-item>
        <el-form-item label="个性签名" label-width="140px">
          <el-input
            v-model="form.signature"
            autocomplete="off"
            type="textarea"
            :autosize="{ minRows: 2, maxRows: 4 }"
            style="width: 350px"
          />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="editUserVisi = false">取消</el-button>
          <el-button type="primary" @click="saveEdit">保存</el-button>
        </span>
      </template>
    </el-dialog>

  </div>
</template>

<script>
import axios from "axios";
import {ElMessage} from "element-plus";

export default {
  name: "user",
  data() {
    return {
      // 输入框
      search: "",
      // 表格数据
      tableData: [
        {"username":"JL222","userid":"1401930962","head":"http://106.52.19.146:8787/staticdata/DynamicImage/20230505/3cf8ea97-8111-4273-9124-c05b8238998d.png","password":"disappear","signature":"这种感觉，泰裤辣！","age":0,"sex":0}
      ],
      // 编辑对话框是否显示
      editUserVisi: false,
      // 添加对话框是否显示
      addUserVisi: false,
      // 表单数据
      form: "",
    };
  },
  created() {
    // 获取用户信息
    this.getUserList();
  },
  computed: {
    // 表格数据过滤
    filterTableData() {
      return this.tableData.filter(
        (data) =>
          !this.search ||
          data.userid.includes(this.search) ||
          data.username.includes(this.search)
      );
    },
  },
  methods: {
    // 消息提示
    showMsg(msg, type) {
      ElMessage({
        message: msg,
        type: type,
      });
    },
    // 获取用户信息
    getUserList() {
      var url = "/api/user/getAllUser/"
      var that = this
      console.log(url)
      axios.get(url).then(function(res) {

        console.log(res.data)
        that.tableData = res.data
      }).catch(function(reason) {
        console.log("获取用户信息失败")
        console.log(reason)
        // this.tableData = []
      })
    },
    // 编辑
    edit(row) {
      console.log(row);
      this.form = JSON.parse(JSON.stringify(row));
      this.editUserVisi = true;
    },
    // 保存编辑
    saveEdit() {
      console.log("保存编辑");
      console.log(this.form);
      let url = "/api/user/updateUser";
      axios.post(url).then(function(res) {
        if (res.data != null) {
          this.showMsg("更新成功","success")
          // 关闭对话框
          this.editUserVisi = false;
          // 更新数据
          this.getUserList();
        } else {
          this.showMsg("更新失败","error")
        }
      });
    },
    // 添加
    add() {
      this.form = {};
      this.addUserVisi = true;
    },
    // 保存添加
    saveAdd() {
      console.log("保存添加");
      console.log(this.form);
      let url = "/api/user/addUser";
      axios.post(url).then(function(res) {
        if (res.data!=null) {
          this.showMsg("添加成功","success")
          // 关闭对话框
          this.addUserVisi = false;
          // 更新数据
          this.getUserList();
        } else {
          this.showMsg("添加失败","error")
        }
      });
    },
    // 删除
    deleteUserById(e) {
      console.log(e.userid);
      let userid = e.userid;
      let url = "/api/user/deleteUserById?userid=" + userid;
      axios.post(url).then(function(res) {
        if (res.data != null) {
          // 删除成功
          this.showMsg("删除成功","success")
          // 更新数据
          this.getUserList();
        } else {
          this.showMsg("删除失败","error")
        }
      });
    }
  },
};
</script>

<style scoped></style>

<style></style>
