<template>
	<div class="box_tbl">
		<table :class="['tbl_comm' ,  {tbl_comm1 : ExchangeRefuse}]">
			<caption class="ir_caption">{{ captionTitle }}</caption>
			<colgroup v-if=outboundManage>
			<col style="width:48px"/>
			<col style="width:77px"/>
			<col style="width:110px"/>
			<col style="width:130px"/>
			<col style="width:90px"/>
			<col style="width:90px"/>
			<col style="width:156px"/>
			<col style="width:122px"/>
			<col style="width:78px"/>
			<col style="width:136px"/>
			</colgroup>
			<colgroup v-else-if="warehouseServiceCharge">
			<col style="width:48px"/>
			<col style="width:96px"/>
			<col style="width:80px"/>
			<col style="width:108px"/>
			<col style="width:108px"/>
			<col style="width:108px"/>
			<col style="width:100px"/>
			<col style="width:100px"/>
			<col style="width:100px"/>
			<col style="width:108px"/>
			<col style="width:131px"/>
			</colgroup>
			<colgroup v-else-if="productSearch">
			<col style="width:48px"/>
			<col style="width:170px"/>
			<col style="width:240px"/>
			<col style="width:260px"/>
			<col style=""/>
			</colgroup>
			<colgroup v-else-if="settingPull">
			<col style="width:48px"/>
			<col style="width:304px"/>
			<col/>
			<col style="width:88px"/>
			</colgroup>
			<colgroup v-else-if="searchResult">
				<col style="width:82px"/>
				<col style="width:300px"/>
				<col style="width:180px"/>
				<col />
				<col style="width:180px"/>
			</colgroup>
			<colgroup v-else-if="comparativeGroupOrder">
				<col style="width:48px"/>
				<col/>
				<col style="width:180px"/>
				<col style="width:120px"/>
				<col style="width:160px"/>
				<col style="width:252px"/>
			</colgroup>
			<colgroup v-else-if="comparativeGroupSale">
				<col style="width:48px"/>
				<col style="width:240px"/>
				<col/>
				<col style="width:160px"/>
				<col style="width:176px"/>
			</colgroup>
			<colgroup v-else>
				<col style="width:48px"/>
				<col style=""/>
			</colgroup>
			<thead>
				<tr>
					<th v-if="searchResult" scope="col">
						<span class="txt_th">분석하기</span>
					</th>
					<th v-else scope="col">
						<inputCheckBox
						checkboxId="tblTh"
						disabled
						></inputCheckBox>
					</th>
					<th scope="col" v-for="( item, idx ) in columns" :key = 'idx'>
						<span class="txt_th">{{ item.title }}</span>
						<button v-if="item.sort"
						:class="['btn_sort' , { sort_selectd : sortKey === item && isSortActive }]"
						@click="sortEvent(item)"
						><span class="ico_wsf ico_arrow3">정렬</span></button><!-- sort : 정렬, sort1 : filter -->
						<button v-else-if="item.sort1"
						:class="['btn_sort' , { sort_selectd : sortKey === item && isSortActive }]"
						@click="sortEvent(item)"
						><span class="ico_wsf ico_arrow4">정렬</span></button>
						<TableLayoutSort v-if="sortKey === item " v-show="isSortActive"/>
					</th>
					<th v-if="ExchangeRefuse">거부사유</th>
					<th v-if="settingPull"><span class="txt_th">편집</span></th>
				</tr>
			</thead>
			<tbody>
				<template v-for = "(idx , index) in 20">
					<tr v-for="(entry) in rows" :class="[{error : (idx === 3 && !searchResult)}, {checked : (idx === 4 && !searchResult)}]" :key="entry+index">
						<th v-if="searchResult">
							<ButtonIcon icoStyle="arrow17" @click="$emit('detailAnalysis', idx)">분석하기</ButtonIcon>
						</th>
						<th v-else>
							<inputCheckBox :checkboxId= "`inp${idx}`+`${chkType}`"></inputCheckBox>
						</th>
						<td v-for="(item,idx) in columns"
						:class="[
						{ align_left : searchResult && item.title === '출고상품명'},
						{ align_left : searchResult && item.title === '출고상품코드'},
						{ error : idx === 3 && item.title === '쇼핑몰 주문번호'},
						{ error : idx === 3 && item.title === '대표상품명'},
						{ group_tooltip : idx === 3 && item.title === '쇼핑몰 주문번호'},
						{ group_tooltip : idx === 3 && item.title === '대표상품명'},
						{ group_tooltip : outboundManage && item.title==='사용' },
						{ group_tooltip : productInquiry && item.title==='상태' },
						]"
						:key="item.id"
						>
							<!--  에디터 모드일때   contenteditable = "true" 적용-->
							<span v-if=" item.title === '주문시간' " class="num_date">{{  entry [item.title] }}</span>
							<template v-else-if=" item.title === '주문내역' || item.title === '쇼핑몰 주문번호' || item.title === '입고예정번호'">
							<button class="link_tbl" @click ="showPanel">{{  entry [item.title] }} </button>
							<p class="desc_tooltip" v-if =" idx === 3 && item.title === '쇼핑몰 주문번호' ">에러내용이 툴팁으로 나오게 됩니다.</p>
							</template>
							<template v-else-if=" item .title === '진행상태'">
							<button class="pgr_connect" @click=ReleaseProductCode v-if="idx === 1">
							<span class="ico_wsf ico_cllip"></span>
							<span class="txt_clip">출고상품연결</span>
							</button>
							<span class="pgr_warn" v-else-if="idx === 2">
							<span class="ico_wsf ico_warn"></span>
							<span class="txt_warn">이상상황</span>
							</span>
							<span class="pgr_comm pgr_delivry" v-else-if="idx === 3">
							<span class="txt_pgr">출고요청</span>
							</span>
							<span class="pgr_comm pgr_delivry" v-else-if="idx === 4">
							<span class="txt_pgr">취소주문</span>
							</span>
							<span class="pgr_comm pgr_release" v-else-if="idx === 5">
							<span class="txt_pgr">선출고</span>
							</span>
							<span class="pgr_comm pgr_state" v-else-if="idx === 6">
							<span class="txt_pgr">취소</span>
							</span>
							<button class="pgr_connect" @click=RetrunInfoInput  v-else-if="idx === 7">
							<span class="ico_wsf ico_editor1"></span>
							<span class="txt_clip">회수정보입력</span>
							</button>
							<span class="pgr_comm pgr_delivry" v-else-if='idx === 8'>
							<span class="txt_pgr">판매중</span> <!-- 재고인사이트 :  판매중  -->
							</span>
							<span class="pgr_comm pgr_wait" v-else-if='idx === 9'>
							<span class="txt_pgr">결품처리대기</span>
							</span>
							<span class="pgr_comm pgr_part_cancle" v-else-if='idx === 10'>
							<span class="txt_pgr">부분취소</span>
							</span>
							<span class="pgr_comm pgr_order_accept" v-else-if='idx === 11'>
							<span class="txt_pgr">주문접수</span>
							</span>
							<span class="pgr_comm pgr_allocation" v-else-if='idx === 12'>
							<span class="txt_pgr">할당</span>
							</span>
							<span class="pgr_comm pgr_delivry_accept" v-else-if="idx === 13">
							<span class="txt_pgr">출고접수</span>
							</span>
							<span class="pgr_comm pgr_expect" v-else-if="idx === 14">
							<span class="txt_pgr">출고접수취소</span>
							</span>
							<span class="pgr_comm pgr_delivry_work" v-else-if="idx === 15">
							<span class="txt_pgr">출고작업</span>
							</span>
							<span class="pgr_comm pgr_delivry_end" v-else-if="idx === 16">
							<span class="txt_pgr">출고완료</span>
							</span>
							<span class="pgr_comm pgr_delivry_delivery" v-else-if="idx === 17">
							<span class="txt_pgr">배송준비지연</span>
							</span>
							<span class="pgr_comm pgr_seller_cancle" v-else-if="idx === 18">
							<span class="txt_pgr">판매자취소</span>
							</span>
							<span class="pgr_comm pgr_order_cancle" v-else-if="idx === 19">
							<span class="txt_pgr">취소주문승인</span>
							</span>
							<span class="pgr_comm pgr_abnormal_confirm" v-else>
							<span class="txt_pgr">이상확인완료</span>
							</span>
							</template>
							<template v-else-if=" item.title === '판매상태' ">
							<span class="pgr_comm pgr_delivry" v-if="idx === 1">
							<span class="txt_pgr">판매중</span>
							</span>
							<span class="pgr_comm pgr_stop" v-else-if="idx === 2">
							<span class="txt_pgr">판매중지</span>
							</span>
							<span class="pgr_comm pgr_expect" v-else-if="idx === 3">
							<span class="txt_pgr">품절예상</span>
							</span>
							<span class="pgr_comm pgr_delivry" v-else>
							<span class="txt_pgr">판매중</span>
							</span>
							</template>
							<span v-else-if=" item.title === '쇼핑몰' || item.title === '쇼핑ID' || item.title === '묶음배송번호' || item.title === '상품종류' " class="txt_tbl">{{  entry [item.title] }}</span>
							<span v-else-if="item.title === '증감률'  &&  idx === 3" class="rate_data data_top"> <!-- 증감률 증가 수치 -->
							<span class="ico_arrow5">상승</span><span class="num_data1">3%</span>
							</span>
							<span v-else-if="item.title === '증감률'  " class="rate_data data_down"> <!-- 증감률 하락 수치 -->
							<span class="ico_arrow5">하락</span><span class="num_data1">3%</span>
							</span>
							<template v-else-if="outboundManage && item.title==='사용' ">
							<button class="pgr_comm pgr_comm1 pgr_delivry" @click="showTooltip(idx)"><span class="txt_pgr">판매중</span></button>
							<p class="desc_tooltip" v-show="isTooltipIndex === idx" >판매중</p>
							</template>
							<template v-else-if="productInquiry && item.title==='상태' ">
							<button class="pgr_comm pgr_comm1 pgr_delivry" @click="showTooltip(idx)"><span class="txt_pgr">판매중</span></button>
							<p class="desc_tooltip" v-show="isTooltipIndex === idx" >판매중</p>
							<button class="pgr_comm pgr_comm1 pgr_stop" @click="showTooltip(idx)"><span class="txt_pgr">판매중지</span></button>
							<p class="desc_tooltip" v-show="isTooltipIndex === idx" >판매중지</p>
							<button class="pgr_comm pgr_comm1 pgr_complete" @click="showTooltip(idx)"><span class="txt_pgr">판매완료</span></button>
							<p class="desc_tooltip" v-show="isTooltipIndex === idx" >판매완료</p>
							</template>
							<button v-else-if="outboundManage && item.title ==='출고상품명'" class="link_tbl" @click="showStockDetail" >{{  entry [item.title] }}</button>
							<button v-else-if="inventoryMove && item.title ==='이동 요청번호'" class="link_tbl" @click="$emit('showPanel')" >{{  entry [item.title] }}</button>
							<button v-else-if="productInquiry && item.title ==='판매상품명'" class="link_tbl" @click="showProductDetail" >{{  entry [item.title] }}</button>
							<template v-else-if="warehouseServiceCharge && item.title === '상태' ">
							<span v-if="entry [item.title] === '확정' " class="chip_comm chip_primary">확정</span>
							<span v-else-if="entry [item.title] === '예정' " class="chip_comm chip_basic">예정</span>
							<span v-else-if="entry [item.title] === '완료' " class="chip_comm chip_gray">완료</span>
							</template>
							<template v-else-if="warehouseServiceCharge && item.title === '총 이용금액' ">
							<button class="link_tbl">{{  entry [item.title] }}</button>
							</template>
							<template v-else-if="warehouseServiceCharge && item.title === '세금계산서' ">
							<button v-if="entry [item.title] === '발행요청' " class="pgr_connect"><span class="ico_wsf ico_file1"></span><span class="txt_clip">{{  entry [item.title] }}</span></button>
							<span v-else-if="entry [item.title] === '발행 중' " class="pgr_comm pgr_release"><span class="txt_pgr">{{  entry [item.title] }}</span></span>
							<span v-else-if="entry [item.title] === '발행 전' " class="pgr_comm pgr_wait"><span class="txt_pgr">{{  entry [item.title] }}</span></span>
							<span v-else-if="entry [item.title] === '발행 완료' " class="pgr_comm pgr_state"><span class="txt_pgr">{{  entry [item.title] }}</span></span>
							</template>
							<span class="txt_tbl" v-else v-html="entry [item.title]"></span>
						</td>
						<td v-if="ExchangeRefuse" class="pd_none">
							<TextArea></TextArea>
						</td>
						<td v-if="settingPull" class="pd_none">
							<ButtonIcon icoStyle="delete2" class="btn_icon">삭제</ButtonIcon>
						</td>
					</tr>
				</template>
			</tbody>
		</table>
	</div>
</template>

<script>

export default {
	name : 'TableColInput',
  data(){
    return{
      sortKey : '',
      isSortActive : false,
      isTooltip : false,
      isTooltipIndex : null,
      rateData : `<strong>상룰</strong>`,
    }
  },
	props : {
		columns: Array,
		rows : Array,
		captionTitle : {
			type:String
		},
		ExchangeRefuse: {
			type:Boolean
		},
		outboundManage : {
			type:Boolean
		},
		inventoryMove : {
			type:Boolean
		},
		chkType : {
			type:String,
			default:''
		},
		warehouseServiceCharge:{
			type:Boolean
		},
		productInquiry: {
			type:Boolean
		},
		// 판매상품 > 판매상품 개별등록 옵션
		productSearch: {
			type: Boolean
		},
		settingPull : {
			type:Boolean
		},
		searchResult : {
			type : Boolean
		},
		// 인사이트 주문분석 비교그룹 추가
		comparativeGroupOrder : {
			type : Boolean
		},
		// 인사이트 출고량분석 비교그룹 추가
		comparativeGroupSale : {
			type : Boolean
		}
	},
  methods : {}
}
</script>

<!--<style lang="scss" scoped>-->
<!--@import '../../table/table';-->
<!--</style>-->
