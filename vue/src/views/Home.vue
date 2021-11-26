<template>
  <div style="padding: 10px">
    <!--    功能-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <!--    搜索区域-->
    <div>
      <el-input  v-model="search" placeholder="这是搜索框" style="width: 20%"></el-input>
      <el-button type="primary" style="margin-left: 5px">搜索</el-button>

    </div>
    <!--这个是通过组件库使用的-->
    <el-table :data="tableData"
              border
              stripe
              style="width: 100%">
      <!--      prop表头-->
      <el-table-column prop="id" label="ID" sortable/>
      <el-table-column prop="username" label="Name" />
      <el-table-column prop="nickName" label="nickName" />
      <el-table-column prop="age" label="age" sortable/>
      <el-table-column prop="sex" label="sex" />
      <el-table-column prop="address" label="Address"/>
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default>
          <el-button type="text" size="small" @click="handleEdit">编辑</el-button>
          <el-popconfirm title="确认删除么?">
            <template #reference>
              <el-button type="text" size="small">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!--    分页-->
    <div style="margin:10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          v-model:currentPage="currentPage"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
      >
      </el-pagination>
<!--      弹出框-->
      <el-dialog v-model="dialogVisible" title="提示" width="30%">
        <el-form :model="form" label-width="120px">
          <el-form-item label="用户名">
            <el-input v-model="form.username" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="form.nickname" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="form.age" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio v-model="form.sex" label="女">女</el-radio>
            <el-radio v-model="form.sex" label="男">男</el-radio>
          </el-form-item>
          <el-form-item label="地址">
            <el-input type="textarea" v-model="form.address" style="width: 80%"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">Cancel</el-button>
            <el-button type="primary" @click="save">Confirm</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: 'Home',
  components: {},
  // 变量
  data() {
    return {
      form:{},
      search:'',
      total:0,
      pageSize:10,
      currentPage:1,
      dialogVisible:false,
      tableData: [
      ],
    }
  },
  created() {
    // 在页面加载的时候调用load方法
    this.load();
  },
  methods:{
    load(){
      // 加载传过来的数据
      request.get("/api/user",{
        pageNum:this.currentPage,
        pageSize:this.pageSize,
        search:this.search
      }).then(res => {
        console.log(res)
        // 赋值，把res中的数据赋值给totalData
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    save(){
      // form对象 传给后台
      // 这个request是通过js封装的
      // form这个参数传过去，然后返回结果
      request.post("/api/user",this.form).then(res => {
        console.log(res)
      })
    },
    add(){
      this.dialogVisible = true
      this.form={}
    },
    handleEdit(){

    },
    handleSizeChange(){

    },
    handleCurrentChange(){

    },
  }

}
</script>
