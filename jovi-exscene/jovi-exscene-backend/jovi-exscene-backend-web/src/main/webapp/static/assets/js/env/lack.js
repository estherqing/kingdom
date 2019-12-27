function initMultiSelect() {
    $("select[name='dimType1']").multiselect({
        nonSelectedText: "请选择主属性",
        disableIfEmpty: false,
        numberDisplayed: 8
    });
    $("select[name='dimType2']").multiselect({
        nonSelectedText: "请选择从属性",
        disableIfEmpty: false,
        numberDisplayed: 8
    });
}
jQuery(function ($) {
    //resize to fit page size

    //设置确定按钮点击事件，重新加载表格
    /* $("#searchSubmit").on("click",function(e){
     gridReload();
     });*/


    //给toolbar下面的输入框绑定回车键事件
    $('.toolbar input').keypress(function (event) {
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if (keycode == '13') {
            gridReload();
        }
    });


    //绑定tooltip提示
    $('[data-rel=popover]').popover({container: 'body'});   //提示
    $('[data-rel=tooltip]').tooltip();

    initMultiSelect();

    if ("edit" == oper) {
        initEditOrView();
    } else if ("view" == oper) {
        initEditOrView();
        disableInput();
    }

    //根据规则集匹配模式,显示权重或者是高低风险
    if ("1" == '${matchMode}') {
        $("#decision").hide();
        $("#decisionDesc").text("权重");
    } else {
        $("#weight").hide();
    }
    $("input[name='ruleTemplate']").val($("#rule-template").find("option:selected").val());

    $("#rule-template").attr("disabled", "disabled");
});

function disableInput() {
    $("#mainForm input").attr("disabled", "disabled");
    $("#mainForm textarea").attr("disabled", "disabled");
    $("#mainForm select").attr("disabled", "disabled");
}

function setSelected(select, selectedOptionKey) {
    $(select).find("option").each(function () {
        if ($(this).val() == selectedOptionKey) {
            $(this).attr("selected", "selected");
        }
    });
}

//提供给父页面的回调函数
function wizardFinished() {
    initValidate();
    $("#mainForm").submit();
}

function doEdit() {
    $("#mainForm").attr("action", contextPath + "/rule/dialog/rt_statis_sum/edit.json");
    initValidate();
    $("#mainForm").submit();
}


function doCreate() {  //提交
    var form = $("#mainForm");

    $(form).boxShowLoading();
    $(form).ajaxSubmit({
        type: 'post',
        dataType: 'json',
        complete: function (response) {
            $(form).boxHideLoading();
            handleAjaxResponse(response, function () {
                if ($(form)[0]) {
                    $(form)[0].reset();
                }
                if (oper == 'edit') {
                    hideEditDialog();
                } else {
                    hideCreateDialog();
                }
                gridReload();
            });
        }
    });

}

function initValidate(oper) {
    //校验
    $('#mainForm').validate({
        submitHandler: doCreate,
        rules: {
            ruleName: {
                required: true,
            },
            dimType1: {
                required: true,
            },
            weight: {
                required: true,
                digits: true,
                range: [0, 100]
            }
        },
        errorPlacement: function (error, element) {
            error.insertAfter(element.parent().children().last()); //插在最后一个兄弟节点之后
        }
    });
}

function setMultiSelect(selectCtl, selectedOptionKey) {
    if (undefined != selectedOptionKey) {
        $(selectCtl).multiselect("select", selectedOptionKey.split(","));
    }
}

function getSelectedRow(grid) {
    var selectRow = jQuery("#" + grid).jqGrid('getGridParam', 'selrow');
    if (null == selectRow || undefined == selectRow) {
        alert("请先选择行");
    }
    return selectRow;
}