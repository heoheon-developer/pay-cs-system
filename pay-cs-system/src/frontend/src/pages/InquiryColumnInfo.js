const productFields = [
    {
        "fieldName": "inventoryStatus",
        "dataType": "text"
    },
    {
        "fieldName": "warehouseCode",
        "dataType": "text"
    },          
    {
        "fieldName": "warehouseName",
        "dataType": "text"
    },          
    {
        "fieldName": "skuCode",
        "dataType": "text"
    },          
    {
        "fieldName": "skuName",
        "dataType": "text"
    },          
    {
        "fieldName": "quantity",
        "dataType": "number"
    },
    {
        "fieldName": "safetyQuantity",
        "dataType": "number"
    },
    {
        "fieldName": "availableQuantity",
        "dataType": "number"
    },
    {
        "fieldName": "unusedQuantity",
        "dataType": "number"
    },
    {
        "fieldName": "inventoryMgmt",
        "dataType": "text"
    },
    {
        "fieldName": "currentInboundedAt",
        "dataType": "datetime",
        "datetimeFormat": "iso"
    },
    {
        "fieldName": "currentShippedAt",
        "dataType": "datetime",
        "datetimeFormat": "iso"
    },
];

const statusStyleMapping = {
    '판매중': 'pgr_delivry',
    '판매중지': 'pgr_stop',
    '품절예상': 'pgr_expect',
  };
  const statusTmpl = (status) => `<span data-v-770e7845="" class="pgr_comm ${statusStyleMapping[status]}"><span data-v-770e7845="" class="txt_pgr">${status}</span></span>`;
  const productColumns = [
    {
      name: 'inventoryStatus',
      fieldName: 'inventoryStatus',
      type: 'data',
      width: '120',
      header: {
        text: '판매상태',
      },
      editable: false,
      renderer:{
          type:"html",
          inputFocusable:true,
          callback: function(grid, cell) {
              return statusTmpl(cell.value);
          }
      }          
    },
    {
      name: 'warehouseName',
      fieldName: 'warehouseName',
      type: 'data',
      width: '120',
      header: {
        text: '물류센터',
      },
      editable: false,
    },        
    {
      name: 'skuCode',
      fieldName: 'skuCode',
      type: 'data',
      width: '140',
      header: {
        text: '출고상품코드',
      },
      editable: false,
    },        
    {
      name: 'skuName',
      fieldName: 'skuName',
      type: 'data',
      width: '250',
      header: {
        text: '출고상품명',
      },
      editable: false,
      styleName: 'rg-truncate-text',
    },        
    {
      name: 'quantity',
      fieldName: 'quantity',
      type: 'data',
      width: '90',
      header: {
        text: '총재고',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'safetyQuantity',
      fieldName: 'safetyQuantity',
      type: 'data',
      width: '90',
      header: {
        text: '안전재고',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'availableQuantity',
      fieldName: 'availableQuantity',
      type: 'data',
      width: '90',
      header: {
        text: '정상재고',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'unusedQuantity',
      fieldName: 'unusedQuantity',
      type: 'data',
      width: '90',
      header: {
        text: '불량재고',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'inventoryMgmt',
      fieldName: 'inventoryMgmt',
      type: 'data',
      width: '120',
      header: {
        text: '재고관리',
      },
      editable: false,
    },
    {
      name: 'currentInboundedAt',
      fieldName: 'currentInboundedAt',
      type: 'data',
      width: '120',
      datetimeFormat: "yyyy.MM.dd",
      header: {
        text: '최근입고일',
      },
      editable: false,
    },
    {
      name: 'currentShippedAt',
      fieldName: 'currentShippedAt',
      type: 'data',
      width: '120',
      datetimeFormat: "yyyy.MM.dd",
      header: {
        text: '최근출고일',
      },
      editable: false,
    },
  ];

  const lotFields = [
    {
        "fieldName": "inventoryStatus",
        "dataType": "text"
    },
    {
        "fieldName": "warehouseCode",
        "dataType": "text"
    },          
    {
        "fieldName": "warehouseName",
        "dataType": "text"
    },          
    {
        "fieldName": "skuCode",
        "dataType": "text"
    },          
    {
        "fieldName": "skuName",
        "dataType": "text"
    },          
    {
        "fieldName": "quantity",
        "dataType": "number"
    },
    {
        "fieldName": "safetyQuantity",
        "dataType": "number"
    },
    {
        "fieldName": "availableQuantity",
        "dataType": "number"
    },
    {
        "fieldName": "unusedQuantity",
        "dataType": "number"
    },
    {
        "fieldName": "productionDate",
        "dataType": "datetime",
        "datetimeFormat": "iso"
    },
    {
        "fieldName": "expiryDate",
        "dataType": "datetime",
        "datetimeFormat": "iso"
    },
    {
        "fieldName": "availableDaysOfDistribution",
        "dataType": "text"
    },
    {
        "fieldName": "outbAvailableDaysOfDistribution",
        "dataType": "text"
    },
    {
        "fieldName": "firstInboundedDate",
        "dataType": "datetime",
        "datetimeFormat": "iso"
    },
    {
        "fieldName": "lotNo",
        "dataType": "text"
    },
];

const lotColumns = [
    {
      name: 'warehouseName',
      fieldName: 'warehouseName',
      type: 'data',
      width: '120',
      header: {
        text: '물류센터',
      },
      editable: false,
    },        
    {
      name: 'skuCode',
      fieldName: 'skuCode',
      type: 'data',
      width: '140',
      header: {
        text: '출고상품코드',
      },
      editable: false,
    },        
    {
      name: 'skuName',
      fieldName: 'skuName',
      type: 'data',
      width: '250',
      header: {
        text: '출고상품명',
      },
      editable: false,
      styleName: 'rg-truncate-text',
    },        
    {
      name: 'quantity',
      fieldName: 'quantity',
      type: 'data',
      width: '90',
      header: {
        text: '총재고',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'safetyQuantity',
      fieldName: 'safetyQuantity',
      type: 'data',
      width: '90',
      header: {
        text: '안전재고',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'availableQuantity',
      fieldName: 'availableQuantity',
      type: 'data',
      width: '90',
      header: {
        text: '정상재고',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'unusedQuantity',
      fieldName: 'unusedQuantity',
      type: 'data',
      width: '90',
      header: {
        text: '불량재고',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'productionDate',
      fieldName: 'productionDate',
      type: 'data',
      width: '120',
      datetimeFormat: "yyyy.MM.dd",
      header: {
        text: '제조일자',
      },
      editable: false,
    },
    {
      name: 'expiryDate',
      fieldName: 'expiryDate',
      type: 'data',
      width: '120',
      datetimeFormat: "yyyy.MM.dd",
      header: {
        text: '유통기한',
      },
      editable: false,
    },
    {
      name: 'availableDaysOfDistribution',
      fieldName: 'availableDaysOfDistribution',
      type: 'data',
      width: '120',
      header: {
        text: '유통기한잔여일수',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'outbAvailableDaysOfDistribution',
      fieldName: 'outbAvailableDaysOfDistribution',
      type: 'data',
      width: '120',
      header: {
        text: '유통가능일수',
      },
      editable: false,
      numberFormat: "#,##0",
      styleName: 'rg-custom-number',
    },
    {
      name: 'firstInboundedDate',
      fieldName: 'firstInboundedDate',
      type: 'data',
      width: '120',
      datetimeFormat: "yyyy.MM.dd",
      header: {
        text: '최초입고일',
      },
      editable: false,
    },
    {
      name: 'lotNo',
      fieldName: 'lotNo',
      type: 'data',
      width: '120',
      header: {
        text: 'Lot. No',
      },
      editable: false,
    },
  ];


  // const data = {
  //   sourceDate: 123,
  //   warehouseName : '판교물류센터',
  //   rackType: 'GROUND',
  //   cellCode : 'A-02-02',
  //   skuCode: '123234',
  //   skuName: '타미힐피거 밴드',
  //   quantity: 1297.00
  // }

  
  export default {
    productFields,
    productColumns,
    lotFields,
    lotColumns,
  }