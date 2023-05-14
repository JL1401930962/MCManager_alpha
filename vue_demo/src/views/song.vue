<template>
  <div class="container">
    <el-table :data="filterTableData" :key="row => row.songid" style="width: 100%" height="100%">
      <el-table-column type="index" />

      <el-table-column label="专辑图片" width="150px" >
        <template #default="scope">
          <el-image
            style="width: 60px; height: 60px"
            :src="scope.row.icon"
            :preview-src-list="[scope.row.icon]"
            hide-on-click-modal="true"
            preview-teleported="true"
          >
          </el-image>
        </template>
      </el-table-column>
      <el-table-column label="歌曲ID" prop="songid" width="150px"/>
      <el-table-column label="歌曲名" prop="songname" width="150px"/>
      <el-table-column label="歌手ID" prop="artistid" width="150px"/>
      <el-table-column label="歌手名" prop="artistname" width="150px"/>
      <el-table-column label="专辑ID" prop="albumid" width="150px"/>
      <el-table-column label="专辑名" prop="albumname" width="150px"/>
      <el-table-column label="歌曲地址" prop="songurl" width="150px"/>
      <el-table-column label="歌曲大小" prop="size" width="80px" />
      <el-table-column align="center" width="150">
        <template #header>
          <el-input
            v-model="search"
            size="small"
            placeholder="搜索名称或ID"
          />
        </template>
        <template #default="scope">
          <el-button size="small" type="danger" @click="moreDetail(scope.row)"
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
  name: "song",
  data() {
    return {
      // 输入框
      search: "",
      // 表格数据
      tableData: []
    };
  },
  created() {
    // 获取用户信息
    this.getSongList();
  },
  computed: {
    // 表格数据过滤
    filterTableData() {
      return this.tableData.filter(
        (data) =>
          !this.search ||
          data.songid.includes(this.search) ||
          data.songname.includes(this.search)
      );
    },
  },
  methods: {
    // 获取用户信息
    getSongList() {
      var url = "/api/song/getAllSong/"
      var that = this
      console.log(url)
      axios.get(url).then(function(res) {

        console.log(res.data)
        that.tableData = res.data
      }).catch(function(reason) {
        console.log("获取歌曲数据失败")
        console.log(reason)
        // this.tableData = []
      })
    },
  },
};
</script>

<style scoped></style>

<style></style>
