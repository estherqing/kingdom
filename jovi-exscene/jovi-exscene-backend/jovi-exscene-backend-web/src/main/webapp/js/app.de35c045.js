(function(e){function t(t){for(var i,r,l=t[0],o=t[1],c=t[2],p=0,m=[];p<l.length;p++)r=l[p],s[r]&&m.push(s[r][0]),s[r]=0;for(i in o)Object.prototype.hasOwnProperty.call(o,i)&&(e[i]=o[i]);u&&u(t);while(m.length)m.shift()();return n.push.apply(n,c||[]),a()}function a(){for(var e,t=0;t<n.length;t++){for(var a=n[t],i=!0,l=1;l<a.length;l++){var o=a[l];0!==s[o]&&(i=!1)}i&&(n.splice(t--,1),e=r(r.s=a[0]))}return e}var i={},s={app:0},n=[];function r(t){if(i[t])return i[t].exports;var a=i[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,r),a.l=!0,a.exports}r.m=e,r.c=i,r.d=function(e,t,a){r.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},r.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},r.t=function(e,t){if(1&t&&(e=r(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(r.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var i in e)r.d(a,i,function(t){return e[t]}.bind(null,i));return a},r.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return r.d(t,"a",t),t},r.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},r.p="/";var l=window["webpackJsonp"]=window["webpackJsonp"]||[],o=l.push.bind(l);l.push=t,l=l.slice();for(var c=0;c<l.length;c++)t(l[c]);var u=o;n.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"2b93":function(e,t,a){"use strict";var i=a("ec79"),s=a.n(i);s.a},3917:function(e,t,a){},"56d7":function(e,t,a){"use strict";a.r(t);a("cadf"),a("551c"),a("097d");var i=a("2b0e"),s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"body-container"},[a("div",{staticClass:"bread-crumb"},[a("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right bread-crumb"}},[a("el-breadcrumb-item",{attrs:{to:{path:"/"}}},[a("span",{on:{click:e.goHome}},[e._v("发布管理")])]),e.isAdd?a("el-breadcrumb-item",[e._v("发布新增")]):e._e(),e.isAdd||!e.isPublishShow||e.isDetailPage?e._e():a("el-breadcrumb-item",[e._v("发布编辑")]),!e.isAdd&&e.isDetailPage?a("el-breadcrumb-item",[e._v("发布详情")]):e._e()],1)],1),e.isTableShow&&!e.isCheckPage?a("add-component",{on:{"table-event":e.tableEvent}}):e._e(),e.isTableShow?a("header-component",{attrs:{"is-checkpage":e.isCheckPage},on:{"header-event":e.headerEvent}}):e._e(),e.isTableShow?a("table-component",{attrs:{"data-list":e.dataList,"is-checkpage":e.isCheckPage},on:{"table-event":e.tableEvent}}):e._e(),e.isTableShow?a("footer-component",{attrs:{"data-total":e.dataTotal,"current-page":e.pageIndex,"page-size":e.pageSize},on:{"footer-event":e.footerEvent}}):e._e(),e.isPublishShow?a("publish-Component",{attrs:{"is-add":e.isAdd,"type-data":e.typeList,"base-data":e.baseData,"is-detailpage":e.isDetailPage,"is-checkpage":e.isCheckPage},on:{"publish-event":e.publishEvent}}):e._e()],1)},n=[],r=(a("7f7f"),function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"table"},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.dataList,border:"",height:"600"},on:{"sort-change":e.handleSortChange}},[a("el-table-column",{attrs:{prop:"classification",label:"类别","min-width":"80",sortable:"custom"}}),a("el-table-column",{attrs:{label:"发布任务ID","min-width":"100",prop:"strategyId"}}),a("el-table-column",{attrs:{label:"对象名称","min-width":"180",prop:"name"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text"},on:{click:function(a){e.goDetailPage(t.row)}}},[e._v(e._s(t.row.name))])]}}])}),a("el-table-column",{attrs:{label:"发布对象ID","min-width":"100",prop:"bizId"}}),a("el-table-column",{attrs:{prop:"status",label:"状态","min-width":"120"},scopedSlots:e._u([{key:"default",fn:function(t){return[0===t.row.status?a("span",{staticStyle:{color:"Orange"}},[e._v("待发布")]):e._e(),1===t.row.status?a("span",{staticStyle:{color:"blue"}},[e._v("发布审核")]):e._e(),2===t.row.status?a("span",{staticStyle:{color:"Orange"}},[e._v("待启动")]):e._e(),3===t.row.status?a("span",{staticStyle:{color:"black"}},[e._v("驳回")]):e._e(),4===t.row.status?a("span",{staticStyle:{color:"green"}},[e._v("灰度")]):e._e(),5===t.row.status?a("span",{staticStyle:{color:"green"}},[e._v("全量发布")]):e._e(),6===t.row.status?a("span",{staticStyle:{color:"black"}},[e._v("暂停中")]):e._e(),7===t.row.status?a("span",{staticStyle:{color:"black"}},[e._v("已失效")]):e._e()]}}])}),a("el-table-column",{attrs:{prop:"updateTime",label:"修改时间","min-width":"170",sortable:"custom"}}),a("el-table-column",{attrs:{prop:"modifyUserName",label:"修改人","min-width":"210"}}),a("el-table-column",{attrs:{label:"操作","min-width":"270"},scopedSlots:e._u([{key:"default",fn:function(t){return[0===t.row.status||3===t.row.status||4===t.row.status||5===t.row.status||6===t.row.status?a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.goEditPage(t.row)}}},[e._v("修改发布")]):e._e(),4===t.row.status||5===t.row.status||6===t.row.status?a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.updateStatus(t.row,7,"失效")}}},[e._v("失效")]):e._e(),4===t.row.status||5===t.row.status?a("el-button",{attrs:{size:"mini",type:"warning"},on:{click:function(a){e.updateStatus(t.row,6,"暂停")}}},[e._v("暂停")]):e._e(),2===t.row.status||6===t.row.status?a("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){e.updateStatus(t.row,-1,"启动")}}},[e._v("启动")]):e._e()]}}])})],1),a("el-dialog",{attrs:{title:"暂停申请",visible:e.zantingDialogVisible,width:"600px","before-close":e.zantingDialogClose,center:""},on:{"update:visible":function(t){e.zantingDialogVisible=t}}},[a("el-form",{ref:"zantingData",attrs:{model:e.zantingData,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"暂停原因",prop:"reason",rules:e.applyRules}},[a("el-input",{attrs:{autosize:{minRows:2,maxRows:3},type:"textarea",placeholder:"请填写暂停原因",maxlength:"100"},model:{value:e.zantingData.reason,callback:function(t){e.$set(e.zantingData,"reason",t)},expression:"zantingData.reason"}})],1)],1),a("div",{staticStyle:{display:"flex","justify-content":"flex-end"}},[e._v(e._s(e.zantingData.reason?e.zantingData.reason.length:0)+"/100")]),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.zantingDialogClose(!0)}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.zantingDialogClose()}}},[e._v("确 定")])],1)],1)],1)}),l=[],o={name:"table-component",props:{isCheckpage:{type:Boolean,default:!1},dataList:{type:Array,default:function(){return[]}}},data:function(){var e=function(e,t,a){/^\s+$/.test(t)?a(new Error("不能输入全空格")):a()};return{zantingDialogVisible:!1,zantingData:{},xiajiaDialogVisible:!1,xiajiaData:{},applyRules:[{required:!0,message:"内容不能为空",trigger:"blur"},{required:!0,validator:e,trigger:"blur"}]}},methods:{updateStatus:function(e,t,a){var i=this,s="是否确定".concat(a,"“").concat(e.name,"”?");this.$confirm(s,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){-1===t&&(t=0===e.type?5:1===e.type?4:void 0);var a={strategyId:e.strategyId,status:t};i.$http.post("/scene/updateStatus",a).then(function(e){e.data&&"0"==e.data.code?(i.refreshData(),i.$message({type:"success",message:"操作成功!"})):e.data.msg?i.$message.error(e.data.msg):i.$message.error("操作失败！")}).catch(function(){i.$message.error("删除失败！")})}).catch(function(){i.$message({type:"info",message:"已取消"})})},handleDelete:function(e){var t=this,a="是否确定删除“"+e.name+"”的草稿？";this.$confirm(a,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){var a={id:e.id,versionCode:e.versionCode};t.$http.post("/scene/del",a).then(function(e){e.data&&"0"==e.data.code?(t.refreshData(),t.$message({type:"success",message:"删除成功!"})):e.data.msg?t.$message.error(e.data.msg):t.$message.error("删除失败！")}).catch(function(){t.$message.error("删除失败！")})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},goDataPage:function(e){this.$emit("table-event",{type:"data-page",data:e})},goEditPage:function(e){this.$emit("table-event",{type:"edit-page",data:e})},zantingDialogClose:function(e){var t=this;"function"===typeof e?(this.zantingData={},e()):e?(this.zantingData={},this.zantingDialogVisible=!1):this.$refs["zantingData"].validate(function(e){if(!e)return t.$message.warning("请按要求填写"),!1;var a={id:t.zantingData.id,versionCode:t.zantingData.versionCode,lastState:t.zantingData.status,status:-1,explain:t.zantingData.reason};t.$http.post("/scene/modifyState",a).then(function(e){e.data&&"0"==e.data.code?(t.refreshData(),t.$message({type:"success",message:"禁用成功"}),t.xiajiaData={},t.zantingDialogVisible=!1):e.data.msg?t.$message.error(e.data.msg):t.$message.error("禁用失败！")}).catch(function(){t.$message.error("禁用失败！")})})},zanting:function(e){this.zantingData=e,this.zantingDialogVisible=!0},xiajiaDialogClose:function(e){var t=this;"function"===typeof e?(this.xiajiaData={},e()):e?(this.xiajiaData={},this.xiajiaDialogVisible=!1):this.$refs["xiajiaData"].validate(function(e){if(!e)return t.$message.warning("请按要求填写"),!1;var a={id:t.xiajiaData.id,versionCode:t.xiajiaData.versionCode,lastState:t.xiajiaData.status,status:12,explain:t.xiajiaData.reason};t.$http.post("/scene/modifyState",a).then(function(e){e.data&&"0"==e.data.code?(t.refreshData(),t.$message({type:"success",message:"下架成功"}),t.xiajiaData={},t.xiajiaDialogVisible=!1):e.data.msg?t.$message.error(e.data.msg):t.$message.error("下架失败！")}).catch(function(){t.$message.error("下架失败！")})})},xiajia:function(e){this.xiajiaData=e,this.xiajiaDialogVisible=!0},shangjia:function(e){var t=this,a={id:e.id,versionCode:e.versionCode,lastState:e.status,status:9};this.$http.post("/scene/modifyState",a).then(function(e){e.data&&"0"==e.data.code?(t.refreshData(),t.$message({type:"success",message:"上架成功"})):e.data.msg?t.$message.error(e.data.msg):t.$message.error("上架失败！")}).catch(function(){t.$message.error("上架失败！")})},goDetailPage:function(e){this.$emit("table-event",{type:"detail-page",data:e})},goCheckPage:function(e){this.$emit("table-event",{type:"check-page",data:e})},refreshData:function(){this.$emit("table-event",{type:"refresh-data"})},handleSortChange:function(e){var t=e.prop,a="";"ascending"===e.order?a="asc":"descending"===e.order&&(a="desc"),this.$emit("table-event",{type:"sortChange",data:{field:t,order:a}})}}},c=o,u=(a("7a3c"),a("2877")),p=Object(u["a"])(c,r,l,!1,null,"06d4a8fa",null);p.options.__file="TableComponent.vue";var m=p.exports,d=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"header-class"},[a("div",{staticClass:"left-input"},[a("el-input",{attrs:{placeholder:"名称",clearable:""},on:{change:e.searchData},model:{value:e.publishName,callback:function(t){e.publishName=t},expression:"publishName"}})],1),a("el-select",{staticClass:"left-select",attrs:{clearable:"",placeholder:"类别"},on:{change:e.searchData},model:{value:e.typeKey,callback:function(t){e.typeKey=t},expression:"typeKey"}},e._l(e.typeList,function(e){return a("el-option",{key:e,attrs:{label:e,value:e}})})),a("el-select",{staticClass:"left-select",attrs:{clearable:"",placeholder:"状态"},on:{change:e.searchData},model:{value:e.statusKey,callback:function(t){e.statusKey=t},expression:"statusKey"}},e._l(e.statusList,function(e){return a("el-option",{key:e.key,attrs:{label:e.name,value:e.key}})})),a("el-select",{staticClass:"left-select",attrs:{clearable:"",placeholder:"修改人"},on:{change:e.searchData},model:{value:e.modifyUserName,callback:function(t){e.modifyUserName=t},expression:"modifyUserName"}},e._l(e.nameList,function(e){return a("el-option",{key:e,attrs:{label:e,value:e}})})),a("el-button",{staticClass:"left-button",attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.searchData}},[e._v("搜索")])],1)},h=[],g={name:"header-component",props:{isCheckpage:{type:Boolean,default:!1}},data:function(){return{nameList:[],modifyUserName:"",publishName:"",typeKey:"",statusKey:"",typeList:["卡片","tips"],statusList:[{key:0,name:"待发布"},{key:1,name:"发布审核"},{key:2,name:"待启动"},{key:3,name:"驳回"},{key:4,name:"灰度"},{key:5,name:"全量发布"},{key:6,name:"暂停中"},{key:7,name:"已失效"}]}},mounted:function(){this.getModifyNameList()},methods:{searchData:function(){this.$emit("header-event",{type:"search-event",data:{name:this.publishName,classification:this.typeKey,modifyUserName:this.modifyUserName,status:this.statusKey}})},getModifyNameList:function(){var e=this;this.$http.post("/scene/getModifyUserName",{}).then(function(t){0===t.data.code&&(e.nameList=t.data.data)}).catch(function(){})}}},y=g,f=(a("e14b"),Object(u["a"])(y,d,h,!1,null,"1fd00159",null));f.options.__file="HeaderComponent.vue";var b=f.exports,v=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"add-wrap"},[a("el-button",{attrs:{type:"primary"},on:{click:e.addTips}},[e._v("创建发布")])],1)},D=[],_={methods:{addTips:function(){this.$emit("table-event",{type:"add-page",data:{name:this.tipsName,state:this.statusKey}})}}},T=_,x=(a("8819"),Object(u["a"])(T,v,D,!1,null,"d918d78c",null));x.options.__file="AddComponent.vue";var L=x.exports,w=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"footer"},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,20,50,100,500,1e3],"page-size":e.pageSize,"pager-count":11,layout:"total, sizes, prev, pager, next, jumper",total:e.dataTotal},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)},k=[],$=(a("c5f6"),{name:"footer-component",props:{dataTotal:Number,currentPage:Number,pageSize:Number},methods:{handleCurrentChange:function(e){this.$emit("footer-event",{type:"pageChange",data:e})},handleSizeChange:function(e){this.$emit("footer-event",{type:"sizeChange",data:e})}}}),C=$,I=(a("9a34"),Object(u["a"])(C,w,k,!1,null,"68af0c6b",null));I.options.__file="FooterComponent.vue";var S=I.exports,N=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.uploadLoading,expression:"uploadLoading"}],staticClass:"publish-container"},[a("div",{staticClass:"rules-area box-class"},[a("span",{staticClass:"title-class"},[e._v("服务选择")]),e.isAdd?a("el-form",{ref:"serviceData",attrs:{"label-position":"left",model:e.serviceData,rules:e.serviceRule,"label-width":"150px",size:"small"}},[a("el-form-item",{attrs:{label:"服务类别：",prop:"classification"}},[a("el-select",{attrs:{placeholder:"请选择服务类别"},on:{change:e.classificationChange},model:{value:e.serviceData.classification,callback:function(t){e.$set(e.serviceData,"classification",t)},expression:"serviceData.classification"}},e._l(e.typeList,function(e){return a("el-option",{key:e,attrs:{label:e,value:e}})}))],1),a("el-form-item",{attrs:{label:"服务名称：",prop:"strategyId"}},[a("el-select",{attrs:{placeholder:"请选择服务名称"},model:{value:e.serviceData.strategyId,callback:function(t){e.$set(e.serviceData,"strategyId",t)},expression:"serviceData.strategyId"}},e._l(e.typeData[e.serviceData.classification],function(e){return a("el-option",{key:e.strategyId,attrs:{label:e.name,value:e.strategyId}})}))],1)],1):a("el-form",{attrs:{"label-position":"left",model:e.serviceData,"label-width":"150px",size:"small"}},[a("el-form-item",{attrs:{label:"服务类别："}},[e._v("\n        "+e._s(e.baseData.classification)+"\n      ")]),a("el-form-item",{attrs:{label:"服务名称："}},[e._v("\n        "+e._s(e.baseData.name)+"\n      ")])],1)],1),e.isDetailpage?e._e():a("div",{staticClass:"rules-area box-class"},[a("span",{staticClass:"title-class"},[e._v("发布策略")]),a("el-form",{ref:"imeiData",staticClass:"my-form",attrs:{"label-position":"left",model:e.imeiData,rules:e.imeiRules,"label-width":"150px",size:"small"}},[a("el-form-item",{attrs:{label:"客户端最低版本号：",prop:"clientVersion"}},[a("el-input",{attrs:{type:"text",placeholder:"如：40100"},model:{value:e.imeiData.clientVersion,callback:function(t){e.$set(e.imeiData,"clientVersion",t)},expression:"imeiData.clientVersion"}}),a("div",{staticStyle:{float:"right"}},[e._v(e._s(e.imeiData.clientVersion?e.imeiData.clientVersion.length:0)+"/10")])],1),a("el-form-item",{attrs:{label:"发布方式：",prop:"type"}},[a("el-radio-group",{model:{value:e.imeiData.type,callback:function(t){e.$set(e.imeiData,"type",t)},expression:"imeiData.type"}},[a("el-radio",{attrs:{label:0}},[e._v("全量发布")]),a("el-radio",{attrs:{label:1}},[e._v("灰度发布")])],1)],1),1===e.imeiData.type?a("el-form-item",{attrs:{label:"控制方式：",prop:"greyTypeList"}},[a("el-checkbox-group",{attrs:{size:"small"},model:{value:e.imeiData.greyTypeList,callback:function(t){e.$set(e.imeiData,"greyTypeList",t)},expression:"imeiData.greyTypeList"}},[a("el-checkbox",{attrs:{label:0}},[e._v("IMEI控制")]),a("el-checkbox",{attrs:{label:1}},[e._v("用户标签")])],1)],1):e._e(),1===e.imeiData.type&&e.imeiData.greyTypeList.length>0&&(0===e.imeiData.greyTypeList[0]||0===e.imeiData.greyTypeList[1])?a("el-form-item",{attrs:{label:"定向灰度：",prop:"imeiGreyType"}},[a("el-radio-group",{model:{value:e.imeiData.imeiGreyType,callback:function(t){e.$set(e.imeiData,"imeiGreyType",t)},expression:"imeiData.imeiGreyType"}},[a("el-radio",{attrs:{label:0}},[e._v("指定IMEI")]),a("el-radio",{attrs:{label:1}},[e._v("屏蔽IMEI")])],1)],1):e._e(),1===e.imeiData.type&&e.imeiData.greyTypeList.length>0&&(0===e.imeiData.greyTypeList[0]||0===e.imeiData.greyTypeList[1])?a("el-form-item",{attrs:{label:"上传IMEI方式：",prop:"grayscaleDataType"}},[a("el-checkbox-group",{attrs:{size:"small"},on:{change:e.grayscaleDataTypeChange},model:{value:e.grayscaleDataTypes,callback:function(t){e.grayscaleDataTypes=t},expression:"grayscaleDataTypes"}},[a("el-checkbox",{attrs:{label:1}},[e._v("手动填写(≤10个)")]),a("el-checkbox",{attrs:{label:2}},[e._v("上传文件(txt格式，每行一个IMEI码，请不要添加其他字符)")])],1),1===e.grayscaleDataTypes[0]?a("div",{staticClass:"time-box"},[a("el-input",{staticStyle:{width:"200px","margin-right":"20px"},attrs:{placeholder:"请输入IMEI"},model:{value:e.imeiValue,callback:function(t){e.imeiValue=t},expression:"imeiValue"}}),a("el-button",{attrs:{type:"primary",round:"",size:"mini"},on:{click:function(t){e.saveIMEI()}}},[e._v("添加")])],1):e._e(),1===e.grayscaleDataTypes[0]?e._l(e.imeiList,function(t,i){return a("el-tag",{key:i,staticStyle:{"margin-right":"5px"},attrs:{closable:"",type:"info"},on:{close:function(t){e.deleteIMEI(i)}}},[e._v("\n            "+e._s(t)+"\n          ")])}):e._e(),2!==e.grayscaleDataTypes[0]||this.excelFile?e._e():a("div",[e.downloadFileName?a("a",{staticClass:"download",attrs:{href:e.downloadFileUrl,download:"下载",title:"下载",target:"_blank"}},[e._v(e._s(e.downloadFileName))]):e._e()]),2===e.grayscaleDataTypes[0]?a("el-upload",{ref:"upload",staticStyle:{width:"400px"},attrs:{action:"ceshi","http-request":e.getExcelFile,"before-remove":e.removeFile,limit:1,"on-exceed":e.handleExceed}},[a("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")])],1):e._e()],2):e._e(),1===e.imeiData.type&&e.imeiData.greyTypeList.length>0&&(0===e.imeiData.greyTypeList[0]||0===e.imeiData.greyTypeList[1])?a("el-form-item",{attrs:{label:"尾数灰度："}},[a("el-checkbox",{model:{value:e.isMantissaList1,callback:function(t){e.isMantissaList1=t},expression:"isMantissaList1"}},[e._v("使用1个尾数")]),e.isMantissaList1?a("el-checkbox-group",{model:{value:e.mantissaList1,callback:function(t){e.mantissaList1=t},expression:"mantissaList1"}},e._l(10,function(t){return a("el-checkbox",{key:e.getForNumber(t,1),staticStyle:{"margin-left":"0px !important","margin-right":"20px !important"},attrs:{label:e.getForNumber(t,1)}},[e._v(e._s(e.getForNumber(t,1)))])})):e._e(),a("el-checkbox",{model:{value:e.isMantissaList2,callback:function(t){e.isMantissaList2=t},expression:"isMantissaList2"}},[e._v("使用2个尾数")]),e.isMantissaList2?a("el-checkbox-group",{model:{value:e.mantissaList2,callback:function(t){e.mantissaList2=t},expression:"mantissaList2"}},e._l(100,function(t){return a("el-checkbox",{key:e.getForNumber(t,2),staticStyle:{"margin-left":"0px !important","margin-right":"20px !important"},attrs:{label:e.getForNumber(t,2)}},[e._v(e._s(e.getForNumber(t,2)))])})):e._e()],1):e._e(),a("el-form-item",{directives:[{name:"show",rawName:"v-show",value:1===e.imeiData.type&&e.imeiData.greyTypeList.length>0&&(1===e.imeiData.greyTypeList[0]||1===e.imeiData.greyTypeList[1]),expression:"imeiData.type===1&&imeiData.greyTypeList.length>0&&(imeiData.greyTypeList[0]===1||imeiData.greyTypeList[1]===1)"}],attrs:{label:"用户标签"}},[a("treeselect",{attrs:{"load-options":e.loadOptions,"max-height":500,placeholder:"请选择或者输入关键字搜索",multiple:!0,options:e.tagTreeData,clearable:!0,searchable:!0},model:{value:e.imeiData.tags,callback:function(t){e.$set(e.imeiData,"tags",t)},expression:"imeiData.tags"}})],1)],1)],1),e.isDetailpage?a("div",{staticClass:"rules-area box-class"},[a("span",{staticClass:"title-class"},[e._v("发布策略")]),a("el-form",{ref:"imeiData",staticClass:"my-form",attrs:{"label-position":"left",model:e.imeiData,"label-width":"150px",size:"small"}},[a("el-form-item",{attrs:{label:"客户端最低版本号："}},[e._v("\n        "+e._s(e.imeiData.clientVersion)+"\n      ")]),a("el-form-item",{attrs:{label:"发布方式：",prop:"type"}},[0===e.imeiData.type?a("div",[e._v("全量发布")]):e._e(),1===e.imeiData.type?a("div",[e._v("灰度发布")]):e._e()]),1===e.imeiData.type?a("el-form-item",{attrs:{label:"控制方式：",prop:"greyTypeList"}},[e.imeiData.greyTypeList.length>0&&(0===e.imeiData.greyTypeList[0]||0===e.imeiData.greyTypeList[1])?a("div",[e._v("IMEI控制")]):e._e(),e.imeiData.greyTypeList.length>0&&(1===e.imeiData.greyTypeList[0]||1===e.imeiData.greyTypeList[1])?a("div",[e._v("用户标签")]):e._e()]):e._e(),1===e.imeiData.type&&e.imeiData.greyTypeList.length>0&&(0===e.imeiData.greyTypeList[0]||0===e.imeiData.greyTypeList[1])?a("el-form-item",{attrs:{label:"定向灰度：",prop:"imeiGreyType"}},[0===e.imeiData.imeiGreyType?a("div",[e._v("指定IMEI")]):e._e(),1===e.imeiData.imeiGreyType?a("div",[e._v("屏蔽IMEI")]):e._e()]):e._e(),1===e.imeiData.type?a("el-form-item",{attrs:{label:"上传IMEI方式："}},[1===e.grayscaleDataTypes[0]?[a("div",[e._v("手动填写(≤10个)")]),e._l(e.imeiList,function(t,i){return a("el-tag",{key:i,staticStyle:{"margin-right":"5px"},attrs:{type:"info"}},[e._v("\n            "+e._s(t)+"\n          ")])})]:e._e(),2===e.grayscaleDataTypes[0]?[a("div",[e._v("上传文件(txt格式，每行一个IMEI码，请不要添加其他字符)")]),e.excelFileName?a("div",[e._v(e._s(e.excelFileName))]):e._e(),!e.excelFileName&&e.downloadFileName?a("a",{staticClass:"download",attrs:{href:e.downloadFileUrl,download:"下载",title:"下载",target:"_blank"}},[e._v(e._s(e.downloadFileName))]):e._e()]:e._e()],2):e._e(),1===e.imeiData.type&&e.imeiData.greyTypeList.length>0&&(0===e.imeiData.greyTypeList[0]||0===e.imeiData.greyTypeList[1])?a("el-form-item",{attrs:{label:"尾数灰度："}},[a("span",[e._v(e._s(e.mantissaList1.join(" , ")+(e.mantissaList1.length>0&&e.mantissaList2.length>0?" , ":"")+e.mantissaList2.join(" , ")))])]):e._e(),a("el-form-item",{directives:[{name:"show",rawName:"v-show",value:1===e.imeiData.type&&e.imeiData.greyTypeList.length>0&&(1===e.imeiData.greyTypeList[0]||1===e.imeiData.greyTypeList[1]),expression:"imeiData.type===1&&imeiData.greyTypeList.length>0&&(imeiData.greyTypeList[0]===1||imeiData.greyTypeList[1]===1)"}],attrs:{label:"用户标签："}},[a("treeselect",{attrs:{"no-options-text":"没有数据","load-options":e.loadOptions,"max-height":500,placeholder:"请选择或者输入关键字搜索",multiple:!0,options:e.tagTreeData,clearable:!0,searchable:!0,disabled:!0},model:{value:e.imeiData.tags,callback:function(t){e.$set(e.imeiData,"tags",t)},expression:"imeiData.tags"}})],1)],1)],1):e._e(),e.isDetailpage&&e.bohuiReason?a("div",{staticClass:"box-class"},[a("div",{staticClass:"reason-area"},[a("div",{staticStyle:{"font-size":"19px","font-weight":"bold"}},[e._v("驳回原因")]),a("div",[e._v(e._s(e.bohuiReason))])])]):e._e(),e.isDetailpage?e._e():a("div",{staticClass:"buttons-area box-class"},[1===e.stepNumber?a("el-button",{staticClass:"button-class",attrs:{type:"primary",round:""},on:{click:function(t){e.cancelEditButton()}}},[e._v("取消编辑")]):e._e(),1===e.stepNumber?a("el-button",{staticClass:"button-class",attrs:{type:"primary",round:""},on:{click:function(t){e.saveButton()}}},[e._v("提交审核")]):e._e()],1),e.isDetailpage?a("div",{staticClass:"buttons-area box-class"},[1===e.stepNumber?a("el-button",{staticClass:"button-class",attrs:{type:"primary",round:""},on:{click:function(t){e.goHome()}}},[e._v("返回")]):e._e()],1):e._e()])},E=[],z=(a("ac6a"),a("96cf"),a("3040")),P=(a("6762"),a("2fdb"),a("28a5"),a("6b54"),a("3b2b"),a("a481"),[{startTime:"2018/10/1 0:00",endTime:"2018/10/1 23:59",value:"国庆节"},{startTime:"2018/10/31 0:00",endTime:"2018/10/31 23:59",value:"万圣节"},{startTime:"2018/11/22 0:00",endTime:"2018/11/22 23:59",value:"感恩节"},{startTime:"2018/12/22 0:00",endTime:"2018/12/22 23:59",value:"冬至"},{startTime:"2018/12/24 0:00",endTime:"2018/12/24 23:59",value:"平安夜"},{startTime:"2019/1/1 0:00",endTime:"2019/1/1 23:59",value:"元旦节"},{startTime:"2019/1/13 0:00",endTime:"2019/1/13 23:59",value:"腊八节"},{startTime:"2019/1/28 0:00",endTime:"2019/1/28 23:59",value:"小年"},{startTime:"2019/2/4 0:00",endTime:"2019/2/4 23:59",value:"除夕"},{startTime:"2019/2/5 0:00",endTime:"2019/2/5 23:59",value:"春节"},{startTime:"2019/2/14 0:00",endTime:"2019/2/14 23:59",value:"情人节"},{startTime:"2019/2/19 0:00",endTime:"2019/2/19 23:59",value:"元宵节"},{startTime:"2019/3/7 0:00",endTime:"2019/3/7 23:59",value:"女生节"},{startTime:"2019/3/8 0:00",endTime:"2019/3/8 23:59",value:"妇女节"},{startTime:"2019/4/1 0:00",endTime:"2019/4/1 23:59",value:"愚人节"},{startTime:"2019/5/1 0:00",endTime:"2019/5/1 23:59",value:"劳动节"}]);Date.prototype.Format=function(e){var t={"M+":this.getMonth()+1,"d+":this.getDate(),"h+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};for(var a in/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length))),t)new RegExp("("+a+")").test(e)&&(e=e.replace(RegExp.$1,1==RegExp.$1.length?t[a]:("00"+t[a]).substr((""+t[a]).length)));return e};var M={holidayList:P},F=a("7026"),j=a.n(F),V=(a("542c"),{name:"publish-component",components:{Treeselect:j.a},props:{isCheckpage:{type:Boolean,default:!1},isAdd:{type:Boolean,default:!1},isDetailpage:{type:Boolean,default:!1},typeData:{},baseData:{}},data:function(){var e=function(e,t,a){/^\s+$/.test(t)?a(new Error("不能输入全空格")):a()};return{imeiFileUrl:"",tagTreeData:[],serviceData:{classification:"",name:""},typeList:["tips","卡片"],defaultProps:{value:"id",children:"children",label:"label"},grayscaleDataTypes:[],excelFileName:"",excelFile:"",uploadLoading:!1,greyType:1,downloadFileName:"",downloadFileUrl:"",isMantissaList1:!1,isMantissaList2:!1,imeiList:[],imeiValue:"",imeiData:{grayscaleDataType:"",type:1,clientVersion:"",greyTypeList:[]},mantissaList1:[],mantissaList2:[],startTimeDisabled:!1,testCardUrl:"",isExam:!1,xiajiaDialogVisible:!1,jinyongDialogVisible:!1,isEditPage:!0,examDialogVisible:!1,testImgSrc:"",testDialogVisible:!1,bohuiReason:"",cardPreview:"",expandPreview:"",holidayList:M.holidayList,stepNumber:1,weightData:{order:"",attenuationDuration:""},serviceRule:{classification:[{required:!0,message:"请选择服务类别",trigger:"change"}],strategyId:[{required:!0,message:"请选择服务名称",trigger:"change"}]},imeiRules:{clientVersion:[{required:!0,message:"请输入最低版本号",trigger:"blur"},{type:"string",pattern:/^[0-9]*$/,message:"版本号须为整数",trigger:"blur"},{min:1,max:10,message:"字数超过限制",trigger:"change"},{min:1,max:10,message:"字数超过限制",trigger:"blur"}],type:[{required:!0,message:"请选择发布方式",trigger:"change"}],greyTypeList:[{required:!0,message:"请选择控制方式",trigger:"change"}],imeiGreyType:[{required:!0,message:"请选择定向灰度",trigger:"change"}]},applyRules:[{required:!0,message:"内容不能为空",trigger:"blur"},{required:!0,validator:e,trigger:"blur"}]}},methods:{appendId:function(e,t){for(var a=0;a<e.length;a++)e[a]["id"]=t?t+"_"+e[a].key:""+e[a].key,e[a]["children"]&&this.appendId(e[a]["children"],e[a]["id"]);return e},appendKeyId:function(e){function t(t,a){return e.apply(this,arguments)}return t.toString=function(){return e.toString()},t}(function(e,t){for(var a=0;a<e.length;a++)e[a]["keyId"]=t?t+"-"+a:""+a,e[a]["children"]&&appendKeyId(e[a]["children"],e[a]["keyId"]);return e}),childrenToNull:function(e){var t=[];if(e)for(var a=0;a<e.length;a++)t[a]={id:e[a]["id"],label:e[a]["label"],hasScore:e[a]["hasScore"]},e[a]["children"]&&e[a]["children"].length>0&&(t[a]["children"]=null);else t=void 0;return t},findChildById:function(e,t){for(var a=t.split("_"),i=JSON.parse(JSON.stringify(e)),s=0;s<a.length;s++)i=i[parseInt(a[s])]["children"];return this.childrenToNull(i)},loadOptions:function(e){var t=e.action,a=e.parentNode,i=e.callback;"LOAD_CHILDREN_OPTIONS"===t&&(a.children=this.findChildById(this.tagTreeData,a.keyId),i())},classificationChange:function(){this.serviceData.name=""},grayscaleDataTypeChange:function(e){e.length>1&&this.grayscaleDataTypes.shift()},deleteIMEI:function(e){this.imeiList.splice(e,1)},saveIMEI:function(){this.imeiList.length>9?this.$confirm("10个以上IMEI码请通过文件上传","提示",{confirmButtonText:"确定",center:!0,type:"warning"}):this.imeiList.includes(this.imeiValue)?this.$confirm("IMEI码重复！","提示",{confirmButtonText:"确定",center:!0,type:"warning"}):/^\d{15}$/.test(this.imeiValue)?this.imeiList.push(this.imeiValue):this.$confirm("IMEI码不符合要求！(15位数字)","提示",{confirmButtonText:"确定",center:!0,type:"warning"})},getForNumber:function(e,t){var a=e-1;return 1===t?a+"":a<10?"0"+a:a+""},handleExceed:function(){this.$message.warning("一次只能上传一个文件，请先删掉当前文件")},removeFile:function(){this.excelFile="",this.excelFileName=""},getExcelFile:function(e){this.excelFile=e.file,this.excelFileName=e.file.name},goDataPage:function(){this.$emit("publish-event",{type:"data-page"})},goHome:function(){this.$emit("publish-event",{type:"home-page"})},isEmpty:function(e){return"undefined"===typeof e||""===e||null===e},dataCheck:function(e){var t=!1,a=this.imeiData.greyTypeList.length>0&&(0===this.imeiData.greyTypeList[0]||0===this.imeiData.greyTypeList[1]);if(this.isAdd&&this.$refs["serviceData"].validate(function(e){t=e}),this.$refs["imeiData"].validate(function(e){t=e}),!e){if(1===this.imeiData.type&&a){var i=!!(this.isMantissaList1&&this.mantissaList1.length>0),s=!!(this.isMantissaList2&&this.mantissaList2.length>0),n=1===this.grayscaleDataTypes[0]&&this.imeiList.length>0,r=!(2!==this.grayscaleDataTypes[0]||!this.excelFile);if(console.log(this.grayscaleDataTypes),console.log(this.imeiList.length),!(i||s||n||r))return this.$confirm("上传IMEI方式和尾数灰度至少选择一种！","提示",{confirmButtonText:"确定",center:!0,type:"warning"}),!1}if(1===this.imeiData.type&&this.imeiData.greyTypeList.length>0&&(1===this.imeiData.greyTypeList[0]||1===this.imeiData.greyTypeList[1])&&(!this.imeiData.tags||0===this.imeiData.tags.length))return this.$confirm("请选择用户标签！","提示",{confirmButtonText:"确定",center:!0,type:"warning"}),!1}return t},saveButton:function(){var e=Object(z["a"])(regeneratorRuntime.mark(function e(){var t,a,i,s=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,this.uploadExcel();case 2:if(this.imeiFileUrl=e.sent,this.dataCheck()){e.next=5;break}return e.abrupt("return",!1);case 5:this.uploadLoading=!0,t=this.mantissaList1.concat(this.mantissaList2).join(","),a=[],t&&a.push(1),(this.imeiFileUrl||this.imeiList.length>0)&&a.push(0),i={},i=0===this.imeiData.type?{classification:this.serviceData.classification,strategyId:this.serviceData.strategyId,clientVersion:parseInt(this.imeiData.clientVersion),type:this.imeiData.type}:{classification:this.serviceData.classification,strategyId:this.serviceData.strategyId,clientVersion:parseInt(this.imeiData.clientVersion),type:this.imeiData.type,imeiFileUrl:2===this.grayscaleDataTypes[0]?this.imeiFileUrl:"",imeiFileName:this.excelFileName,imeiDefineType:a.join(","),greyType:this.imeiData.greyTypeList.join(","),imeiGreyType:this.imeiData.imeiGreyType,imeiManual:1===this.grayscaleDataTypes[0]?this.imeiList.join(","):"",imeiEndNums:t,tags:this.imeiData.tags&&this.imeiData.tags.join(",")},this.isAdd?this.$http.post("/scene/publish",i).then(function(e){s.uploadLoading=!1,e.data&&"0"==e.data.code?(s.$message({type:"success",message:"创建发布成功！"}),s.goHome()):e.data.msg?s.$message.error(e.data.msg):s.$message.error("操作失败！")}).catch(function(){s.uploadLoading=!1,s.$message.error("操作失败！")}):this.$http.post("/scene/updatePublish",i).then(function(e){s.uploadLoading=!1,e.data&&"0"==e.data.code?(s.$message({type:"success",message:"修改发布成功！"}),s.goHome()):e.data.msg?s.$message.error(e.data.msg):s.$message.error("操作失败！")}).catch(function(){s.uploadLoading=!1,s.$message.error("操作失败！")});case 13:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),uploadExcel:function(){var e=Object(z["a"])(regeneratorRuntime.mark(function e(){var t,a=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:if(this.excelFile){e.next=2;break}return e.abrupt("return",null);case 2:return t=new FormData,t.append("file",this.excelFile),e.abrupt("return",new Promise(function(e){a.$http.post("/scene/uploadImeiFile",t).then(function(t){if(t.data&&0==t.data.code){var i=t.data.data.imeiFileUrl;e(i)}else a.uploadLoading=!1,t.data.msg?a.$message.error(t.data.msg):a.$message.error("操作失败！"),e("")}).catch(function(){a.uploadLoading=!1,a.$message.error("操作失败！"),e("")})}));case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),cancelEditButton:function(){var e=this;this.$confirm("是否确定取消编辑?","提示",{confirmButtonText:"确定",cancelButtonText:"返回",type:"warning",center:!0}).then(function(){e.$emit("publish-event",{type:"home-page"})}).catch(function(){})},getDataXhr:function(){var e=this,t={strategyId:this.baseData.strategyId};this.$http.post("/scene/getPublishDetail",t).then(function(t){if(t.data&&"0"==t.data.code&&t.data.data){var a=t.data.data;if(e.serviceData.classification=a.classification,e.serviceData.strategyId=a.strategyId,e.imeiData.type=a.type,console.log(e.imeiData.type),e.imeiData.imeiGreyType=a.imeiGreyType&&parseInt(a.imeiGreyType),e.imeiData.clientVersion=a.clientVersion+"",e.imeiData.greyTypeList=a.greyType?a.greyType.split(",").map(Number):[],e.imeiData.imeiDefineTypeList=a.imeiDefineType?a.imeiDefineType.split(",").map(Number):[],a.imeiManual&&(e.grayscaleDataTypes=[1],e.imeiList=a.imeiManual.split(",").map(Number)),a.fileUrl&&(e.grayscaleDataTypes=[2],e.imeiList=[],e.downloadFileName=a.fileName,e.downloadFileUrl=a.fileUrl),e.imeiData.tags=a.tags&&a.tags.split(","),a.imeiEndNums){var i=a.imeiEndNums.split(",");i.forEach(function(t){1===t.length?e.mantissaList1.push(t):2===t.length&&e.mantissaList2.push(t)}),e.isMantissaList2=e.mantissaList2.length>0,e.isMantissaList1=e.mantissaList1.length>0}e.imeiData=JSON.parse(JSON.stringify(e.imeiData))}}).catch(function(){})},getTagList:function(){var e=this;this.$http.post("/scene/getTagTree",{}).then(function(t){if(0===t.data.code){var a=t.data.data.children;a=e.appendId(a),e.tagTreeData=a}}).catch(function(){})}},mounted:function(){(this.isCheckpage||this.isDetailpage)&&(this.isEditPage=!1),this.baseData.id,this.getDataXhr(),this.getTagList()},created:function(){}}),O=V,U=(a("a3e3"),a("2b93"),Object(u["a"])(O,N,E,!1,null,"91250e28",null));U.options.__file="PubulishComponent.vue";var R=U.exports,B={name:"app",components:{addComponent:L,tableComponent:m,headerComponent:b,footerComponent:S,publishComponent:R},data:function(){return{isPublishShow:!1,isDetailPage:!1,isTableShow:!0,isCheckPage:!1,isAdd:!1,typeList:[],dataList:[],pageIndex:1,pageSize:20,dataTotal:0,searchName:"",searchType:"",searchModifyUserName:"",searchState:"",searchField:"",searchOrder:"",baseData:{}}},methods:{publishEvent:function(e){switch(e.type){case"home-page":this.goHome();break;case"data-page":break;default:break}},goHome:function(){this.getDataXhr(),this.isPublishShow=!1,this.isAdd=!1,this.isCheckPage=!1,this.isDetailPage=!1,this.isTableShow=!0},tableEvent:function(e){switch(e.type){case"data-page":break;case"add-page":this.baseData={},this.isTableShow=!1,this.isAdd=!0,this.isDetailPage=!1,this.isCheckPage=!1,this.isPublishShow=!0;break;case"edit-page":this.baseData=e.data,this.isAdd=!1,this.isTableShow=!1,this.isDetailPage=!1,this.isCheckPage=!1,this.isPublishShow=!0;break;case"detail-page":this.baseData=e.data,this.isTableShow=!1,this.isAdd=!1,this.isDetailPage=!0,this.isCheckPage=!1,this.isPublishShow=!0;break;case"check-page":this.baseData=e.data,this.isAdd=!1,this.isTableShow=!1,this.isDetailPage=!1,this.isCheckPage=!0,this.isPublishShow=!0;break;case"refresh-data":this.getDataXhr();break;case"sortChange":this.searchOrder=e.data.order,this.searchField=e.data.field,this.getDataXhr();break;default:break}},headerEvent:function(e){this.searchData(e.data)},searchData:function(e){this.searchName=e.name,this.searchType=e.classification,this.isCheckPage?this.searchState=3:this.searchState=e.status,this.searchModifyUserName=e.modifyUserName,this.pageIndex=1,this.getDataXhr()},getDataXhr:function(){var e=this,t={name:""===this.searchName?void 0:this.searchName,status:""===this.searchState?void 0:this.searchState,classification:""===this.searchType?void 0:this.searchType,modifyUserName:""===this.searchModifyUserName?void 0:this.searchModifyUserName,field:""===this.searchField?void 0:this.searchField,order:""===this.searchOrder?void 0:this.searchOrder,page:this.pageIndex,size:this.pageSize};this.$http.post("/scene/publishList",t).then(function(t){e.dataTotal=t.data.data&&t.data.data.totalElements,e.dataList=t.data.data&&t.data.data.content}).catch(function(){})},getTypeList:function(){var e=this;this.$http.post("/scene/getPublishExamine",{}).then(function(t){e.typeList=t.data.data&&t.data.data}).catch(function(){})},footerEvent:function(e){switch(e.type){case"pageChange":this.pageIndex=e.data,this.getDataXhr();break;case"sizeChange":this.pageIndex=1,this.pageSize=e.data,this.getDataXhr();break;default:break}}},created:function(){this.getDataXhr(),this.getTypeList()}},A=B,G=(a("58f3"),Object(u["a"])(A,s,n,!1,null,"1333e717",null));G.options.__file="App.vue";var K,q=G.exports,H=a("5c96"),X=a.n(H),J=a("bc3a"),Y=a.n(J);K=Y.a.create({baseURL:location.origin});var Q=K;a("0fae");i["default"].use(X.a),i["default"].config.productionTip=!1,i["default"].prototype.$http=Q,new i["default"]({render:function(e){return e(q)}}).$mount("#app")},"58f3":function(e,t,a){"use strict";var i=a("3917"),s=a.n(i);s.a},"5c18":function(e,t,a){},"6ae3":function(e,t,a){},"7a3c":function(e,t,a){"use strict";var i=a("ae35"),s=a.n(i);s.a},8819:function(e,t,a){"use strict";var i=a("5c18"),s=a.n(i);s.a},"9a34":function(e,t,a){"use strict";var i=a("ef21"),s=a.n(i);s.a},a3e3:function(e,t,a){"use strict";var i=a("6ae3"),s=a.n(i);s.a},ae35:function(e,t,a){},b554:function(e,t,a){},e14b:function(e,t,a){"use strict";var i=a("b554"),s=a.n(i);s.a},ec79:function(e,t,a){},ef21:function(e,t,a){}});
//# sourceMappingURL=app.de35c045.js.map