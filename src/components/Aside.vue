<!--定义的侧边组件 -->
<template>
  <div>
    <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        style="width: 200px;min-height: calc(100vh - 50px)"
    >
      <el-sub-menu index="1">
        <template #title>选项1</template>
        <el-menu-item index="1-4-1">item one</el-menu-item>
      </el-sub-menu>

      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>Navigator Two</span>
      </el-menu-item>

      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>Navigator Four</span>
      </el-menu-item>
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