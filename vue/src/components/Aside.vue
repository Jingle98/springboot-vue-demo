<!--定义的侧边组件 -->
<template>
  <div>
    <el-menu
        default-active="user"
        default-openeds="1"
        class="el-menu-vertical-demo"
        style="width: 200px;min-height: calc(100vh - 50px)"
    >
      <el-sub-menu index="1">
        <template #title>管理系统</template>
        <el-menu-item index="user">用户信息</el-menu-item>
      </el-sub-menu>

      <el-menu-item index="dataSys">数据管理</el-menu-item>

    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>