<template>
<Grid style="height:500px;"
      @ready="setGrid">
</Grid>
</template>

<script>

import InquiryColumnInfo from "../pages/InquiryColumnInfo";

export default {
  name: "TestGrid.vue",
  data() {
    return {}
  },
  methods:{
    // 현재 선택한 탭에 맞는 그리드 세팅
    setGrid(grid) {
      const setGrid =
        this.tabIndex === 0 ? this.setProductGrid : this.setLotGrid;
      setGrid(grid);
    },
    // 상품별재고 그리드 세팅
    async setProductGrid(grid) {
      this.grid = grid;
      grid.setFields(InquiryColumnInfo.productFields);
      grid.setColumns(InquiryColumnInfo.productColumns);
      grid.view.displayOptions.fitStyle = 'even';
      // const rows = await this.getProductList();
      // grid.setRows(rows);
      grid.setCheckBar({ showAll: true });
      grid.setFilters(['inventoryStatus', 'inventoryMgmt']);
      grid.view.orderBy([]);
    },
    // 로트별재고 그리드 세팅
    async setLotGrid(grid) {
      this.grid = grid;
      grid.setFields(InquiryColumnInfo.lotFields);
      grid.setColumns(InquiryColumnInfo.lotColumns);
      grid.view.displayOptions.fitStyle = 'even';
      // const rows = await this.getLotList();
      // grid.setRows(rows);
      grid.setCheckBar({ showAll: true });
      grid.setFilters(['inventoryStatus']);
      grid.view.orderBy([]);
    },

  }
}
</script>

<style scoped>

</style>
