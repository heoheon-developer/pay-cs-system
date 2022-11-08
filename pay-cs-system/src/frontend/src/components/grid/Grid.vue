<template>
  <div />
</template>

<script>

import {GridView, LocalDataProvider} from 'realgrid';

// 로그 표시 여부
const enableLogging = true;

export default {
  name: "Grid",
  data(){
    return{

      currentPage: 1,
    }
  },
  mounted() {
    console.log("그리드 마운티드")
    const provider = new LocalDataProvider(false);
    console.log("provider", provider)
    const view = new GridView(this.$el);

    console.log("view", view)
    view.setDataSource(provider);
    this.provider = provider;
    this.view = view;
    this._setDefaultOptions(provider, view);
    this._registerEvents(provider, view);


  },
  methods:{
    setOptions(options) {
      console.warn("options",options , "defaultOptions" , defaultOptions);
      const defaultOptions = {
        display: true,
        footers: {
          visible: false,
        }, //그리드 푸터
        header: true, //그리드 헤더
        rowIndicator: {
          visible: false,
        }, //줄 번호
        stateBar: {
          visible: false,
        }, //상태바
        paste: false, // 붙여넣기 허용 여부
      };
      // options['display'] = options['display']
      //   ? options['display']
      //   : defaultOptions['display'];
      // options['footers'] = options['footers']
      //   ? options['footers']
      //   : defaultOptions['footers'];
      // options['header'] = options['header']
      //   ? options['header']
      //   : defaultOptions['header'];
      // options['rowIndicator'] = options['rowIndicator']
      //   ? options['rowIndicator']
      //   : defaultOptions['rowIndicator'];
      // options['stateBar'] = options['stateBar']
      //   ? options['stateBar']
      //   : defaultOptions['stateBar'];
      // options['paste'] = options['paste']
      //   ? options['paste']
      //   : defaultOptions['paste'];
      // this._log('options', options, 'defaultOptions', defaultOptions);
      // this.view.setOptions(options);
    },
    // 그리드 디스플레이 옵션
    setDisplayOptions(displayOptions) {
      const defaultDisplayOptions = {
        minRowHeight: 47, //row height
        minTableRowHeight: 47,
        hscrollBar: true, //세로 스크롤바
        wscrollBar: true, //세로 스크롤바
        showEmptyMessage: true, //no data message 구분
        emptyMessage: '조회된 데이터가 없습니다.', //no data message
        fitStyle: 'evenFill', // 그리드의 너비에 채워서 맞추는
        SelectionStyle: 'rows', //
      };
      displayOptions['minRowHeight'] = displayOptions['minRowHeight']
        ? displayOptions['minRowHeight']
        : defaultDisplayOptions['minRowHeight'];
      displayOptions['minTableRowHeight'] = displayOptions['minTableRowHeight']
        ? displayOptions['minTableRowHeight']
        : defaultDisplayOptions['minTableRowHeight'];
      displayOptions['hscrollBar'] = displayOptions['hscrollBar']
        ? displayOptions['hscrollBar']
        : defaultDisplayOptions['hscrollBar'];
      displayOptions['wscrollBar'] = displayOptions['wscrollBar']
        ? displayOptions['wscrollBar']
        : defaultDisplayOptions['wscrollBar'];
      displayOptions['showEmptyMessage'] = displayOptions['showEmptyMessage']
        ? displayOptions['showEmptyMessage']
        : defaultDisplayOptions['showEmptyMessage'];
      displayOptions['emptyMessage'] = displayOptions['emptyMessage']
        ? displayOptions['emptyMessage']
        : defaultDisplayOptions['emptyMessage'];
      displayOptions['fitStyle'] = displayOptions['fitStyle']
        ? displayOptions['fitStyle']
        : defaultDisplayOptions['fitStyle'];
      displayOptions['SelectionStyle'] = displayOptions['SelectionStyle']
        ? displayOptions['SelectionStyle']
        : defaultDisplayOptions['SelectionStyle'];
      this.view.setDisplayOptions(displayOptions);
    },
    // default 컬럼 정보
    getColumns(columns = []) {
      const defaultColumnOption = {
        type: 'data', //column type
        width: '170', //column width
        styles: {
          //column custom styles
          textAlignment: 'center',
        },
        editable: false, //column cell editable options
        sortable: true, //column cell sortable options
        autoFilter: true, //column cell flitrable options
        renderer: {
          type: 'text',
          showTooltip: true,
        },
      };

      columns.forEach((column, index) => {
        column['header'] = column['header']
          ? column['header']
          : defaultColumnOption['header'];
        column['styles'] = column['styles']
          ? column['styles']
          : defaultColumnOption['styles'];
        column['renderer'] = column['renderer']
          ? column['renderer']
          : defaultColumnOption['renderer'];
        column['editable'] = column['editable']
          ? column['editable']
          : defaultColumnOption['editable'];
        column['width'] = column['width']
          ? column['width']
          : defaultColumnOption['width'];
        column['type'] = column['type']
          ? column['type']
          : defaultColumnOption['type'];
        column['autoFilter'] =
          column['autoFilter'] === false
            ? column['autoFilter']
            : defaultColumnOption['autoFilter'];
        this[index] = column;
      }, columns);

      return columns;
    },
    setCheckBar(checkBar = {}) {
      const defaultCheckBar = {
        showAll: false, //header checkbox
        width: 48, //checkbox area width
      };
      const customCheckBar = {
        ...defaultCheckBar,
        ...checkBar,
      };
      this.view.setCheckBar(customCheckBar);
    },
    // 디버깅용 로그 출력
    _log(...args) {
      if (enableLogging) {
        console.warn(...args);
      }
    },
    _setDefaultOptions(provider, view) {
      this.setOptions({});
      this.setDisplayOptions({});
      this.setCheckBar(); //checkBar property
      //
      // //setRowStyleCallback 개행의 상태에 따라 rowStyle을 변경
      // const setDefaultRowStyle = (grid, item) => {
      //   const errorFieldIdx = this.provider.getFieldIndex('error');
      //   /*
      //   console.log('Gird.vue errorFieldIdx : ' + errorFieldIdx);
      //   if (errorFieldIdx > -1) {
      //     console.log(
      //       'this.getValue error : ' + this.getValue(item.dataRow, 'error'),
      //     );
      //   }
      //   */
      //
      //   if (this.view.getCheckedRows().indexOf(item.dataRow) > -1) {
      //     return 'rg-checked-row';
      //   } else if (
      //     errorFieldIdx > -1 &&
      //     this.getValue(item.dataRow, 'error') === 'error'
      //   ) {
      //     return 'rg-error-row';
      //   } else {
      //     return 'rg-default-row';
      //   }
      // };
      // view.setRowStyleCallback(setDefaultRowStyle);
      // view.filteringOptions.automating.lookupDisplay = true;
    },
    /**
     * 그리드 컴포넌트 이벤트 등록: 지원하는 이벤트 목록은 아래와 같음
     * ready(gridComponent) - 그리드 컴포넌트가 로드 되었을 때
     * clickHeader(grid, data) - 헤더를 클릭했을 때
     * clickData(grid, data) - 데이터를 클릭했을 때
     * clickFooter(grid, data) - 데이터를 클릭했을 때
     * clickItem(grid, index, data) - 셀 안에 버튼 등의 요소를 개별 클릭했을 때
     * check(grid, itemIndex, checked) - 체크박스 체크했을 때
     * checkAll(grid, checked) - 헤더영역 전체선택/해제 체크했을 때
     * validate(grid, column, inserting, value) - 그리드 검증함수 호출했을 때
     */
    _registerEvents(provider, view) {
      // view.onCellClicked = (grid, data) => {
      //   const cellType = data.cellType;
      //   if (cellType === 'header') {
      //     this.$emit('clickHeader', grid, data);
      //   } else if (cellType === 'data') {
      //     this.$emit('clickData', grid, data);
      //   } else if (cellType === 'footer') {
      //     this.$emit('clickFooter', grid, data);
      //   }
      //   // 그외 cellType에 대한 클릭 이벤트가 필요한 경우 아래 링크 참조
      //   // https://docs.realgrid.com/refs/grid-cell-type
      // };
      // view.onCellItemClicked = (grid, index, data) => {
      //   this.$emit('clickItem', grid, index, {
      //     ...data,
      //     name: data.target.dataset.name,
      //   });
      //   return true;
      // };
      // view.onItemChecked = (grid, itemIndex, checked) => {
      //   //console.log("grid.getCurrent()" , grid.getCurrent());
      //   this._log('this.view.getCheckedRows()', this.view.getCheckedRows());
      //   this.$emit('check', grid, itemIndex, checked);
      // };
      // view.onItemAllChecked = (grid, checked) => {
      //   this.isAllChecked = checked
      //   this.$emit('checkAll', grid, checked);
      // };
      // view.onKeyPress = (grid, event) => {
      //   this.$emit('keyPress', grid, event);
      // };
      // view.onKeyDown = (grid, event) => {
      //   this.$emit('keyDown', grid, event);
      // };
      // view.onKeyUp = (grid, event) => {
      //   this.$emit('keyUp', grid, event);
      // };
      // view.onContextMenuItemClicked = (grid, data, index) => {
      //   this.$emit('contextMenuItemClicked', grid, data, index);
      // };
      // view.onContextMenuPopup = (grid, x, y, elementName) => {
      //   this.$emit('contextMenuPopup', grid, x, y, elementName);
      // };
      // view.onColumnPropertyChanged = (grid, column, property, value) => {
      //   this.$emit('columnPropertyChanged', grid, column, property, value);
      // };
      this.$emit('ready', this);
    },
    // 컬럼 정보 설정
    setColumns(columns) {
      this.view.setColumns(columns);
    },
  }
}
</script>

