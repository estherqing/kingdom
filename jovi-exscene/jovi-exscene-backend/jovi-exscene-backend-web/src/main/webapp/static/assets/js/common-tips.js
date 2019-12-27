function errorTips(message) {
    if (message === null || message === '') {
        message = "请求错误，请稍后再试！";
    }
    commonTips('red', '失败', message);
}

function successTips(message) {
    if (message === null || message === '') {
        message = "恭喜您，操作成功！";
    }
    commonTips('green', '成功', message);
}

function warningTips(message) {
    if (message === null || message === '') {
        message = "恭喜您，操作成功！";
    }
    commonTips('green', '警告', message);
}

function commonTips(type, title, message) {
    $.confirm({
        theme: 'bootstrap',
        title: title,
        type: type,
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