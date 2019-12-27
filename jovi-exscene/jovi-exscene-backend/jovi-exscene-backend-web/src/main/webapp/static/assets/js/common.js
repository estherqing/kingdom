// 关闭model框时清空所有内容
function closeAndClearModal(modalId) {
    // 自定义命令-推荐命令-命令槽位数限制，关闭时清零
    maxSlotCount = 0;
    //  清空值
    $("#" + modalId + " input[type='text']").val("");
    $("#" + modalId + " input[type='file']").val("");
    $("#" + modalId + " input[type='number']").val("");
    $("#" + modalId + " input[type='email']").val("");
    $("#" + modalId + " input[type='url']").val("");
    $("#" + modalId + " select").find('option').removeAttr('selected');
    //$("#" + modalId + " textarea").text("");

    // 清除错误警告css
    $("#" + modalId + " .form-group").removeClass("has-error");

    /**** 特殊操作 start */
	// 删除应用包名下选项，因为输入名自动查询包名
    $("#" + modalId + " select[name='packageName']").html("");
    // 删除命令添加框手动添加的命令框
    $("#" + modalId + " button[name='deleteLineBtn']").parent().parent().remove();
    // 删除p提示信息
    $("#" + modalId).find("p").html('');
    // 删除闲聊多文件上传域
    $("#" + modalId + " div[name='tmp-row']").remove();
    // 快捷命令页面，根据分类带出应用信息多选框div，手动添加的槽位信息框
    $("#" + modalId + " div[id$='AppNameDivId']").html("");
    $("#" + modalId + " div[id$='ManualSlotDivId']").html("");

    // 推荐命令页面
    $("#" + modalId + " div[id$='ProcessSteps']").html("");

    // 隐藏的button恢复（主要针对发布生产的数据点击编辑按钮时，隐藏提交按钮，不允许提交，目前推荐命令、快捷命令使用）
    $("#" + modalId + " .modal-footer button").show();
    /**** 特殊操作 end */

    var formCount = $("#" + modalId + " form").length;
    if (formCount > 0) {
        for (var i = 0; i < formCount; i++) {
            $("#" + modalId + " form")[i].reset();
        }
    }

    /**** 文件域 **/
    $("#" + modalId + " span.ace-file-name").attr("data-title", "");

    // 关闭model
    $("#" + modalId).modal('hide');
}

function showModalTipeMessage(modalId, message) {
    $("#" + modalId + " .tips-message").html(message);
}

function isURL(strUrl){
    var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
        + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
        + "|" // 允许IP和DOMAIN（域名）
        + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
        + "[a-z]{2,6})" // first level domain- .com or .museum
        + "(:[0-9]{1,4})?" // 端口- :80
        + "((/?)|" // a slash isn't required if there is no file name
        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
    var re = new RegExp(strRegex);
    return re.test(strUrl);
}

function showModal(modalId) {
    $("#" + modalId).modal({backdrop: 'static', keyboard: false}).show();
}

function hideModal(modalId) {
    $("#" + modalId).modal("hide");
}

function warningTips(message) {
    if (message === null || message === '') {
        message = "请求错误，请稍后再试！";
    }
    $.alert({
        theme: 'bootstrap',
        title: '警告',
        type: 'orange',
        animation: 'scale',
        content: message,
        buttons: {
            calcle: {
                text: "确认",
                btnClass: 'btn-warning',
            }
        }
    });
}

function errorTips(message) {
    if (message === null || message === '') {
        message = "请求错误，请稍后再试！";
    }
    $.alert({
        theme: 'bootstrap',
        title: '失败',
        type: 'red',
        animation: 'scale',
        content: message,
        buttons: {
            calcle: {
                text: "确认",
                btnClass: 'btn-danger',
            }
        }
    });
}

function successTips(message) {
    if (message === null || message === '') {
        message = "恭喜您，操作成功！";
    }
    $.alert({
        theme: 'bootstrap',
        title: '成功',
        type: 'green',
        animation: 'scale',
        content: message,
        buttons: {
            calcle: {
                text: "确认",
                btnClass: 'btn-success',
            }
        }
    });
}

function getStatusWithCode(statusCode) {
    if(statusCode == 0) {
        return "删除";
    } else if(statusCode == 1) {
        return "发布测试";
    } else if(statusCode == 2) {
        return "发布生产";
    } else if(statusCode == 3) {
        return "未发布";
    } else if(statusCode == 4) {
        return "未处理";
    } else if(statusCode == 5) {
        return "待验证";
    } else if(statusCode == 6) {
        return "验证不通过";
    } else if(statusCode == 7) {
        return "脚本有误";
    } else if(statusCode == 8) {
        return "采纳";
    } else if(statusCode == 9) {
        return "下线";
    } else if(statusCode == 10) {
        return "上线";
    } else if(statusCode == 11) {
        return "处理中";
    } else if(statusCode == 12) {
        return "测试通过";
    }else if(statusCode == 13) {
        return "预发布生产";
    } else {
        return "未知状态";
    }
}

// 获取0-n的随机数
function getRandom(n){
    return Math.floor(Math.random()*n+1)
}

/**
 * 初始化遮罩框
 * 需要通过.open()打开，.close()关闭
 */
function openLoading() {
    return $.dialog({
        title: '数据提交中，请稍后...',
        cancelButton: false,
        confirmButton: false,
        closeIcon: false,
        content: "<div class='sk-cube-grid'><div class='sk-cube sk-cube1'></div><div class='sk-cube sk-cube2'></div><div class='sk-cube sk-cube3'></div><div class='sk-cube sk-cube4'></div><div class='sk-cube sk-cube5'></div><div class='sk-cube sk-cube6'></div><div class='sk-cube sk-cube7'></div><div class='sk-cube sk-cube8'></div><div class='sk-cube sk-cube9'></div></div>",
        lazyOpen: true,
    });
}
