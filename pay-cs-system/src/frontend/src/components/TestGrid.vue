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

import apiInquiry from '../api/api.js'
import {GridView, LocalDataProvider} from "realgrid";

export default {
  name: "TestGrid.vue",
  components: {TableColInput},
  data() {
    return {
      gridColumns: [],
      grid: null,
      tabIndex: 0,
      items:[],
      provider:null,
    }
  },
  mounted() {

    const provider = new LocalDataProvider(false);
    this.provider = provider;
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


      this.grid = grid;

      const fields = InquiryColumnInfo.productFields;
      const columns = InquiryColumnInfo.productColumns;

      grid.provider.setFields(fields)
      grid.view.setColumns(columns)
      grid.view.displayOptions.fitStyle = 'even';
      const res = await apiInquiry.getInquiries();

      console.log("red", res)

      grid.provider.setRows(res.data);
      grid.setCheckBar({showAll: true});
      // grid.setFilters(['inventoryStatus', 'inventoryMgmt']);
      grid.view.orderBy([]);
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


  }
}
</script>

<style scoped>

</style>
