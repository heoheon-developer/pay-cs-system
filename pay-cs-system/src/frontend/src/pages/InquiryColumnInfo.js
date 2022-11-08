const productFields = [
    {
        "fieldName": "id",
        "dataType": "number"
    },
    {
    "fieldName": "customerId",
    "dataType": "number"
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
      name: 'id',
      fieldName: 'id',
      type: 'data',
      width: '120',
      header: {
        text: '번호',
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
      name: 'customerId',
      fieldName: 'customerId',
      type: 'data',
      width: '120',
      header: {
        text: '고객ID',
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
      name: 'title',
      fieldName: 'title',
      type: 'data',
      width: '120',
      header: {
        text: '제목',
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
      name: 'status',
      fieldName: 'status',
      type: 'data',
      width: '120',
      header: {
        text: '상태',
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
      name: 'regDate',
      fieldName: 'regDate',
      type: 'data',
      width: '120',
      header: {
        text: '등록일',
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

const lotColumns = [];


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
