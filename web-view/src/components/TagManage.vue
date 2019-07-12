<template>
  <div>
    <Row>
      <div class="wrapper-md text-s">
        <div class="panel panel-default form-horizontal form" role="form">
          <div class="panel-heading">
            <Alert type="success">
              标签管理
            </Alert>
          </div>
          <Row style="height: 50px">
            <div>
              <Form ref="searchData" :model="searchData" :label-width="60" inline>
                <FormItem label="标签key" prop="key">
                  <Input type="text"  v-model="searchData.key" placeholder='请输入标签key'>
                  </Input>
                </FormItem>

              </Form>
            </div>
          </Row>
          <Row justify="space-between" class="control" style="color: gainsboro;margin-bottom: 10px">
            <div class="table-style">
              <Button  style="background-color:#57A3F3;color: floralwhite">
                <Icon type="refresh"><i class="fa fa-trash"></i></Icon>
                刷新
              </Button>
            </div>
          </Row>
          <!--datatable-->
          <div>
            <Row>
              <Col>
                <Table border :columns="tableColumns" :data="tableData"></Table>
              </Col>
            </Row>
            <Row style="margin-top: 5px">
              <Col>
                <div style="float: right;" >
                  <Page :total="total"
                        @on-page-size-change="pageSizeChange"
                        @on-change="changePage"
                        :current="page.page"
                        :pageSize="page.size" size="small"
                        placement="top" show-elevator show-sizer ></Page>
                </div>
              </Col>
            </Row>
            <br>
          </div>
        </div>
      </div>
    </Row>

  </div>
</template>
<script>
  export default {
    data () {
      return {
        searchUrl: '/chansey/tag',
        total: 0,
        page: {
          size: 10,
          page: 1
        },
        tableColumns: [
          {
            title: '标签key',
            key: 'key'

          },
          {
            title: '标签key',
            key: 'name'
          },
          {
            title: '标签类型',
            key: 'type'
          }
        ],
        tableData: [],
        searchData: {
          key: null
        },
        formData: {
          id: null,
          code: '',
          name: '',
          remark: ''
        }
      };
    },
    created () {
      this.search();
    },
    methods: {
      search: function () {
        let page = this.page;
        let pp = parseInt(page.page) - 1;
        let searchApi = this.searchUrl + '?page=' + pp + '&size=' + page.size;
        console.log(this.searchData);
        if (this.searchData.code != null) {
          searchApi += '&code=' + this.searchData.code;
        }
        if (this.searchData.name != null) {
          searchApi += '&name=' + this.searchData.name;
        }
        console.log(searchApi);
        console.log(this.$axios)
        console.log(this.$http)
        // this.$http.get(searchApi).then(
        //   (res) => {
        //     console.log(res);
        //     if (res.body.success) {
        //       this.tableData = res.body.body.content;
        //       this.total = res.body.body.totalElements;
        //     }
        //   }
        // );
      },
      resetsearch: function () {
        this.$refs['searchData'].resetFields();
        this.search();
      },
      pageSizeChange: function (pageSize) {
        this.page.size = pageSize;
      },
      // 改变页数
      changePage: function (page) {
        this.page.page = page;
        this.search();
      }
    }
  };
</script>

