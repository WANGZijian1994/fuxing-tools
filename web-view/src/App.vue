<!--<template>-->
<!--  <div id="app">-->
<!--    <router-view/>-->
<!--  </div>-->
<!--</template>-->
<template>
  <div class="layout">
    <Header :style="{padding: 0}" class="layout-header-bar">
      <img src="./assets/img/logo.png">
    </Header>
    <Layout>
      <Sider ref="side1" hide-trigger collapsible :collapsed-width="78" v-model="isCollapsed">
        <Menu theme="light" :active-name="$route.name" width="auto" @on-select="menuClick">
          <MenuItem name="TagManage">
            <Icon type="ios-paper" />
            标签列表
          </MenuItem>
          <MenuItem name="FileGenerate">
            <Icon type="ios-stats" />
            文件生成
          </MenuItem>
          <MenuItem name="FileList">
            <Icon type="ios-stats" />
            文件列表
          </MenuItem>
        </Menu>
      </Sider>
      <Content>
        <router-view></router-view>
      </Content>
    </Layout>
  </div>
</template>
<script>
  export default {
    data () {
      return {
        isCollapsed: false
      }
    },
    methods: {
      menuClick (name) {
        this.$router.push(name)
      }
    }
  }
</script>

<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f5f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }

  .layout-header-bar{
    background: #ffffff;
    box-shadow: 0 1px 1px rgba(0,0,0,.1);
  }

  .ivu-menu-item:not(.ivu-menu-item-active) {
    color: #ffffff;
    background: #2d8cf0;
  }

  .ivu-menu-light.ivu-menu-vertical .ivu-menu-item-active:not(.ivu-menu-submenu){
    color: #ffffff;
    background: #007BBE;
  }
  .menu-item span{
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }

  .menu-item i{
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
  }
  .collapsed-menu span{
    width: 0px;
    transition: width .2s ease;
  }
  .collapsed-menu i{
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
  }
</style>
