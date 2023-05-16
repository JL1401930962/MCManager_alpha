<template>
  <div class="container">
    <el-table
      :data="filterTableData"
      :key="(row) => row.comment_id"
      style="width: 100%"
      height="100%"
    >
      <!--      <el-table-column type="index" />-->

      <el-table-column label="评论ID" prop="comment_id" width="80" />
      <el-table-column label="帖子ID" prop="post_id" width="80" />
      <el-table-column label="用户ID" prop="userid" width="150" />
      <el-table-column label="用户名" prop="username" width="150" />
      <el-table-column label="评论内容" prop="content" />
      <el-table-column label="评论日期" prop="comment_date" width="150" />

      <el-table-column align="center" width="150px">
        <template #header>
          <el-input v-model="search" size="small" placeholder="搜索名称或ID" />
        </template>
        <template #default="scope">
          <el-button size="small" type="danger" @click="delete scope.row"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "comment",
  data() {
    return {
      // 输入框
      search: "",
      // 表格数据
      tableData: [],
    };
  },
  created() {
    // 获取评论信息
    if (this.$route.params.post_id) {
      this.getCommentBtPostId(this.$route.params.post_id);
    } else {
      this.getCommentList();
    }
  },
  computed: {
    // 表格数据过滤
    filterTableData() {
      return this.tableData.filter(
        (data) =>
          !this.search ||
          data.commentid.includes(this.search) ||
          data.username.includes(this.search)
      );
    },
  },
  methods: {
    // 获取用户信息
    getCommentList() {
      var url = "/api/comment/getAllComment/";
      var that = this;
      axios
        .get(url)
        .then(function (res) {
          console.log(url);
          console.log(res.data);
          that.tableData = res.data;
        })
        .catch(function (reason) {
          console.log("获取评论数据失败");
          console.log(reason);
          // this.tableData = []
        });
    },
    getCommentBtPostId(post_id) {
      var url = "/api/comment/getCommentByPostId?post_id=" + post_id;
      var that = this;
      axios
        .get(url)
        .then(function (res) {
          console.log(url);
          console.log(res.data);
          that.tableData = res.data;
        })
        .catch(function (reason) {
          console.log("获取评论数据失败");
          console.log(reason);
        });
    },
    // 删除评论
    delete() {
      console.log("哈哈哈");
    },
  },
};
</script>

<style scoped></style>

<style></style>
