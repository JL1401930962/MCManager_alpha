<template>
  <div class="container">
    <el-table :data="filterTableData" style="width: 100%" height="80%">
      <el-table-column type="expand">
        <template #default="scope">
          <div m="4">
            <p>{{ scope.row.content }}</p>
            <el-image
              v-for="item in scope.row.imgs"
              style="width: 100px; height: 60px; align-content: center"
              :src="item"
              :preview-src-list="[item]"
              hide-on-click-modal="true"
              preview-teleported="true"
            >
            </el-image>
            <!--          <p v-for="item in scope.row.comments">{{ item.username }}: {{ item.content }}</p>-->
          </div>
        </template>
      </el-table-column>
      <el-table-column label="ID" prop="post_id" width="50px" />
      <el-table-column label="头像" width="85px">
        <template #default="scope">
          <el-image
            style="width: 60px; height: 60px; align-content: center"
            :src="scope.row.head"
            :preview-src-list="[scope.row.head]"
            hide-on-click-modal="true"
            preview-teleported="true"
          >
          </el-image>
        </template>
      </el-table-column>
      <el-table-column label="昵称" prop="username" width="100px" />
      <el-table-column
        label="内容"
        prop="content"
        width="180px"
        align="center"
      />
      <el-table-column label="动态图片" align="center">
        <template #default="scope">
          <el-image
            style="width: 120px; height: 85px; margin-right: 5px"
            :src="scope.row.picture"
            :preview-src-list="[scope.row.picture]"
            hide-on-click-modal="true"
            preview-teleported="true"
          >
          </el-image>
        </template>
      </el-table-column>
      <el-table-column
        label="歌曲ID"
        prop="songid"
        width="120px"
        align="center"
      />
      <el-table-column label="点赞数" prop="like_num" width="70px" />
      <el-table-column label="评论数" prop="comment_num" width="70px" />
      <el-table-column label="发布时间" prop="post_time" width="160" sortable />
      <el-table-column align="center" width="150">
        <template #header>
          <el-input v-model="search" size="small" placeholder="搜索用户名" />
        </template>
        <template #default="scope">
          <el-button size="small" type="primary" @click="moreDetail(scope.row)"
            >查看</el-button
          >
          <el-button
            size="small"
            type="danger"
            @click="deletePostById(scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
  <!-- 评论内容 -->
  <el-dialog
    v-model="commentVisi"
    title="评论详情"
    style="width: 750px"
    draggable
  >
    <el-table :data="comments" style="width: 100%" height="94%">
      <el-table-column type="index" />
      <el-table-column label="用户ID" prop="userid" width="120" />
      <el-table-column label="用户名" prop="username" width="140" />
      <el-table-column label="评论内容" prop="content" />
      <el-table-column label="评论日期" prop="comment_date" width="100" />
      <el-table-column align="center" width="80" label="操作">
        <template #default="scope">
          <el-button
            size="small"
            type="danger"
            @click="deleteComment(scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </el-dialog>
</template>

<script>
import axios from "axios";
import { ElMessage } from "element-plus";

export default {
  name: "post",
  data() {
    return {
      // 输入框
      search: "",
      // 表格数据
      tableData: [
        {
          post_id: 1,
          userid: "123",
          username: "测试人员",
          head: "http://106.52.19.146:8787/staticdata/DynamicImage/20230505/9cf0f9ca-9c2e-4e6d-bd37-51a5a74a38ce.jpg",
          post_time: "2023-04-13 14:01:57",
          content:
            "抢到第一，运气来自实力，实力来自努力。建议你们去好好调研一下。",
          picture:
            "http://106.52.19.146:8787/staticdata/DynamicImage/20230505/3cf8ea97-8111-4273-9124-c05b8238998d.png",
          songid: 27804646,
          comment_num: 2,
          like_num: 1,
        },
        {
          post_id: 2,
          userid: "1401930962",
          username: "JL222",
          head: "http://106.52.19.146:8787/staticdata/DynamicImage/20230505/3cf8ea97-8111-4273-9124-c05b8238998d.png",
          post_time: "2023-04-13 04:05:58",
          content: "起码有个板凳。III~~ am 2nddd~~~",
          picture:
            "http://106.52.19.146:8787/staticdata/DynamicImage/20230505/6c3a1952-1db0-4232-a96b-459252377c0e.jpg",
          songid: null,
          comment_num: 0,
          like_num: 4,
        },
      ],
      // 表单
      form: "",
      // 评论弹框框是否显示
      commentVisi: false,
      // 添加对话框是否显示
      addVisi: false,
      // 评论内容
      comments: [],
    };
  },
  created() {
    this.getPostList();
  },
  computed: {
    // 表格数据过滤
    filterTableData() {
      return this.tableData.filter(
        (data) => !this.search || data.username.includes(this.search)
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
    // 获取动态信息
    getPostList() {
      var url = "/api/post/getAllPost/";
      var that = this;
      console.log(url);
      axios
        .get(url)
        .then(function (res) {
          console.log(res.data);
          that.tableData = res.data;
        })
        .catch(function (reason) {
          console.log("获取帖子数据失败");
          console.log(reason);
          // this.tableData = []
        });
    },
    // 编辑
    edit(row) {
      console.log(row);
      this.form = JSON.parse(JSON.stringify(row));
      this.editVisi = true;
    },
    // 保存编辑
    saveEdit() {
      console.log("保存编辑");
      console.log(this.form);
      let url = "/api/post/updatePost";
      axios.post(url).then(function (res) {
        if (res.data != null) {
          this.showMsg("更新成功", "success");
          // 关闭对话框
          this.editVisi = false;
          // 更新数据
          this.getPostList();
        } else {
          this.showMsg("更新失败", "error");
        }
      });
    },

    // 删除
    deletePostById(e) {
      console.log(e.post_id);
      let post_id = e.post_id;
      let url = "/api/post/deletePostById?post_id=" + post_id;
      axios.post(url).then(function (res) {
        if (res.data != null) {
          this.getPostList();
          // 删除成功
          this.showMsg("删除成功", "success");
          // 更新数据
        } else {
          this.showMsg("删除失败", "error");
        }
      });
    },
    // 查看
    // moreDetail(row) {
    //   this.form = JSON.parse(JSON.stringify(row));
    //   this.postVisi = true;
    //   const post_id = row.post_id;
    //   this.$router.push({
    //     path: "/layout/comment",
    //     params: { post_id },
    //   });
    // },
    moreDetail(row) {
      var that = this;
      that.comments = [];
      var url = "/api/comment/getCommentByPostId?post_id=" + row.post_id;
      axios.get(url).then(function (res) {
        console.log(res.data);
        that.comments = res.data;
      });
      that.commentVisi = true;
    },
    // 删除评论
    deleteComment(row) {
      let comments = this.comments;
      // console.log(row);
      let comment_id = row.comment_id;
      for (let i = 0; i < comments.length; i++) {
        if (comment_id == comments[i].comment_id) {
          comments.splice(i, 1);
          console.log(comments);
          this.comments = comments;
          break;
        }
      }
      // 真正删除
      this.delete(comment_id);
    },
    // 删除评论
    delete(comment_id) {
      let that=this;
      var url = "/api/comment/delete?comment_id=" + comment_id;
      axios.get(url).then(function (res) {
        console.log(res);
        that.showMsg("删除成功", "success");
      });
    },
  },
};
</script>

<style scoped></style>

<style></style>
