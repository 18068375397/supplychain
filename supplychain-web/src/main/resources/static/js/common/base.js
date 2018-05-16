//打开loading框
function loading() {
    window.load = top.layer.load(1, {shade: [0.1, '#fff']});
}

//关闭loading框
function loaded() {
    top.layer.close(window.load);
}


/**
 * 获取<input file>的url
 * @param file
 * @returns {*}
 */
function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}


/**
 * 日期范围控件绑定
 *
 * @param 日期控件
 * @returns
 */

function DatePickerOne(beginSelector) {
    // 仅选择日期
    $(beginSelector).datetimepicker({
        format: "yyyy-mm-dd",
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: true,
        todayHighlight: 1,
        startView: 2,
        minView: "month",
        startDate: new Date(),
    })
}

/**
 * 日期范围控件绑定
 *
 * @param 开始日期控件ID
 * @param 结束日期控件ID
 * @returns
 */
function DatePickerRange(beginSelector, endSelector) {

    // 仅选择日期
    $(beginSelector).datetimepicker({
        format: "yyyy-mm-dd",
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: true,
        todayHighlight: 1,
        startView: 2,
        minView: "month",

    }).on(
        'changeDate',
        function (ev) {
            if (ev.date) {
                $(endSelector).datetimepicker('setStartDate',
                    new Date(ev.date.valueOf()))
            } else {
                $(endSelector).datetimepicker('setStartDate', null);
            }
        })

    $(endSelector).datetimepicker({
        format: "yyyy-mm-dd",
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: true,
        todayHighlight: 1,
        startView: 2,
        minView: "month",

    }).on(
        'changeDate',
        function (ev) {
            if (ev.date) {
                $(beginSelector).datetimepicker('setEndDate',
                    new Date(ev.date.valueOf()))
            } else {
                $(beginSelector).datetimepicker('setEndDate', new Date());
            }

        })
}


/**
 * 上传图片  file组件的id
 * @param id
 */
function uploadPic(id) {
    $('#' + id).fileupload({
        url: window.baseUrl + "/upload?random=" + Math.random(),
        dataType: 'json',
        add: function (e, data) {
            // data.context = $('<p/>').text('Uploading...').appendTo(document.body);
            data.submit();
        },
        progressall: function (e, data) {
            // var progress = parseInt(data.loaded / data.total * 100);
        },
        done: function (e, data) {
            // data.context.text('Upload finished.');
            var img = $("#" + id + "_img");
            if (!(window.File || window.FileReader || window.FileList || window.Blob)) {
                img.attr("src", '');
                img.attr("alt", '你的浏览器不支持预览功能');
                return;
            }
            var objUrl = getObjectURL(data.files[0]);
            if (objUrl) {
                img.attr("src", objUrl);
                // $("#imgbig").attr("src", objUrl);
            }
            img.parent().find("#deleteFile").show();

        },
        fail: function (e, data) {

        }

    });
}

/**
 * 日期个事转换
 */
Vue.filter('time', function (value) {
    if (value == "" || value == null) {
        return "";
    }

    var date = new Date(value);
    var Y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    var H = date.getHours();
    var i = date.getMinutes();
    var s = date.getSeconds();
    if (m < 10) {
        m = '0' + m;
    }
    if (d < 10) {
        d = '0' + d;
    }
    if (H < 10) {
        H = '0' + H;
    }
    if (i < 10) {
        i = '0' + i;
    }
    if (s < 10) {
        s = '0' + s;
    }
    var t = Y + '-' + m + '-' + d + ' ' + H + ':' + i + ':' + s;
    return t;
});


/**
 * 获取url中的参数
 * @param name
 * @returns {*}
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r !== null) return unescape(r[2]);
    return null;
}

/**
 * 禁止浏览器F5 刷新页面
 */
// document.onkeydown = function (e) {
//     e = window.event || e;
//     var tabLength=$("#main-ul li").length
//
//     var keycode = e.keyCode || e.which;
//     if (keycode == 116) {
//         if (window.event) {// ie
//             try {
//                 e.keyCode = 0;
//             } catch (e) {
//             }
//             e.returnValue = false;
//         } else {// firefox
//             e.preventDefault();
//         }
//     }
// }
