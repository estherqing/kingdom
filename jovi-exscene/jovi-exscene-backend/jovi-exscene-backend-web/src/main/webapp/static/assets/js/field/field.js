var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";

jQuery(function ($) {
    $('[data-rel=popover]').popover({container: 'body'});   //提示
    $('[data-rel=tooltip]').tooltip();

    $(grid_selector).jqGrid({
        url: getContextPath() + "/field/querybypage.json",
        editurl: getContextPath() + "/field/edit.json",
        delurl: getContextPath() + "/field/delete.json",
        datatype: "json",
        mtype: "post",
        postData: {
            packageName: $("#packageName").val()
        },
        colNames: ['字段名', '字段类型', '是否比对类字段', '是否统计类字段', '修改时间', '编辑'],
        colModel: [
            {name: 'fieldName', index: 'fieldName', align: "center", sortable: false, width: 50,editable: true},
            {
                name: 'fieldType',
                index: 'fieldType',
                align: "center",
                sortable: false,
                editable: true,
                width: 30,
                edittype: "select",
                editoptions: {value: "0: 未定义;1: 字符串;2: 整数; 3: 浮点数; 4: 布尔值"},
                formatter:formatFieldType
            },
            {
                name: 'isCompare',
                index: 'isCompare',
                align: "center",
                sortable: false,
                width: 30,
                editable: true,
                edittype: "checkbox",
                editoptions: {value:"1:0"},
                unformat: aceSwitch,
                formatter: formatBoolean
            },
            {
                name: 'isStatistic',
                index: 'isStatistic',
                align: "center",
                sortable: false,
                width: 30,
                editable: true,
                edittype: "checkbox",
                editoptions: {value:"1:0"},
                unformat: aceSwitch,
                formatter: formatBoolean
            },
            {name: 'updateTime', index: 'updateTime', align: "center", sortable: false, width: 30},
            {
                name: 'edit', index: '', width: 150, fixed: true, sortable: false,
                formatter: 'actions',
                formatoptions: {
                    keys: true,
                    delOptions: {recreateForm: true},
                    onSuccess: function (response) {
                        return handleAjaxResponse(response, function () {
                            gridReload();
                        });
                    }
                }
            }
        ],
        rowNum: 30,
        sortorder: 'desc',
        sortname: 'uniqid',
        viewrecords: true,
        pager: pager_selector,
        altRows: true,
        emptyrecords: "没有找到数据",
        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                updatePagerIcons(table);
            }, 0);

            $(this).jqGrid('setGridWidth', $("#tablecontent").width());    //加载完数据后重新设置下宽度
        },
        autowidth: true,
        height: 'auto',
        prmNames: {page: "page", rows: "size", sort: "sinx", order: "order", search: "search", nd: "nd", npage: null},
        jsonReader: {
            root: "data.content",
            total: "data.totalPages",
            page: "data.number",
            records: "data.totalElements",
            repeatitems: false
        },
    });

    //class="ace ace-switch ace-switch-4 btn-rotate" type="checkbox"

    //resize to fit page size
    $(window).on('resize.jqGrid', function () {
        $(grid_selector).jqGrid('setGridWidth', $("#tablecontent").width());
    });

    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size


    //设置确定按钮点击事件，重新加载表格
    $("#searchSubmit").on("click", function (e) {
        gridReload();
    });


    //给toolbar下面的输入框绑定回车键事件
    $('.toolbar input').keypress(function (event) {
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if (keycode == '13') {
            gridReload();
        }
    });


    //校验
    $('#createForm').validate({
        submitHandler: function (form) {  //提交
            $("#createForm").ajaxSubmit({
                type: 'post',
                dataType: 'json',
                complete: function (response) {
                    handleAjaxResponse(response, function () {
                        hideAddDialog();
                        gridReload();
                    });
                }
            });
            $(form)[0].reset();
        },
        errorElement: 'div',
        errorClass: 'help-block',
        focusInvalid: true,
        ignore: "",
        rules: {
            fieldName:{
                required:true
            },
            fieldType:{
                required:true
            },
            isStatistic: {
                required: true
            },
            isCompare: {
                required: true
            }
        },
        messages: {
            fieldName:{
                required:"不能为空"
            },
            fieldType:{
                required:"请选择"
            },
            isIndex: {
                required: "请选择"
            },
            isPattern: {
                required: "请选择"
            },
            isCompare: {
                required: "请选择"
            }
        }, highlight: function (e) {
            $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
        },
        success: function (e) {
            $(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
            $(e).remove();
        }

    });

   /* $(".is-statistic-label .lbl").on("click",function () {
        var
    })*/


})    //jquery


/* ------------------------------------------- */


//replace icons with FontAwesome icons like above
function updatePagerIcons(table) {
    var replacement =
    {
        'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
        'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
        'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
        'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
    };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
    })
}

function aceSwitch(cellvalue, options, cell ){
    setTimeout(function(){
        var s = $(cell).find('input[type=checkbox]');
        $(s).addClass('ace ace-switch ace-switch-4 btn-flat')
            .after('<span class="lbl"></span>');
        if("是" == cellvalue) {
            $(s).attr("checked", true);
        }
    }, 0);
}

function enableTooltips(table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
}


function gridReload() {
    var formData = {};
    $.each($(".toolbar :input").serializeArray(), function (i, item) {
        formData[item.name] = item.value;
    });

    $(grid_selector).jqGrid('setGridParam', {
        postData: formData
    }).trigger("reloadGrid");
}


function showAddDialog() {
    $('#addDialog').modal('show');
}

function hideAddDialog() {
    $('#addDialog').modal('hide');
    $('#addDialog input').val('');
}


//处理ajax请求的返回结果，主要是对结果进行判断，查看是否请求成功
function handleAjaxResponse(response, successCallBack, errorCallBack) {
    //支持response为jqXHR和json
    if ((response.responseJSON && response.responseJSON.status == 200) ||
        (response.status && response.status == 200)) {
        if (successCallBack) {
            successCallBack();
        }
        return true;
    } else {
        var msg = '';
        if (response.responseJSON) {
            msg = response.responseJSON.msg;
        } else if (response.msg) {
            msg = response.msg;
        } else {
            msg = response.responseText;
        }
        bootbox.alert('操作失败！' + msg);
        return false;
    }
}

function getContextPath() {
    /*var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;*/
    return "";
}

function formatBoolean(cellvalue, options, rowObject){
    var html = "";
    if (1 == cellvalue) {
        html = "是";
    } else if (0 == cellvalue) {
        html = "否";
    }else{
        html = cellvalue;
    }
    if (undefined != html && html.toString().indexOf("是") != -1) {
        return "<span class='ace-switch-on'>" + html + "</span>";
    }else{
        return "<span class='ace-switch-off'>" + html + "</span>";
    }
}
function formatFieldType(cellvalue, options, rowObject){
    if(0 == cellvalue){
        return "未定义";
    }else if(1 == cellvalue){
        return "字符串";
    }else if(2 == cellvalue){
        return "整数";
    }else if(3 == cellvalue){
        return "浮点数";
    }else if(4 == cellvalue){
        return "布尔值";
    }else{
        return cellvalue;
    }
}