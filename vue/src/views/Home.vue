<template>
  <div style="padding: 10px">
    <!--    功能-->
    <div style="margin: 10px 0">
      <el-button type="primary">新增</el-button>
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
      <el-table-column prop="date" label="Date" sortable/>
      <el-table-column prop="name" label="Name" />
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
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  components: {},
  // 变量
  data() {
    return {
      search:'',
      total:10,
      currentPage:1,
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ],
    }
  },
  methods:{
    handleEdit(){

    },
    handleSizeChange(){

    },
    handleCurrentChange(){

    },
  }

}
</script>
