

//借助ace中的widget-box-overlay样式实现widget-box中的表单表单提交后的遮罩层。给widget-box中的form绑定方法

(function($){
    $.fn.extend({
        boxShowLoading:function(){
        	var html ='<div class="widget-box-overlay" style="background-color: rgba(0, 0, 0, 0.13);">'+
        				'<div style="padding-top:10%"></div>'+
					  	'<i class="ace-icon loading-icon fa fa-spinner fa-spin fa-3x orange"></i>'+
					  '</div>';
			$(this).closest(".widget-box").append(html);
        },
        boxHideLoading:function(){
			$(this).closest(".widget-box").find(".widget-box-overlay").remove();
        },
    });    
})(jQuery);