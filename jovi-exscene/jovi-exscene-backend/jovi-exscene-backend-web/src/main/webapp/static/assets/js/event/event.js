/**
 * Created by qiulida on 2016/9/13.
 */
var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";
$(function ($) {
    $('[data-rel=popover]').popover({container: 'body'});   //提示
    $('[data-rel=tooltip]').tooltip();
    var page = (undefined == $page) ? 1 : $page;

    var formData = {};
    $.each($(".toolbar :input").serializeArray(), function (i, item) {
        formData[item.name] = item.value;
    });

    $(grid_selector).jqGrid({
        url: $ctx + "/event/querybypage.json",
        datatype: "json",
        mtype: "post",
        postData: formData,
        colNames: ['id', '业务流水', '风险级别', 'imei', 'emmcid', 'openid', 'httpip', '来源产品', '来源渠道', '来源平台', '事件类型', '发生时间', '创建时间', '操作'],
        colModel: [
            {name: 'id', index: 'id', align: "center", sortable: false, width: 90, editable: true, hidden: true},
            {name: 'flowNo', index: 'flowNo', align: "center", sortable: false, width: 160, editable: true},
            {
                name: 'finalDecision',
                index: 'finalDecision',
                align: "center",
                sortable: false,
                width: 50,
                formatter: decisionFmatter
            },
            {name: 'imei', index: 'imei', align: "center", sortable: false, width: 70, editable: true},
            {name: 'emmcId', index: 'emmcId', align: "center", sortable: false, width: 100, editable: true},
            {name: 'openId', index: 'openId', align: "center", sortable: false, width: 100, editable: true},
            {name: 'httpIp', index: 'httpIp', align: "center", sortable: false, width: 80, editable: true},
            {name: 'srcProduct', index: 'srcProduct', align: "center", sortable: false, width: 50, editable: true},
            {name: 'srcChannel', index: 'srcChannel', align: "center", sortable: false, width: 50, editable: true},
            {name: 'srcPlatform', index: 'srcPlatform', align: "center", sortable: false, width: 50, editable: true},
            {name: 'eventType', index: 'eventType', align: "center", sortable: false, width: 50},
            {name: 'occurTime', index: 'occurTime', align: "center", sortable: false, width: 100},
            {name: 'createTime', index: 'createTime', align: "center", sortable: false, width: 100},
            {name: 'oper', index: '', width: 50, fixed: true, sortable: false, formatter: operFmatter}
        ],
        rowNum: 30,
        sortorder: 'desc',
        sortname: 'uniqid',
        pager: pager_selector,
        page: page,
        pginput: false,
        altRows: true,
        emptyrecords: "没有找到数据或者已经到了最后一页",
        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                updatePagerIcons(table);
            }, 0);

            $(this).jqGrid('setGridWidth', $("#tablecontent").width());    //加载完数据后重新设置下宽度
            //隐藏掉第一页和最后一页
            $("#last_grid-pager").hide();
            $("#first_grid-pager").hide();
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
        }
    });

    //决策值渲染
    function decisionFmatter(cellvalue, options, rowObject) {
        if (cellvalue == 'HIGHRISK') {
            return '<span class="label label-danger">高风险</span>';
        } else if (cellvalue == 'LOWRISK') {
            return '<span class="label label-warning">低风险</span>';
        } else if (cellvalue == 'NORISK') {
            return '<span class="label label-success">无风险</span>';
        } else {
            return '-';
        }
    }

    //resize to fit page size
    $(window).on('resize.jqGrid', function () {
        $(grid_selector).jqGrid('setGridWidth', $("#tablecontent").width());
    });

    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size

    function operFmatter(cellvalue, options, rowObject) {
        return '<button data-rel="tooltip" data-original-title="详情" style="margin-left:2px" class="btn btn-minier btn-info" onclick="openDetailTab(' + rowObject.id + ')" >' +
            '<i class="ace-icon fa fa-info-circle  bigger-110 icon-only"></i></button>';
    }

    //设置确定按钮点击事件，重新加载表格
    $("#searchSubmit").on("click", function (e) {
        gridReload();
    });
    //设置统计总数按钮点击事件
    bindQueryCount();
    bindCountRest();

    $(".clear").bind("click", function (e) {
        $(this).prev().val("");
    });


    //给toolbar下面的输入框绑定回车键事件
    $('.toolbar input').keypress(function (event) {
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if (keycode == '13') {
            gridReload();
        }
    });


    $("#begin_time").datetimepicker({
        locale: 'cn',
        format: 'YYYY-MM-DD HH:mm:ss'
    });
    $("#end_time").datetimepicker({
        locale: 'cn',
        format: 'YYYY-MM-DD HH:mm:ss'
    });
    linkageSelect();
});

function linkageSelect() {
    $('select[name="srcProduct"]').change(function () {
        $('select[name="srcChannel"]').empty();

        if ($('select[name="srcProduct"]').val() != "") {
            $.ajax({
                url: $ctx + "/dict/querychildren",
                data: {parentKey: $(this).val()},
                type: "POST",
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    if (response.status == 200) {
                        var data = response.data;
                        if (data.length > 0) {
                            $('select[name="srcChannel"]').append("<option value=''>---请选择---</option>");
                            for (var i in data) {
                                $('select[name="srcChannel"]').append("<option value='" + data[i].dictKey + "'>" + data[i].dictValue + "</option>");
                            }
                        }
                    }
                    //
                }
            });
        }
    });
}

function gridReload() {
    var formData = {};
    $.each($(".toolbar :input").serializeArray(), function (i, item) {
        formData[item.name] = item.value;
    });

    $(grid_selector).jqGrid('setGridParam', {
        postData: formData,
        page: 1
    }).trigger("reloadGrid");
}

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

function bindQueryCount() {
    $("#countSubmit").on("click", function (e) {
        $("#totalNum").text("统计中...");
        var formData = {};
        $.each($(".toolbar :input").serializeArray(), function (i, item) {
            formData[item.name] = item.value;
        });
        $.post("/event/queryTotal.json", formData, function (response) {
            console.log(response.data);
            $("#totalNum").text("总数目：" + response.data);
        }, "json");
    });
}
function bindCountRest(){
    $(".toolbar :input").on("change",function (e) {
        $("#totalNum").text("条件变化，请重新统计");
    })
}