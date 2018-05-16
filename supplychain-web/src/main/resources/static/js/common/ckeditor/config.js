/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

// 1.修改cheditor.js  搜索cke_upload     将f.id为files  与MultipartFile同名

// 2.image上传接口中要增加ck   callback回调
// OutputStream outputStream = response.getOutputStream();
// String rootURL = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
// String callback = req.getParameter("CKEditorFuncNum").toString();
// StringBuffer stringBuffer = new StringBuffer();
// stringBuffer.append("<script type=\"text/javascript\">").append("window.parent.CKEDITOR.tools.callFunction(").append(callback + ",'" + rootURL).append("/getImage?imagePath=" + fileName + "','')").append("</script>");
// byte[] b = stringBuffer.toString().getBytes("utf-8");
// outputStream.write(b, 0, b.length);
// outputStream.flush();


CKEDITOR.editorConfig = function (config) {
    config.language = 'zh-cn';
    config.image_previewText = ' ';
    config.font_names = '宋体/SimSun;新宋体/NSimSun;仿宋/FangSong;楷体/KaiTi;仿宋_GB2312/FangSong_GB2312;' +
        '楷体_GB2312/KaiTi_GB2312;黑体/SimHei;华文细黑/STXihei;华文楷体/STKaiti;华文宋体/STSong;华文中宋/STZhongsong;' +
        '华文仿宋/STFangsong;华文彩云/STCaiyun;华文琥珀/STHupo;华文隶书/STLiti;华文行楷/STXingkai;华文新魏/STXinwei;' +
        '方正舒体/FZShuTi;方正姚体/FZYaoti;细明体/MingLiU;新细明体/PMingLiU;微软雅黑/Microsoft YaHei;微软正黑/Microsoft JhengHei;' +
        'Arial Black/Arial Black;' + config.font_names;
};
