<template>
  <div class="container">
    <el-table
      :data="filterTableData"
      style="width: 100%"
      align="left"
      height="94%"
    >
      <el-table-column type="index" label="index" align="left" width="80px" />
      <el-table-column
        label="用户ID"
        prop="userid"
        
        align="center"
      />
      <el-table-column
        label="帖子ID"
        prop="post_id"
        
        align="center"
      />
      <el-table-column
        label="点赞状态"
        prop="like_state"
        width="150px"
        align="center"
      />
      <el-table-column width="150px">
        <template #header>
          <el-input v-model="search" size="small" placeholder="搜索名称" />
        </template>
      </el-table-column>
    </el-table>
    <!--    <el-button style="width: 30%;bottom: inherit;" type="primary" @click="add"-->
    <!--      >通往异世界的大门</el-button-->
    <!--    >-->
  </div>
  <!--  &lt;!&ndash; 编辑/ &ndash;&gt;-->
  <!--  <el-dialog v-model="editCategoryVisi" title="更新类别" draggable>-->
  <!--    <el-form :model="form">-->
  <!--      <el-form-item label="类别编号" label-width="140px">-->
  <!--        <el-input v-model="form.categoryId" disabled style="width: 350px" />-->
  <!--      </el-form-item>-->
  <!--      <el-form-item label="类别名称" label-width="140px">-->
  <!--        <el-input-->
  <!--          v-model="form.categoryName"-->
  <!--          autocomplete="off"-->
  <!--          style="width: 350px"-->
  <!--        />-->
  <!--      </el-form-item>-->
  <!--      <el-form-item label="类别描述" label-width="140px">-->
  <!--        <el-input-->
  <!--          v-model="form.categoryDesc"-->
  <!--          autocomplete="off"-->
  <!--          type="textarea"-->
  <!--          :autosize="{ minRows: 2, maxRows: 4 }"-->
  <!--          style="width: 350px"-->
  <!--        />-->
  <!--      </el-form-item>-->
  <!--    </el-form>-->
  <!--    <template #footer>-->
  <!--      <span class="dialog-footer">-->
  <!--        <el-button @click="editCategoryVisi = false">取消</el-button>-->
  <!--        <el-button type="primary" @click="saveEdit">保存</el-button>-->
  <!--      </span>-->
  <!--    </template>-->
  <!--  </el-dialog>-->

  <!--  &lt;!&ndash; 新增/ &ndash;&gt;-->
  <!--  <el-dialog v-model="addCategoryVisi" title="添加类别" draggable>-->
  <!--    <el-form :model="form">-->
  <!--      <el-form-item label="类别ID" label-width="140px">-->
  <!--        <el-input v-model="form.categoryId" style="width: 350px" />-->
  <!--      </el-form-item>-->
  <!--      <el-form-item label="类别名称" label-width="140px">-->
  <!--        <el-input-->
  <!--          v-model="form.categoryName"-->
  <!--          autocomplete="off"-->
  <!--          style="width: 350px"-->
  <!--        />-->
  <!--      </el-form-item>-->
  <!--      <el-form-item label="类别描述" label-width="140px">-->
  <!--        <el-input-->
  <!--          v-model="form.categoryDesc"-->
  <!--          autocomplete="off"-->
  <!--          type="textarea"-->
  <!--          :autosize="{ minRows: 2, maxRows: 4 }"-->
  <!--          style="width: 350px"-->
  <!--        />-->
  <!--      </el-form-item>-->
  <!--    </el-form>-->
  <!--    <template #footer>-->
  <!--      <span class="dialog-footer">-->
  <!--        <el-button @click="addCategoryVisi = false">取消</el-button>-->
  <!--        <el-button type="primary" @click="saveAdd">保存</el-button>-->
  <!--      </span>-->
  <!--    </template>-->
  <!--  </el-dialog>-->
</template>

<script>
import { ElMessage } from "element-plus";
import axios from "axios";
export default {
  name: "likes",
  data() {
    return {
      // 输入框
      search: "",
      // 表格数据
      tableData: [
        {
          userid: "1401930962",
          post_id: "1",
          like_state: true,
        },
        {
          userid: "1401930962",
          post_id: "2",
          like_state: true,
        },
        {
          userid: "1401930962",
          post_id: "4",
          like_state: true,
        },
        {
          userid: "1401930962",
          post_id: "5",
          like_state: false,
        },
      ],
    };
  },
  created() {
    // 获取垃圾类别
    this.getLikesList();
  },
  computed: {
    // 表格数据过滤
    filterTableData() {
      return this.tableData.filter(
        (data) => !this.search || data.categoryName.includes(this.search)
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
    // 获取类别信息
    getLikesList() {
      var url = "/api/likes/getAllLikes/";
      var that = this;
      console.log(url);
      axios
        .get(url)
        .then(function (res) {
          console.log(res.data);
          that.tableData = res.data;
        })
        .catch(function (reason) {
          console.log("获取点赞数据失败");
          console.log(reason);
          // this.tableData = []
        });
    },
  },
};
</script>

<style scoped>
.container {
  height: 100%;
}
</style>

<style></style>
