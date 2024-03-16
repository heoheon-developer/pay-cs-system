const productFields = [
  {
    "fieldName": "customerId",
    "dataType": "text"
  },
  {
    "fieldName": "title",
    "dataType": "text"
  },
  {
    "fieldName": "status",
    "dataType": "text"
  },
  {
    "fieldName": "regDate",
    "dataType": "text"
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
    name: 'customerId',
    fieldName: 'customerId',
    type: 'text',
    width: '120',
    header: {
      text: '고객ID',
    }
  },
  {
    name: 'title',
    fieldName: 'title',
    type: 'text',
    width: '120',
    header: {
      text: '제목',
    },
  },
  {
    name: 'status',
    fieldName: 'status',
    type: 'text',
    width: '120',
    header: {
      text: '상태',
    },
  },
  {
    name: 'regDate',
    fieldName: 'regDate',
    type: 'text',
    width: '120',
    header: {
      text: '등록일',
    },
  },
];


export default {
  productFields,
  productColumns
}
