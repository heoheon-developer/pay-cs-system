<template>
  <div class="box_date">
    <Grid style="height:100px;"
          @ready="setGrid">
    </Grid>
<!--    <TableColInput-->
<!--      :columns="gridColumns"-->
<!--      class="box_tbl_scroll"-->
<!--      captionTitle="고객상담"-->
<!--    ></TableColInput>-->
  </div>


</template>

<script>

import InquiryColumnInfo from "../pages/InquiryColumnInfo";

import TableColInput from "./grid/TableColInput";

export default {
  name: "TestGrid.vue",
  components: {TableColInput},
  data() {
    return {
      gridColumns: [
        {title: '번호'},
        {title: '고객ID'},
        {title: '제목'},
        {title: '상태'},
        {title: '등록일'}
      ],
      grid: null,
      tabIndex: 0,
    }
  },
  methods: {
    // 현재 선택한 탭에 맞는 그리드 세팅
    setGrid(grid) {
      const setGrid =
        this.tabIndex === 0 ? this.setProductGrid : this.setLotGrid;

      setGrid(grid);
    },

    // 그리드 세팅
    async setProductGrid(grid) {
      console.log("그리드 세팅", grid)

      console.log("get Columens", grid.getColumns() )
      this.grid = grid;
      // grid.setFields(InquiryColumnInfo.productFields);
      grid.setColumns(InquiryColumnInfo.productColumns);
      // grid.view.displayOptions.fitStyle = 'even';
      // const rows = await this.getProductList();
      // // grid.setRows(rows);
      // grid.setCheckBar({showAll: true});
      // grid.setFilters(['inventoryStatus', 'inventoryMgmt']);
      // grid.view.orderBy([]);
    },
    // 그리드 세팅
    async setLotGrid(grid) {
      this.grid = grid;
      grid.setFields(InquiryColumnInfo.lotFields);
      grid.setColumns(InquiryColumnInfo.lotColumns);
      grid.view.displayOptions.fitStyle = 'even';
      // const rows = await this.getLotList();
      // grid.setRows(rows);
      grid.setCheckBar({showAll: true});
      grid.setFilters(['inventoryStatus']);
      grid.view.orderBy([]);
    },
    // 상품별재고 목록 조회
    async getProductList() {
      const dto = new InventoryInquiryDTO.InventoryStatusByProductConditionQueryDTO(
        this.params,
      );
      const response = await InventoryInquiryApi.FindInventoryStatusByProductListQuery.callApi(
        dto,
      );
      const vo = new InventoryInquiryVO.InventoryStatusByProductConditionByViewVO(
        response.getContents(),
      );
      const list = vo.infoList;
      this.list.product = vo.infoList;
      this.list.tab[0].value = vo.count;
      if (this.tabIndex === 0) this.totalCount = vo.count;
      return list;
    },

  }
}
</script>

<style scoped>

</style>
