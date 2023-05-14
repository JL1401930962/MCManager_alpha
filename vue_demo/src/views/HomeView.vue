<template>
    <div class="container">
        <div class="header">
            <div class="title">管理系统</div>
        </div>
        <div class="body">
            <div class="one">
                <el-button type="primary" @click="add()">新增</el-button>
                <!-- <el-button type="primary" @click="save()">导入</el-button> -->
                <el-button type="primary" @click="test()">测试一</el-button>
                <el-button type="primary" @click="test2()">测试二</el-button>
                <el-button type="primary" @click="deleteU()">删除</el-button>
                <el-button type="primary" @click="updateU()">修改</el-button>

                <el-input v-model="input" class="w-50 m-2" placeholder="Please Input" style="width: 30%;"/>
                <el-button type="primary">查询</el-button>
            </div>
            <div class="two">
                <el-table :data="tableData" style="width: 100%">
                    <el-table-column label="ID" prop="id"/>
                    <el-table-column label="用户ID" prop="userid"/>
                    <el-table-column label="密码" prop="password"/>
                    <el-table-column label="用户名" prop="username"/>
                    <el-table-column label="个性签名" prop="signature"/>
                    <el-table-column label="年龄" prop="age"/>
                    <el-table-column label="性别" prop="sex"/>

                    <el-table-column label="Options" prop="option">
                        <template #default="scope">
                            <el-button size="small" @click="handleEdit(scope.row)"
                            >Edit
                            </el-button
                            >
                            <el-button
                                    size="small"
                                    type="danger"
                                    @click="handleDelete(scope.$index, scope.row)"
                            >Delete
                            </el-button
                            >
                        </template>
                    </el-table-column>
                </el-table>
            </div>
        </div>
    </div>
    <el-dialog v-model="dialogFormVisible" title="新增用户">
    <el-form :model="form">
      <el-form-item label="用户名" label-width="120px">
        <el-input v-model="form.username" /> 
      </el-form-item>
      <el-form-item label="用户ID" label-width="120px">
        <el-input v-model="form.userid" />
      </el-form-item>
      <el-form-item label="性别" label-width="120px">
        <el-input v-model="form.sex" /> 
      </el-form-item>
      <el-form-item label="年龄" label-width="120px">
        <el-input v-model="form.age" /> 
      </el-form-item>
      <el-form-item label="地址" label-width="120px">
        <el-input v-model="form.signature" />
      </el-form-item>
      <el-form-item label="密码" label-width="120px">
        <el-input v-model="form.password" /> 
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="save()">
          确定
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
    export default {
        name: 'HomeView',
        created(){
            this.getAllUser();
        },
        data() {
            return {
                input: '',
                tableData: [],
                dialogFormVisible:false,
                form:{
                    userid:'12345678',
                    username:'哈哈哈方文山',
                    sex:'男男女女',
                },
            }
        },
        methods: {
            getAllUser(){
                let url="/api/user/getAllUser";
                this.$http.get(url,this.form).then((res)=>{
                    console.log(res)
                    this.tableData=res.data;
                })
            },
            handleEdit(row) {
                console.log(row);
                this.form=JSON.parse(JSON.stringify(row));
                this.dialogFormVisible=true;
            },
            handleDelete(index, row) {
                console.log(index, row)
                console.log("点击了删除");
            },
            add(){
                this.dialogFormVisible=true;
                this.form={};
            },
            save(){
                if(this.form.id){
                    let url="/updateUser";
                this.$http.post(url,this.form).then((res)=>{
                    console.log(res);
                })
                }else{
                    console.log(this.form);
                    let url="/addUser";
                    this.$http.post(url,this.form).then((res)=>{
                    console.log(res);
                    })
                }
                
            },
            test(){
                let id=2;
                let url="/getUserById?userid="+id;
                this.$http.get(url).then(res=>{
                    console.log(res);
                })
            },
            test2(){
                let url="/test"
                this.$http.post(url).then(res=>{
                    console.log(res);
                })
            },
            deleteU(){
                let id=12;
                let url="/deleteUserById?userid="+id;
                this.$http.get(url).then(res=>{
                    console.log(res);
                })
            },
            updateU(){
                let id=14;
                let username="周星星";
                let url="/update?id="+id+"&username="+username;
                this.$http.get(url).then(res=>{
                    console.log(res);
                })
            }
        },
    };
</script>

<style scoped>
    .container {
        width: 100%;
        height: 100%;
        border: 1px solid red;
    }

    .header {
        width: 100%;
        height: 8%;
        display: flex;
        align-items: center;
        justify-content: center;
        border: 1px solid red;
    }

    .body {
        border: 1px solid green;
    }

    .body .one {
        border: 1px solid green;
        display: flex;
    }
</style>