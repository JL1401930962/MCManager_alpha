<template>
    <div class="container">
     <div class="left">
      <h4>音乐社区后台数据管理</h4>
      <el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
        default-active="/userInfo"
        
        text-color="#fff"
        @open="handleOpen"
        @close="handleClose"
        style="width: 100%;height: 92%;"
      >
        <el-sub-menu 
          v-for="(item,index) in hasChild"
          :key="index"
          :index="item.id"
          >
          <template #title>
            <span>{{ item.title }}</span>
          </template>
            <el-menu-item
              v-for="(item1,index) in item.children"
              :key="index"
              :index="item1.path"
              @click="clickMenu(item1.name,item1.title)"
            >{{ item1.title }}</el-menu-item>
            
        </el-sub-menu>

        <el-menu-item v-for="(item,index) in noChild"
          :key="index"
          :index="item.path"  
          @click="clickMenu(item.name,item.title)"
        >
          <span>{{ item.title }}</span>
        </el-menu-item>
      </el-menu>
     </div>
     <div class="right">
      <div class="head">
        <h4>{{ title }}</h4>
        <div class="my_info">
          <div class="pic">
              <img src="../assets/dj.jpg" alt="头像" >
          </div>
          <el-dropdown @command="handleCommand">
            <span class="nickName">1376</span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="a">信息修改</el-dropdown-item>
                <el-dropdown-item command="b">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </div>
      <div class="body">
        <router-view/>
      </div>
     </div>
    </div>
  </template>
  
<script>
  export default {
    name: "Layout",
    data() {
      return {
        // 顶部标题
        title:"用户详情",
        // 菜单
        menu: [
        {
          id: "0",
          title: "用户管理",
          path: "/userInfo",
          name: "userInfo",

        },
        {
          id: "1",
          path: "/post",
          name: "post",
          title: "动态管理",
          
        },
          {
            id: "2",
            path: "/comment",
            name: "comment",
            title: "评论管理",
          },
        {
          id: "3",
          path: "/garbage",
          name: "garbage",
          title: "歌曲管理",
        },
          {
            id: "4",
            path: "/likes",
            name: "likes",
            title: "点赞数据",
          },
        ],
      };
    },
    computed: {
      // 菜单过滤
      hasChild() {
        return this.menu.filter((item) => item.children);
      },
      noChild() {
        return this.menu.filter((item) => !item.children);
      },
    },
    methods: {
      // 侧边栏点击
      clickMenu(name,title){
        console.log(name,title)
        this.$router.push({
          name: name,
        });
        this.title=title
      },
      // 下拉菜单
      handleCommand(key){
        console.log(key)
      }
    },
  };
</script>
  
<style scoped>
.container{
  /* border: 1px solid red; */
  height: 100%;
  display: flex;
}
.container .left{
  /* border: 3px solid red; */
  width: 20%;
  height: 100%;
}
/* 侧边 */
.left h4{
  margin: 0;
  height: 8%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: rgb(60,141,188);
  color: white;
  /* border: 3px solid green; */
}
/* 右边 */
.container .right{
  width: 83%;
  height: 100%;
  /* border: 1px solid red; */
}
.right .head{
  /* border: 1px solid green; */
  width: 100%;
  height: 8%;
  display: flex;
  align-items: center;
  color: white;
  position: relative;
  justify-content: center;
  background-color: rgb(60,141,188);
}
.head .my_info{
  color: white;
  height: 100%;
  /* width: 8%; */
  display: flex;
  align-items: center;
  position: absolute;
  right: 25px;
  /* border: 1px solid green; */
}
.my_info .pic{
  /* border: 1px solid red; */
  height: 70%;
  padding: 5px;
  background-color: white;
  border-radius: 50%;
}
.pic img{
  width: 100%;
  height: 100%;
  border-radius: 50%;
}
.my_info .nickName{
  margin-left: 3px;
  color: white;
  cursor: pointer;
  outline: 0;
}
.right .body{
  /* border: 1px solid red; */
  height: 92%;
  padding: 6px;
  box-sizing: border-box;
}
</style>

  