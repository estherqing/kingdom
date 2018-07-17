package com.esther.code.common.framework.global;
 
public class PropertiesConstant {

	public final static String KEY_LOCAL_URL = "local.url";

	public final static String KEY_STATIC_URL = "static.url";

	public final static String KEY_LOGIN_URL = "login.url";

	/** 发送邮件的账户 */
	public final static String MAIL_USERNAME = "mail.username";

	/** 文件上传地址 */
	public final static String FILE_UPLOAD_PATH = "file_upload_path";
	/**  图片上传地址 */
	public final static String IMG_UPLOAD_PATH = "img_upload_path";
	/** url前缀 */
	public final static String URL_PREFIX = "url_prefix";
	
	public static final String UPLOAD_FILE = "file_upload_path";
	

	public final static String EMAIL_SUFFIX = "email_suffix";

	public static final int SUCCESS = 0;// 成功

	public static final int FAIL = 1;// 失败
	
	public static final int DEFAULT_PAGESIZE = 10;// 默认每页显示条数
	
	/**
	 * 删除标记：已删除
	 */
	public static final int DEL_YES = 0;
	/**
	 * 删除标记：未删除
	 */
	public static final int DEL_NO = 1;
	
	/**
	 * 动态类型：会议
	 */
	public static final Short DYNAMIC_TYPE_MEETING = 1;
	/**
	 * 动态类型：培训
	 */
	public static final Short DYNAMIC_TYPE_TRAIN = 2;
	/**
	 * 动态类型：技术论坛
	 */
	public static final Short DYNAMIC_TYPE_TECHNIQUE = 3;
	/**
	 * 动态类型：培训公告
	 */
	public static final Short DYNAMIC_TYPE_TRAIN_NOTICE = 4;
	
	/**
	 * 动态公开：是
	 */
	public static final Short DYNAMIC_IS_SHOW_NO = 0;
	/**
	 * 动态公开：否
	 */
	public static final Short DYNAMIC_IS_SHOW_YES = 1;
	
	/**
	 * 点赞类型：动态
	 */
	public static final Short PRAISE_TYPE_DYNAMIC = 1;
	/**
	 * 点赞类型：留言
	 */
	public static final Short PRAISE_TYPE_MESSAGE = 2;
	/**
	 * 点赞类型：回复
	 */
	public static final Short PRAISE_TYPE_REPLY = 3;
	
	/**
	 * 评论类型：动态
	 */
	public static final Short COMMENT_TYPE_DYNAMIC = 1;
	/**
	 * 评论类型：合作公司
	 */
	public static final Short COMMENT_TYPE_PARTNER = 2;
	/**
	 * 评论类型：培训
	 */
	public static final Short COMMENT_TYPE_TRAIN = 3;
	/**
	 * 评论类型：专家
	 */
	public static final Short COMMENT_TYPE_EXPERT = 4;
	
	/**
	 * 关注类型：动态
	 */
	public static final int FOCUS_TYPE_DYNAMIC = 1;
	/**
	 * 关注类型：合作公司
	 */
	public static final int FOCUS_TYPE_COMPANY = 2;
	/**
	 * 关注类型：培训机构
	 */
	public static final int FOCUS_TYPE_TRAINING = 3;
	
	/**
	 * 评分类型：技术实力
	 */
	public static final int SCORE_TYPE_TECH = 1;
	
	/**
	 * 评分类型：项目质量
	 */
	public static final int SCORE_TYPE_PROJECT = 2;
	
	/**
	 * 评分类型：服务态度
	 */
	public static final int SCORE_TYPE_SERVICE = 5;
	
	/**
	 * 评分类型：产品质量
	 */
	public static final int SCORE_TYPE_PRODUCT = 3;
	
	/**
	 * 评分类型：工作效率
	 */
	public static final int SCORE_TYPE_EFFICIENCY = 4;
	
	/**
	 * 消息类型：评论
	 */
	public static final Short MESSAGE_TYPE_COMMENT = 1;
	/**
	 * 消息类型：回复
	 */
	public static final Short MESSAGE_TYPE_REPLY = 2;
	/**
	 * 消息类型：@
	 */
	public static final Short MESSAGE_TYPE_A = 3;
	
	/**
	 * 消息阅读状态：未读
	 */
	public static final Short READ_FLAG_NO = 0;
	/**
	 * 消息阅读状态：已读
	 */
	public static final Short READ_FLAG_YES = 1;
	
	/**
	 * 单位：百亿
	 */
	public static final String UNIT_BAIYI = "百亿";
	
	/**
	 * 单位：十亿
	 */
	public static final String UNIT_SHIYI = "十亿";
	
	/**
	 * 单位：亿
	 */
	public static final String UNIT_YI = "亿";
	
	/**
	 * 单位：千万
	 */
	public static final String UNIT_QIANWAN = "千万";
	
	/**
	 * 单位：百万
	 */
	public static final String UNIT_BAIWAN = "百万";
	
	/**
	 * 单位：十万
	 */
	public static final String UNIT_SHIWAN = "十万";
	
	/**
	 * 单位：万
	 */
	public static final String UNIT_WAN = "万"; 
	
}
