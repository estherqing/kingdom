
//处理ajax请求的返回结果，主要是对结果进行判断，查看是否请求成功
function handleAjaxResponse(response, successCallBack, errorCallBack) {
	//支持response为jqXHR和json
	
	//response可能是json，也可能是xhr，不是json格式的才获取responseJSON字段
	if ( response.code==0 ||
		(response.responseJSON && response.responseJSON.code == 0)) {
		if (successCallBack) {
			successCallBack();
		}
		return true;
	} else if(errorCallBack){
        errorCallBack();
	} else {
		var msg = '未知错误。';
		if (response.responseJSON) {
			msg = response.responseJSON.msg;
		} else if (response.msg) {
			msg = response.msg;
		} else if(response.statusText && response.statusText!="success") {
			msg = "网络请求异常，请检查网络或者是查看是否需要重新登陆。";
		} else if(response.responseText) {
			msg = response.responseText;
		} 
		bootbox.alert('操作失败！' + msg);
		return false;
	}
}

$(document).ajaxError(function(e,xhr,opt){
    bootbox.alert('请求数据发生错误，可能是登录超时或者oa鉴权超时，请重试!');
});

